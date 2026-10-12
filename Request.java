public class Request {
    private int id;

    Request(int id){
        this.id = id;
    }

    int getId(){
        return id;
    }
    
    static void process(Request request) {
    System.out.println("ENTER process");
    System.out.println("ID P: " + request.getId());
    System.out.println(
            "Identity: " + System.identityHashCode(request)
    );

    inspect(request);

    System.out.println("EXIT process");
}
    static void inspect(Request request){
        System.out.println("Inside inspect:");
        System.out.println("ID I: " + request.getId());
        System.out.println("Identity: " + System.identityHashCode(request));
    }

     public static void main(String[] args) {
        Request first = new Request(201);
       


        
        System.out.println("ID: " + first.getId());
        System.out.println(
                "Identity: " + System.identityHashCode(first)
        );
      
        
         process(first);

         
        
     }
}
