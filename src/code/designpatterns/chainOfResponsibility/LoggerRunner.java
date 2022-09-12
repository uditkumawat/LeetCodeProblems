package code.designpatterns.chainOfResponsibility;

//https://www.youtube.com/watch?v=gvIn5QBdGDk&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=10
//https://www.youtube.com/watch?v=gvIn5QBdGDk&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=10
public class LoggerRunner {


    public static void main(String args[]){

        LoggerProcessor logger = new InfoLoggerProcessor(new ErrorLoggerProcessor(null));

        logger.log(LoggerProcessor.INFO,"Hello");
        logger.log(LoggerProcessor.ERROR,"Hello error");

    }
}
