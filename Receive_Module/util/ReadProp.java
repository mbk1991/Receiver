package Z_Receive_Module.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
    private static Properties prop = new Properties();
    public final static String UDP_PORT;
    public final static String TCP_PORT;
    public final static String API_URL;
    public final static String API_POLLING_CYCLE;
    public final static String API_HTTP_METHOD;
    public final static String CONTENT_TYPE;
    public final static String CONNECT_TIMEOUT;

    private ReadProp(){}

    static{
        try{
            if(System.getProperty("os.name").contains("Window")){
                prop.load(new FileInputStream("./Receive_Module/info.properties"));
            }else{
                prop.load(new FileInputStream("../Receive_Module/info.properties"));
            }
            UDP_PORT = prop.getProperty("udp_port");
            TCP_PORT = prop.getProperty("tcp_port");
            API_URL = prop.getProperty("api_url");
            API_POLLING_CYCLE = prop.getProperty("api_polling_cycle");
            API_HTTP_METHOD = prop.getProperty("api_http_method");
            CONTENT_TYPE = prop.getProperty("content_type");
            CONNECT_TIMEOUT = prop.getProperty("connect_timeout");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
