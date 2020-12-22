import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class ChangeNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User)req.getSession().getAttribute("user");

        if (user.getName() != null){
            resp.getWriter().println("Your old name is "+user.getName());
            user.setName(req.getParameter("name"));
            resp.getWriter().println("Your new name is "+user.getName());
        }else if(user.getName() == null){
            resp.getWriter().println("Your name is AMPTY");
        }
    }
}
