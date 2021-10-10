package code.google;

import java.util.*;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */
public class DestinationCity {

    public static void main(String args[]){

        DestinationCity obj = new DestinationCity();

        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London","New York"));
        paths.add(Arrays.asList("New York","Lima"));
        paths.add(Arrays.asList("Lima","Sao Paulo"));

        System.out.println(obj.destCity(paths));
    }

    public String destCity(List<List<String>> paths) {

        if(paths==null || paths.size()==0){
            return null;
        }

        Map<String,String> map = new HashMap<>();

        for(List<String> path:paths){
            map.put(path.get(0),path.get(1));
        }

        for(String value:map.values()){
            if(!map.keySet().contains(value)){
                return value;
            }
        }

        return null;
    }
}
