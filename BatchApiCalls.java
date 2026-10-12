import java.util.*;
import java.util.concurrent.*;

public class BatchApiCalls {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<CompletableFuture<String>> tasks = new ArrayList<>();

        // Submit 6 tasks.
        for (int i = 1; i <= 6; i++) {
            final int id = i;

            CompletableFuture<String> task =
                CompletableFuture.supplyAsync(() -> {
                    if (id == 2 || id == 5) {
                        throw new RuntimeException("API unavailable");
                    }
                    return "SUCCESS: Call " + id;
                }, pool).handle((result, error) -> {
                    if (error != null) {
                        return "FAILED: Call " + id + " — "
                            + error.getCause().getMessage();
                    }
                    return result;
                });

            tasks.add(task);
        }

        pool.shutdown();

        int success = 0;
        int failed = 0;

        // Read results after submitting all tasks.
        for (CompletableFuture<String> task : tasks) {
            String result = task.join();
            System.out.println(result);

            if (result.startsWith("SUCCESS")) {
                success++;
            } else {
                failed++;
            }
        }

        System.out.println("Successful: " + success);
        System.out.println("Failed: " + failed);
    }
}