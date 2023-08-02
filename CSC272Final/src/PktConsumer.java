// Write a class which is a Runnable type called PktConsumer class. Make the packet consumer object run at random intervals of time and remove the IPPackets from the switch object by calling removePkt. Everytime a packet is removed print out the packet number of the removed packet, and that it was removed. The consumed packet should be removed from the Switch objects packetQueue.

public class PktConsumer implements Runnable{

    private Switch switchObj;
    boolean running = true;

    PktConsumer(Switch switchObj) {
        this.switchObj = switchObj;
    }

    @Override
    public void run() {
        while (running) {
            if (switchObj.getPktQueueSize() > 0) {
                int index = 0;
                IPPacket packet = switchObj.getPktNumber(index);
                switchObj.removePkt(index);
                System.out.println("Packet number " + packet.getPktNumber() + " removed.");
            }
            try { Thread.sleep((long) (Math.random() * 2000)); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }   
    }
}
