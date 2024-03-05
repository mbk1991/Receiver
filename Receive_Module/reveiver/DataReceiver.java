package Z_Receive_Module.reveiver;

import Z_Receive_Module.parser.DataParser;

public abstract class DataReceiver extends Thread {
    protected DataParser parser;
    protected DataReceiver(DataParser parser){
        this.parser = parser;
    }
   protected abstract void receive(DataParser parser);
    @Override
    public void run(){
        receive(parser);
    }
}
