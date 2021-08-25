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

            int currArea = Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(maxArea, currArea);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxArea;
    }
}
