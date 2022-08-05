package code.bloomberg;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-underground-system/submissions/
//TC - O(1)
//SC - O(Number of arrivals + number of averages)
public class DesignUndergroundSystem {


    Map<Integer,Event> arrivals;
    Map<String,Average> system;

    public DesignUndergroundSystem() {
        this.arrivals = new HashMap();
        this.system = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id,new Event(id,stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        if(arrivals.containsKey(id)){
            Event event = arrivals.get(id);
            int sTime = event.time;
            int diff = t - sTime;

            String combinedName = getCombinedName(event.stationName,stationName);

            Average average = system.getOrDefault(combinedName,new Average(0,0));
            average.total = average.total+diff;
            average.count++;

            system.put(combinedName,average);

            arrivals.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String combinedName = getCombinedName(startStation,endStation);
        return system.get(combinedName).getAverage();
    }

    public String getCombinedName(String s1,String s2){
        return s1+","+s2;
    }
    class Event{
        int id;
        String stationName;
        int time;
        Event(int id,String stationName,int time){
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }

    class Average{

        int total;
        int count;
        Average(int total,int count){
            this.total = total;
            this.count = count;
        }

        public double getAverage(){
            return this.total*1.0/this.count;
        }
    }
}
