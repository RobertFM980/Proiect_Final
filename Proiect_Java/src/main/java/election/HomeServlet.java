package election;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidat> candidati = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM candidati";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Candidat candidat = new Candidat();
                candidat.setId(rs.getInt("id"));
                candidat.setNume(rs.getString("nume"));
                candidat.setPrenume(rs.getString("prenume"));
                candidat.setPartid(rs.getString("partid"));
                candidat.setPoza(rs.getString("poza"));
                candidat.setNumarVoturi(rs.getInt("numar_voturi"));
                candidati.add(candidat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("candidati", candidati);
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }
}