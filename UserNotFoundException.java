public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Integer id) {
        super("User don't exist : " + id);
    }
    
}
