package Z_Receive_Module.vo.impl;

import Z_Receive_Module.vo.Vo;

public class UD4M_Centering_Data implements Vo {
    private String dateTime; //이벤트 날짜  2009-06-15T13:45:30.6175000 , 시간을 초단위로 변환하여 PK로 사용
    private int pcId; //UD4M 전송 클라이언트 PC
    private int leftStatus; // Null,L 이나 정상:0, 위험:1  로 변경
    private int rightStatus; // Null,R 이나 정상:0, 위험:1  로 변경
    private int centerStatus; // Null,F,B 이나 정상:0, 위험:1  로 변경
    private int alarmStatus; // Null,T,F 이나 정상:0, 위험:1 로 변경
    private String chkSum; //가변, 무결성 검증, 데이터 폐기 판단
}
