public class Main {
    public static void main(String[] args) {
        
        
        User user1 = new User("Atulya", "atulya.is22@", new Organization("IBM"));
        

        System.out.println(user1.getName());
        System.out.println(user1.getEmail());
        System.out.println(user1.getOrganization().getName());


    }
}