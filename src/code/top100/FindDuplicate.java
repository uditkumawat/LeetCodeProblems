package code.top100;

//https://www.youtube.com/watch?v=dfIqLxAf-8s
//TC - O(N)
//SC - O(1)
public class FindDuplicate {

    public static void main(String args[]){

        int arr[] = {1,4,2,3,4};
        System.out.println(duplicate(arr));
    }

    public static int duplicate(int nums[]){

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
