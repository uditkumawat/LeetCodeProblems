package code.top100;

public class IncreasingTripletSubsequence {

    public static void main(String args[]){
        int nums[]={5,4,3,2,1};
        System.out.println(increasingTriplet(nums));
    }

        public static boolean increasingTriplet(int[] nums) {

            int firstSmallest = Integer.MAX_VALUE;
            int secondSmallest = Integer.MAX_VALUE;
            int thirdSmallest = Integer.MAX_VALUE;

            for(int num:nums){
                if(num<=firstSmallest){
                    firstSmallest = num;
                }
                else if(firstSmallest<num && num<secondSmallest){
                    secondSmallest = num;
                }
                else if(num>firstSmallest && num>secondSmallest){
                    return true;
                }
            }

            return false;
        }
}
