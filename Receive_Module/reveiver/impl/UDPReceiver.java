package Z_Receive_Module.reveiver.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.util.ReadProp;
import Z_Receive_Module.vo.Vo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver extends DataReceiver {
    public UDPReceiver(DataParser parser) {
        super(parser);
    }
    @Override
    public void receive(DataParser parser) {
        System.out.println("sub Thread "+Thread.currentThread().getName());
        DatagramSocket socket = null;
        int receivePort = Integer.parseInt(ReadProp.UDP_PORT);
        try {
            socket = new DatagramSocket(receivePort);
            // 버퍼 크기 1024 설정
            byte[] receiveData = new byte[1024];
            System.out.println("receive port:" + receivePort);
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
//                System.out.println("receiveMessage: " + receivedMessage);

                parser.parse(receivedMessage);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }
}
