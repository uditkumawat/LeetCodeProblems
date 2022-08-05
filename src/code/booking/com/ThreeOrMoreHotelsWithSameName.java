package code.booking.com;

import java.util.*;

/**
 * Given a stream of rows in the following format, find the cities which has 3 or more hotels with same name
 * hotelId, hotel Name, City Name
 */
public class ThreeOrMoreHotelsWithSameName {

    public static void main(String args[]){

        String str[][] = {{"1","Ashoka","Jaipur"},
                {"2","Ashoka","Jaipur"},
                {"3","Ashoka","Ajmer"},
                {"4","Clarks","Jaipur"},
                {"5","Ashoka","Jaipur"},
                {"6","Lalit","Jaipur"},
                {"7","Clarks","Ajmer"},
                {"8","Clarks","Ajmer"},
                {"9","Clarks","Ajmer"},};

        ThreeOrMoreHotelsWithSameName obj = new ThreeOrMoreHotelsWithSameName();

        List<String> cityNames = obj.getCities(str);

        for(String city:cityNames){
            System.out.println(city);
        }
    }

    public List<String> getCities(String str[][]){

        List<String> res = new ArrayList();

        if(str==null || str.length==0){
            return res;
        }

        Map<String, Integer> cityHotelCountMapping = new HashMap();

        for(String log[] : str){
            String hotelId = log[0];
            String hotelName = log[1];
            String cityName = log[2];

            String key = cityName+"#"+hotelName;

            cityHotelCountMapping.put(key,cityHotelCountMapping.getOrDefault(key,0)+1);
        }

        System.out.println(cityHotelCountMapping);

        for(Map.Entry<String,Integer> entry:cityHotelCountMapping.entrySet()){
            if(entry.getValue()>=3){
                String cityName = entry.getKey().split("#")[0];
                res.add(cityName);
            }
        }

        return res;
    }
}
