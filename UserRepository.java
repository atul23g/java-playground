import java.util.*;

public interface UserRepository{
    void save(User user);

    User findById(Integer id);

    Optional<User> findActiveByEmail(String email);
}