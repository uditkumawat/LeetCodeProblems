package code.facebook;

/**
 * Time complexity: O(max(N,1001)) since we need to iterate over trips and then iterate over our 1001 buckets.
 *
 * Space complexity : O(1001) since we have 1001 buckets.
 */

//used bucket sort because the constraint is given as trips[i][1] and trips[i][2]<1001
public class CarPooling {

    public static void main(String args[]){

        int trips[][] = {{2,1,5},{3,3,7}};
        int capacity = 5;

        CarPooling obj = new CarPooling();

        System.out.println(obj.carPooling(trips,capacity));

    }
    public boolean carPooling(int[][] trips, int capacity) {

        int timestamp[] = new int[1001];

        //adding the number of passengers in betweem from to to points
        for(int trip[] : trips){
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;

        //if at anytime, the passengers increase the given capacity,then return false
        for(int passengers : timestamp){
            usedCapacity += passengers;
            if(usedCapacity>capacity){
                return false;
            }
        }

        return true;
    }
}
