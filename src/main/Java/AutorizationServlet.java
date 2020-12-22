import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auto")
public class AutorizationServlet extends HttpServlet {

    InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryStorage.getByLogin(login);
        if (byLogin != null){
            if (byLogin.getPassword().equals(password)){
                req.getSession().setAttribute("user", byLogin);
            }
        }
    }
}
