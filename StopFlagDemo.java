public class StopFlagDemo {
    static volatile boolean running = true;

    public static void main(String[] args)throws InterruptedException {
        
        Thread worker = new Thread(() -> {
            while(running){

            }
        });
        worker.setDaemon(true);
        worker.start();

        Thread.sleep(1000);

        running = false;

        worker.join(2000);

        System.out.println(worker.isAlive() == true);
    } 
}
