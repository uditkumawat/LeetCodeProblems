package code.top100;

//TC - O(N)
//SC - O(1)
public class ContainerWithMostWater {

    public static void main(String args[]){

        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] height) {

        int maxArea=0;
        int left=0;
        int right=height.length-1;

        while(left<right){

            int lh = height[left];
            int rh = height[right];
            int width = right-left;
            int area = Math.min(lh,rh)*width;
            maxArea = Math.max(maxArea, area);

            if(lh<rh){
                left++;
            }
            else if(rh<lh){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return maxArea;
    }
}
