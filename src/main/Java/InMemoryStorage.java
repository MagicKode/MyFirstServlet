import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    public static List<User> users = new ArrayList<>();

    static int userId;

    public void save(User user){
        user.setId(userId);
        users.add(user);
        userId++;
    }

    public User getByLogin(String login){
        for (User user:users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
