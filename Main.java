import java.util.*;
import java.util.function.Predicate;


public class Main {
    

    public static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);

        User user1 = new User(
                1,
                "Atulya",
                "atulya.is22@example.com",
                new Organization("IBM"),
                true
        );
        User user2 = new User(
                2,
                "Vishal",
                "vishal.is22@example.com",
                new Organization("Google"),
                true
        );

        service.saveUser(user1);
        service.saveUser(user2);

        Predicate<User> hasCompanyEmail =
        candidate -> candidate.getEmail().endsWith("@ibm.com");

        boolean result = hasCompanyEmail.test(user1);
        //System.out.println(result);

        List<User> users = List.of(user1, user2);

        // List<String> results = users.stream()
        //                             .filter(user -> user.isActive())
        //                             .map(user -> user.getName())
        //                             .collect(Collectors.toList());
        // System.out.println(results);
        String name = service.findActiveUserByEmail("vishal.is22@example.com").map(user -> user.getName()).orElse("User Not Found");

        System.err.println(name);

        

        

      
        


    }
}