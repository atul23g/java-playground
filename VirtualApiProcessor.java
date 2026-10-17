import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualApiProcessor {
    static AtomicInteger successes = new AtomicInteger();
    static AtomicInteger retries = new AtomicInteger();
    static AtomicInteger failures = new AtomicInteger();

    static void runJob() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            if (attempt > 1) {
                retries.incrementAndGet();
            }

            try {
                Thread.sleep(100); // Pretend to wait for an API
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                failures.incrementAndGet();
                return;
            }

            // 70% chance of success
            boolean success =
                    ThreadLocalRandom.current().nextInt(10) < 7;

            if (success) {
                successes.incrementAndGet();
                return;
            }
        }

        failures.incrementAndGet(); // All 3 attempts failed
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        try (var executor =
                Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 1000; i++) {
                executor.submit(() -> runJob());
            }
        } // Wait for all jobs and close the executor

        long elapsed = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Successes: " + successes.get());
        System.out.println("Retries: " + retries.get());
        System.out.println("Failures: " + failures.get());
        System.out.println("Time: " + elapsed + " ms");
    }
}