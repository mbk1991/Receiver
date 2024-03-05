package Z_Receive_Module.util;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class UtilClass {

	private static boolean VERBOSE_MODE = false;

	public synchronized static String getCurrentLogTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd.HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		return sdf.format(cal.getTime());
	}

	
	public synchronized static String getCurrentTime(String type) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		return sdf.format(cal.getTime());
	}


    public synchronized static void log_msg(String logFile, String sMsg) {  	
    	
    	PrintWriter pw = null;
    	try {
    		pw = new PrintWriter(new FileWriter(logFile, true), true);
    		pw.println("["+getCurrentLogTime()+"] " + sMsg);
    		pw.flush();
    	} catch (IOException e) {
    		System.out.println("Error: log_msg(): " + e.getMessage());
    	} finally {
    		try {
    			if ( pw != null) pw.close();
    		} catch (Exception e){}
    	}
    	
    	if ( VERBOSE_MODE ) {
    		System.out.println("["+getCurrentLogTime()+"] " + sMsg);
    	}
    }

    public static void main(String[] args) {
    }
}
