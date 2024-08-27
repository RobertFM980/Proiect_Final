package election;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signup".equals(action)) {
            String email = request.getParameter("email");
            String parola = request.getParameter("parola");
            String scannedData = request.getParameter("scannedData");

            try (Connection conn = DatabaseUtil.getConnection()) {
                String sql = "INSERT INTO votanti (email, parola, scanned_data) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, parola);  // Parola ar trebui să fie hashed în practică
                stmt.setString(3, scannedData);
                stmt.executeUpdate();
                response.sendRedirect("login.jsp?message=Account created successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("signup.jsp?error=Could not create account");
            }
        } else if ("login".equals(action)) {
            // Logica de logare
        }
    }
}