package Z_Receive_Module.parser;

import Z_Receive_Module.repository.DataRepository;
import Z_Receive_Module.vo.Vo;

public abstract class DataParser {
    protected DataRepository db;

    public DataParser(DataRepository db){
        this.db = db;
    }

    public abstract void parse(Object obj);
}
