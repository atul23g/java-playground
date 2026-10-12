public class RaceConditionDemo {
    private int value = 0;

    public void incrementUnsafe() {
        int current = value;
        Thread.yield(); // Widens the race window for demonstration
        value = current + 1;
    }

    public synchronized void incrementSafe() {
        int current = value;
        Thread.yield();
        value = current + 1;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        int incrementsPerThread = 100_000;
        int expected = incrementsPerThread * 2;

        // Unsafe experiment
        RaceConditionDemo unsafeCounter = new RaceConditionDemo();

        Thread unsafeA = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                unsafeCounter.incrementUnsafe();
            }
        });

        Thread unsafeB = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                unsafeCounter.incrementUnsafe();
            }
        });

        unsafeA.start();
        
        unsafeB.start();

        unsafeA.join();
        unsafeB.join();

        // Safe experiment
        RaceConditionDemo safeCounter = new RaceConditionDemo();

        Thread safeA = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                safeCounter.incrementSafe();
            }
        });

        Thread safeB = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                safeCounter.incrementSafe();
            }
        });

        safeA.start();
        safeB.start();

        safeA.join();
        safeB.join();

        System.out.println("Expected:      " + expected);
        System.out.println("Unsafe actual: " + unsafeCounter.getValue());
        System.out.println("Safe actual:   " + safeCounter.getValue());
    }
}