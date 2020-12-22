import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class Registration extends HttpServlet {

    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name,login,password);
        inMemoryStorage.save(user);
    }
}
