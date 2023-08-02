import java.security.SecureRandom;
import java.util.List;

public class SortingThread implements Runnable{

    private final static SecureRandom rTime = new SecureRandom();
    private List<RngThread> threads = null;
    private String threadName;
    private int time;
    private boolean isRunning = false;

    SortingThread(String n, int t, List<RngThread> threads) {
        this.threadName = n;
        this.time = t;
        this.threads = threads;
        isRunning = true;
    }

    private int setTime() {
        time = rTime.nextInt(1, 20000);
        return time;
    }

    @Override
    public void run() {
        while(isRunning) { 
            synchronized (threads) {
                System.out.println("Sorting threads...");
                for(RngThread t : threads) {
                    t.sortQueue();
                    System.out.println(t.getThreadName() + " size: " + t.getQueueSize());
                }
                System.out.println();
            }    
            try {
                Thread.sleep(setTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }

    public void stop() {
        isRunning = false;
        System.out.println(threadName + " stopped\n");
    }    
}
