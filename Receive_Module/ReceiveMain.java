package Z_Receive_Module;

import Z_Receive_Module.repository.impl.LogFileAppender;
import Z_Receive_Module.reveiver.impl.UDPReceiver;

public class ReceiveMain {
    public static void main(String[] args) {

        System.out.println("시작");
        System.out.println("Main Thread : "+Thread.currentThread().getName());

//        Thread receiver = new APIReceiver(new UD4M_centering());
//        Thread receiver = new TCPReceiver(new UD4M_centering());
        Thread receiver = new UDPReceiver(new Z_Receive_Module.parser.impl.ParseLogic1(new LogFileAppender()));
        receiver.start();
    }
}
