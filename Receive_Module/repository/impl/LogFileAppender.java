package Z_Receive_Module.repository.impl;

import Z_Receive_Module.repository.DataRepository;
import Z_Receive_Module.vo.Vo;

public class LogFileAppender implements DataRepository {
    @Override
    public void insert(Vo vo) {
        System.out.println("vo = " + vo);
    }

}
