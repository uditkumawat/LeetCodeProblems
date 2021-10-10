package code.top100;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11780/5-lines-C%2B%2BJava-nicer-loops
//TC - O(n)
public class RemoveDuplicatesFromSortedArray {

    public static void main(String args[]){

        int arr[] = {1,2,2,2,3,4};

        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int nums[]){

        int i=0;
        for(int n:nums){
            if(i==0 || n>nums[i-1]){
                nums[i++] = n;
            }
        }
        return i;
    }
}
