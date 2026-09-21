public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(Integer id) {
        super("User already exist with Id: " + id) ;
    }
    
}
