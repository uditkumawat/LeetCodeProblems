package code.designpatterns.chainOfResponsibility;

public class DebugProcessor extends LoggerProcessor{

    DebugProcessor(LoggerProcessor loggerProcessor) {
        super(loggerProcessor);
    }

    public void log(int logLevel,String message){
        if(logLevel==DEBUG){
            System.out.println("DEBUG :"+message);
        }
        else{
            super.log(logLevel,message);
        }
    }

}
