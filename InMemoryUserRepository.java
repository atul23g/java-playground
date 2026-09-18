import java.util.*;
public class InMemoryUserRepository implements UserRepository{
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public void save(User user) {
       if(users.containsKey(user.getId())){
        throw new IllegalArgumentException("User already exist");
       }

       users.put(user.getId(), user);
        
    }

    @Override 
    public User findById(Integer id){
        return users.get(id);
    }
}
