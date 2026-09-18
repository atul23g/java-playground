
public interface UserRepository{
    void save(User user);

    User findById(Integer id);
}