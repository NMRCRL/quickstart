import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoinServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String  password=req.getParameter("password");
        req.setAttribute("username",username);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
//        HttpSession session=req.getSession();
//        session.setAttribute("username",username);
        resp.sendRedirect("index.jsp");
    }
}
