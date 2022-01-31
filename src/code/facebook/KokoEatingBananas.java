package code.facebook;

public class KokoEatingBananas {

    public static void main(String args[]){

        int piles[] = {3,6,7,11};
        int h = 8;

        KokoEatingBananas obj = new KokoEatingBananas();

        System.out.println(obj.minEatingSpeed(piles,h));

    }
    public int minEatingSpeed(int[] piles, int h) {

        if(piles==null || piles.length==0){
            return 0;
        }

        int low = 1;
        int high = 1;

        for(int pile:piles){
            high = Math.max(high,pile);
        }

        while(low<high){

            int mid = low+(high-low)/2;

            int hours = 0;

            for(int pile:piles){
                hours+=Math.ceil((double) pile / mid);
            }

            if(hours<=h){
                high = mid;
            }
            else{
                low = mid+1;
            }

        }

        return high;
    }
}
