import java.util.*;
public class InMemoryUserRepository implements UserRepository{
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public void save(User user) {
       if(users.containsKey(user.getId())){
        throw new DuplicateUserException(user.getId());
       }

       users.put(user.getId(), user);
        
    }

    @Override 
    public User findById(Integer id){
        if(users.get(id) == null){
            throw new UserNotFoundException(id);
        }
        return users.get(id);
    }
}
