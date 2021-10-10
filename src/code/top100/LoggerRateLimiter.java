package code.top100;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    Map<String,Integer> msgMap;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        msgMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.msgMap.containsKey(message)){
            this.msgMap.put(message,timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgMap.get(message);
        if(timestamp-oldTimestamp>=10){
            this.msgMap.put(message,timestamp);
            return true;
        }
        else{
            return false;
        }
    }
}
