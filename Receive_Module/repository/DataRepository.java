package Z_Receive_Module.repository;

import Z_Receive_Module.util.UtilClass;
import Z_Receive_Module.vo.Vo;

public interface DataRepository {
    public abstract void insert(Vo vo);
    default public void insert(String msg){
        System.out.println("msg = " + msg);
        if(System.getProperty("os.name").toLowerCase().contains("window")){
            UtilClass.log_msg("./log/test" + UtilClass.getCurrentTime("yyyyMmdd") + ".log", msg);
        }else{
            UtilClass.log_msg("../log/test" + UtilClass.getCurrentTime("yyyyMmdd") + ".log", msg);
        }
    }
}
