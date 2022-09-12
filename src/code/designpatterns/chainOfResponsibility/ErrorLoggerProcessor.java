package code.designpatterns.chainOfResponsibility;

public class ErrorLoggerProcessor extends LoggerProcessor{

    ErrorLoggerProcessor(LoggerProcessor nextLoggerProcessor){
        super(nextLoggerProcessor);
    }

    public void log(int loglevel,String message){
        if(loglevel==ERROR){
            System.out.println("ERROR : "+message);
        }
        else{
            super.log(loglevel,message);
        }
    }
}
