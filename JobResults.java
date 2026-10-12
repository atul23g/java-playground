
import java.util.concurrent.ConcurrentHashMap;

public class JobResults {
    public static void main(String[] args) throws InterruptedException {
    ConcurrentHashMap<Integer, String> results=  new ConcurrentHashMap<>();

    Thread A = new Thread(() -> {
        for (int id = 0; id < 1000; id++) {
            results.put(id, "Completed");
        }
    });
    Thread B = new Thread(() -> {
            for (int id = 1000; id < 2000; id++) {
                results.put(id, "Completed");
            }
        });

    A.start();
    B.start();

    A.join();
    B.join();

    int missing = 0;

    for (int i = 0; i < 2000; i++) {
        if(results.get(i) != "Completed"){
            missing++;
        }
    }

     System.out.println("Total results: " + results.size());
        System.out.println("Missing or incorrect: " + missing);


}
}
