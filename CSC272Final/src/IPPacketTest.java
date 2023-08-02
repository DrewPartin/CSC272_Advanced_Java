import java.util.Timer;
import java.util.TimerTask;

// Write a main and create a PktConsumer and PktProducer thread and a Timer task thread as taught in class and run the program for 1 min – show screen shot.

public class IPPacketTest {
    public static void main(String[] args) throws Exception {
        Switch switchObj = new Switch();
        PktProducer pktProducer = new PktProducer(switchObj);
        PktConsumer pktConsumer = new PktConsumer(switchObj);
        Thread producerThread = new Thread(pktProducer);
        Thread consumerThread = new Thread(pktConsumer);
        producerThread.start();
        consumerThread.start();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pktProducer.running = false;
                pktConsumer.running = false;
                producerThread.interrupt();
                consumerThread.interrupt();
                timer.cancel();
                System.out.println("Timer task finished.");
                System.out.println("switchObj.getPktQueueSize() = " + switchObj.getPktQueueSize());
            }
        }, 600000);
    }

    // Run the packet producer and consumer threads objects for 2 mins, stop and report the size of the queue at the end of run.

    // Run the same test for 4, 6, 8, and 10 minutes separately and report the size of the queue at the end of each run – show screen shot of runs.

    // Implement a mechanism such that the Switch objects packetQueue size does not exceed 10 packets, i.e. the number of packets waiting to be pulled by the PktConsumer is never more than 10, ensuring that the oldest packets are still processed. Explain your design.    
}
