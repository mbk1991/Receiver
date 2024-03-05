package Z_Receive_Module.parser.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.repository.DataRepository;
import Z_Receive_Module.vo.Vo;
import Z_Receive_Module.vo.impl.UD4M_Centering_Data;

public class ParseLogic1 extends DataParser {
    DataRepository db;

    public ParseLogic1(DataRepository db) {
        super(db);
    }

    @Override
    public void parse(Object obj) {
        String msg = (String)obj;
        Vo UD4M_Centering_Data = new UD4M_Centering_Data();

//        super.db.insert(UD4M_Centering_Data);
        super.db.insert(msg);
    }
}
