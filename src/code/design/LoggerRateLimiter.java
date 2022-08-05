package code.design;

import java.util.HashMap;
import java.util.Map;

//TC - O(1)
//SC - O(N)
//https://leetcode.com/problems/logger-rate-limiter/
public class LoggerRateLimiter {

    private Map<String,Integer> map;

    public static void main(String args[]){
        LoggerRateLimiter obj = new LoggerRateLimiter();
        System.out.println(obj.shouldPrintMessage("foo",1));
        System.out.println(obj.shouldPrintMessage("bar",2));
        System.out.println(obj.shouldPrintMessage("foo",3));
        System.out.println(obj.shouldPrintMessage("bar",8));
        System.out.println(obj.shouldPrintMessage("foo",10));
        System.out.println(obj.shouldPrintMessage("foo",11));
    }
    public LoggerRateLimiter(){
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(String str,int timestamp){

        if(!this.map.containsKey(str)){
            this.map.put(str,timestamp);
            return true;
        }

        int oldTimestamp = map.get(str);
        if(timestamp-oldTimestamp>=10){
            this.map.put(str,timestamp);
            return true;
        }
        else{
            return false;
        }
    }
}
