package code.google;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String args[]){

        int fruits[] = {1,2,3,2,2,1,1,1,1};

        FruitIntoBaskets obj = new FruitIntoBaskets();

        System.out.println(obj.totalFruit(fruits));
    }
    public int totalFruit(int[] fruits) {

        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;

        while(right<fruits.length){

            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max,right-left+1);

            right++;
        }

        return max;
    }
}
