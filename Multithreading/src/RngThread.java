import java.security.SecureRandom;
import java.util.ArrayList;

public class RngThread implements Runnable{

    private ArrayList<Double> numQueue = new ArrayList<>();
    private final static SecureRandom rng = new SecureRandom();
    private String threadName;
    private final double max;
    private final double min;
    private int time;
    private boolean isRunning = true;
    private boolean isSorted = false;

    RngThread(String name, double min, double max, int time) {
        this.threadName = name;
        this.max = max;
        this.min = min;
        this.time = time;
    }

    private void isSorted(ArrayList<Double> q) {
        for(int i = 0; i < q.size() - 1; i++){
            if(q.get(i) > q.get(i + 1)){
                isSorted = false;
                break;
            }
            isSorted = true;
        }
    }

    public String getThreadName() {
        return threadName;
    }

    public String getQueueSize() {
        return String.valueOf(numQueue.size());
    }

    public synchronized void sortQueue() {
        for(int i = 0; i < numQueue.size() - 1; i++){
            for(int j = 0; j < numQueue.size() - 1; j++){
                if(numQueue.get(j) > numQueue.get(j + 1)){
                    double temp = numQueue.get(j);
                    numQueue.set(j, numQueue.get(j + 1));
                    numQueue.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void run() {
        while(isRunning) {
            synchronized (numQueue) {
            double num = (double) Math.round((rng.nextDouble() * (max - min) + min) * 100d) / 100d;
            numQueue.add(num);
            isSorted(numQueue);
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }

    public void stop() {
        isRunning = false;
        System.out.println(threadName + " stopped");
        System.out.println(threadName + " size: " + numQueue.size());
        isSorted(numQueue);
        System.out.println(threadName + " is sorted: " + isSorted);
        System.out.println(threadName + " numbers: " + numQueue + "\n");
    }
}
