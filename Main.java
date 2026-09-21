public class Main {

    public static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);

        User user = new User(
                1,
                "Atulya",
                "atulya.is22@example.com",
                new Organization("IBM")
        );

        service.saveUser(user);

        User foundUser = service.findUserById(1);
        System.out.println(
                "Lookup successful — ID: "
                        + foundUser.getId()
                        + ", Name: "
                        + foundUser.getName()
        );

        User duplicateUser = new User(
                1,
                "Vishal",
                "vishal.is22@example.com",
                new Organization("IBM")
        );

        try {
            service.saveUser(duplicateUser);
        } catch (DuplicateUserException exception) {
            System.out.println(
                    "Duplicate rejected — " + exception.getMessage()
            );
        }

        try {
            service.findUserById(4);
        } catch (UserNotFoundException exception) {
            System.out.println(
                    "Missing user rejected — " + exception.getMessage()
            );
        }

        System.out.println("All verification paths completed.");
    }
}