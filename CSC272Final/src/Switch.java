// Create a class Switch that internally uses an an array like structure or an Array List of IPPackets to hold incoming packet objects; call this structure used to store packets in the Switch object packetQueue.

import java.util.ArrayList;

public class Switch {
    public ArrayList<IPPacket> packetQueue = new ArrayList<IPPacket>();

    public void insertPkt(IPPacket packet) {
        packetQueue.add(packet);
    }

    public IPPacket getPktNumber(int index) {
        return packetQueue.get(index);
    }

    public void removePkt(int index) {
        packetQueue.remove(index);
    }

    public int getPktQueueSize() {
        return packetQueue.size();
    }
}
