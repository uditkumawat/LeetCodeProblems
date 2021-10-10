package code.microsoft;

/**
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 *
 * The operation of drinking a full water bottle turns it into an empty bottle.
 *
 * Return the maximum number of water bottles you can drink.
 */
public class WaterBottles {

    public static void main(String args[]){

        WaterBottles obj = new WaterBottles();

        System.out.println(obj.numWaterBottles(15,4));
    }

    public int numWaterBottles(int numBottles, int numExchange) {

        int ans = numBottles;

        int temp = numBottles;

        while(temp/numExchange>=1){
            ans+=temp/numExchange;
            temp = temp/numExchange+temp%numExchange;
        }

        return ans;
    }
}
