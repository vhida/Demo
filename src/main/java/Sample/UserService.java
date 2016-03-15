package Sample;

import java.util.List;

/**
 * Created by Liu Hao on 5/3/16.
 */
public interface UserService {
     User save(User user);
     List<User> search(String keyword);
}
