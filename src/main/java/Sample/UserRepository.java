package Sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Liu Hao on 6/3/16.
 */
public interface UserRepository extends JpaRepository<User, UserPK> {
    @Query("select u from Sample.User u where u.firstName = ?1 or u.lastName = ?1")
    List<User> findByFirstNameOrLastName(String keyword);
}
