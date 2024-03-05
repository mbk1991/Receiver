package Z_Receive_Module.reveiver.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.util.ReadProp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class APIReceiver extends DataReceiver {
    public APIReceiver(DataParser parser) {
        super(parser);
    }

    @Override
    public void receive(DataParser parser) {
        try {
            for(int i=0;;) {
                requestURL();
                Thread.sleep(1000);
            }
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    void requestURL() {
        System.out.println("sub Thread " + Thread.currentThread().getName());
        try {
            URL url = new URL(ReadProp.API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(ReadProp.API_HTTP_METHOD);
            connection.setRequestProperty("Content-Type", ReadProp.CONTENT_TYPE);
            connection.setConnectTimeout(Integer.parseInt(ReadProp.CONNECT_TIMEOUT));

            String requestBodyData = "{\"sector_id\":3,\"token\":\"test code\"}";
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBodyData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
//                in.close();
                System.out.println("응답 데이터: " + response.toString());
            } else {
                System.out.println("HTTP 요청 실패");
            }
//            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
