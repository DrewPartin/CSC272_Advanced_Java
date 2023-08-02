// Create a class that is a Runnable type of object called Pktproducer.  Make this thread produce IPPacket objects, each new packet should have a monotonically increasing packet number. Packets should be created at random time intervals and placed in the Switch by calling insertPkt thus simulating the arrival of IP packets into the switch object. Every time a packet arrives print out the packet number of the inserted packet, and that it was inserted from the insertPkt function of the switch.

public class PktProducer implements Runnable {

    private int packetNumber = 0;
    private Switch switchObj;
    boolean running = true;

    PktProducer(Switch switchObj) {
        this.switchObj = switchObj;
    }

    @Override
    public void run() {
        while (running) {
            if (switchObj.getPktQueueSize() < 10) {
                IPPacket packet = new IPPacket(packetNumber);
                switchObj.insertPkt(packet);
                System.out.println("Packet number " + packet.getPktNumber() + " inserted from the insertPkt function of the switch.");
                packetNumber = switchObj.getPktQueueSize() - 1;
            }
            try { Thread.sleep((long) (Math.random() * 2000)); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}
