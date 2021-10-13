import com.dyx.dao.UserDao;
import com.dyx.domain.User;
import org.junit.Test;

public class UserDaoTest {



    @Test
    public void test(){

        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);

        System.out.println(loginUser.toString());

    }
}
