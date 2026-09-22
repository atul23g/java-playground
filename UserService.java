import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public  User findUserById(Integer id){
        
        return userRepository.findById(id);
    }
    public Optional<User> findActiveUserByEmail(String email){
        return userRepository.findActiveByEmail(email);
    }

}
