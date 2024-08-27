package election;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/voteaza")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("votantId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int votantId = (int) session.getAttribute("votantId");
        int candidatId = Integer.parseInt(request.getParameter("candidatId"));

        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO voturi (votant_id, candidat_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, votantId);
            stmt.setInt(2, candidatId);
            stmt.executeUpdate();

            String updateVotes = "UPDATE candidati SET numar_voturi = numar_voturi + 1 WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateVotes);
            updateStmt.setInt(1, candidatId);
            updateStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("home");
    }
}