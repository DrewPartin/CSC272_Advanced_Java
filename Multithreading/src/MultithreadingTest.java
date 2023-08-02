import java.util.Arrays;

public class MultithreadingTest {
    public static void main(String[] args) throws Exception {
        
        RngThread thread1 = new RngThread("Thread 1", 5, 10, 9000);
        RngThread thread2 = new RngThread("Thread 2", 15, 20, 12000);
        RngThread thread3 = new RngThread("Thread 3", 25, 30, 15000);
        RngThread thread4 = new RngThread("Thread 4", 35, 40, 18000);
        RngThread thread5 = new RngThread("Thread 5", 45, 50, 20000);
        SortingThread thread6 = new SortingThread("Thread 6", 200, Arrays.asList(thread1, thread2, thread3, thread4, thread5));

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        Thread t4 = new Thread(thread4);
        Thread t5 = new Thread(thread5);
        Thread t6 = new Thread(thread6);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        System.out.println("\nPlease wait 5 minutes for threads to run...\n");
        Thread.sleep(300000); // set time to 300000 for 5 minutes

        thread6.stop();
        thread1.stop();
        thread2.stop();
        thread3.stop();
        thread4.stop();
        thread5.stop();
    }
}
