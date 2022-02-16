package code.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-underground-system/
//TC - O(1)
public class UndergroundSystem {

    class Passenger{
        int startTime;
        int endTime;
        String startingStation;
        String endStation;
        Passenger(int startTime,String startingStation){
            this.startTime = startTime;
            this.startingStation = startingStation;
        }

        void checkout(int endTime,String endStation){
            this.endTime = endTime;
            this.endStation = endStation;
        }
    }

    class Route{
        int trips;
        int totalTime;

        public double getAverage(){
            return totalTime/trips;
        }
    }

    Map<Integer,Passenger> pMap;
    Map<String,Route> rMap;

    public UndergroundSystem() {
        pMap = new HashMap<>();
        rMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Passenger p = new Passenger(t,stationName);
        pMap.put(id,p);
    }

    public void checkOut(int id, String stationName, int t) {
        if(pMap.containsKey(id)){
            Passenger p = pMap.get(id);
            p.endTime = t;
            p.endStation = stationName;

            String routeKey = p.startingStation+"_"+p.endStation;
            Route route = rMap.getOrDefault(routeKey,new Route());
            route.trips++;
            route.totalTime = route.totalTime+p.endTime-p.startTime;

            rMap.put(routeKey,route);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation+"_"+endStation;
        if(rMap.containsKey(routeKey)){
            return rMap.get(routeKey).getAverage();
        }
        return 0;
    }

    public static void main(String args[]){
        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(45,"Leyton",3);
        obj.checkIn(32,"Paradise",8);
        obj.checkIn(27,"Leyton",10);
        obj.checkOut(45,"Waterloo",15);
        obj.checkOut(27,"Waterloo",20);
        obj.checkOut(32,"Cambridge",22);
        System.out.println(obj.getAverageTime("Paradise","Cambridge"));
        System.out.println(obj.getAverageTime("Leyton","Waterloo"));

    }
}
