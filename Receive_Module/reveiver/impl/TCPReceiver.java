package Z_Receive_Module.reveiver.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.util.ReadProp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver extends DataReceiver {
    public TCPReceiver(DataParser parser) {
        super(parser);
    }
    @Override
    public void receive(DataParser parser) {

        System.out.println("여긴누구나는어디");
        System.out.println("sub Thread "+Thread.currentThread().getName());

        // 포트 번호 9876으로 서버 소켓 생성
        int receivePort = Integer.parseInt(ReadProp.TCP_PORT);
        try (ServerSocket serverSocket = new ServerSocket(receivePort)) {
            System.out.println("서버 시작... 포트: " + receivePort);

            // 클라이언트 연결 대기
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

            // 클라이언트로부터 데이터 수신을 위한 입력 스트림 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // 클라이언트로부터 수신된 데이터 출력
            String receivedMessage;
            while ((receivedMessage = in.readLine()) != null) {
                System.out.println("수신된 메시지: " + receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
