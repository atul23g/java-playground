
public class Main {
    public static void main(String[] args) {
        
        
        User user1 = new User(1, "Atulya", "atulya.is22@", new Organization("IBM"));
        User user2 = new User(2, "Vishal", "vishal.is22@", new Organization("IBM"));
        User user3 = new User(3, "Ram", "ram.is22@", new Organization("Google"));
        
        UserRepository repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);

        service.saveUser(user1);
        service.saveUser(user2);
        service.saveUser(user3);
        //service.saveUser(user1);

        User foundUser = service.findUserById(2);
        System.out.println(foundUser.getName());
        

        


    }
}