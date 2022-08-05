package code.designpatterns.singleton;

public class Runner {

    public static void main(String args[]){

        Logger logger1 = Logger.getLoggerInstance();
        logger1.log("Hello 1");

        Logger logger2 = Logger.getLoggerInstance();
        logger2.log("Hello 2");

    }
}
