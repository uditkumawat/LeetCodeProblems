package code.designpatterns.chainOfResponsibility;

public abstract class LoggerProcessor {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LoggerProcessor nextLoggerProcessor;

    LoggerProcessor(LoggerProcessor loggerProcessor){
        this.nextLoggerProcessor = loggerProcessor;
    }

    public void log(int logLevel,String message){
        if(nextLoggerProcessor!=null){
            nextLoggerProcessor.log(logLevel,message);
        }
    }

}
