// Create a class IPPacket. This class should contain a simple int which is the packet number, with appropriate constructor, accessor and mutator.

public class IPPacket {
    private int packetNumber;

    IPPacket(int packetNumber) {
        this.packetNumber = packetNumber;
    }

    public int getPktNumber() {
        return packetNumber;
    }
}
