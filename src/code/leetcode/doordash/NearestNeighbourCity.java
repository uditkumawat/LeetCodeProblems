package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearestNeighbourCity {

    public static void main(String args[]){

        String cities[] = {"Jaipur","Jodhpu","Jodhpur","Ajmer"};
        int x[] = {1,2,3,4};
        int y[] = {1,2,4,4};

        int targetX = 2;
        int targetY = 3;

        String neighourCity = getNeighbourCities(cities,x,y,targetX,targetY);

        if(neighourCity==null || neighourCity.length()==0){
            System.out.println("NONE");
        }
        else {
            System.out.println(neighourCity);
        }
    }
    static class City{
        int distance;
        String name;
        City(int distance,String name){
            this.distance = distance;
            this.name = name;
        }
    }
    public static String getNeighbourCities(String cities[], int x[], int y[], int targetX, int targetY){

        List<String> result = new ArrayList<>();

        PriorityQueue<City> pq = new PriorityQueue<>((a,b)->{
            return a.distance==b.distance?a.name.compareTo(b.name):a.distance-b.distance;
        });

        int minDistance = Integer.MAX_VALUE;
        String cityName = null;
        for(int i=0;i<x.length;i++){
            if(x[i]==targetX || y[i]==targetY){
                int distance = manhattanDistance(x[i],y[i],targetX,targetY);
                System.out.println("distance to city"+ cities[i]+ " "+distance);
                if(minDistance>distance){
                    minDistance = distance;
                    cityName = cities[i];
                }else if(minDistance==distance){
                    if(cityName.compareTo(cities[i])>0){
                        cityName = cities[i];
                    }
                }
                //pq.add(new City(distance,citites[i]));
            }
        }

        /*
        while(!pq.isEmpty()){
            City city = pq.poll();
            result.add(city.name);
        }

         */

        return cityName;
    }

    public static int manhattanDistance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
