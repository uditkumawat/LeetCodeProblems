package code.designpatterns.singleton;

public class Logger {

    static int counter;
    static Logger loggerInstance;
    private Logger(){
        counter++;
        System.out.println("Logger Instance created "+counter);
        loggerInstance = null;
    }

    public static Logger getLoggerInstance(){
        if(loggerInstance==null) {
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
                return loggerInstance;
            }
        }
        return loggerInstance;
    }

    public void log(String msg){
        System.out.println(msg);
    }
}
