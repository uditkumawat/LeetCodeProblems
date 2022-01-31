package code.google;

public class ContainerWithMostWater {

    public static void main(String args[]){

        int height[] = {1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater obj = new ContainerWithMostWater();

        System.out.println(obj.maxArea(height));

    }
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;

        int maxArea = 0;

        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(maxArea,area);
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
