package code.facebook;

//https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
//TC - O(N)
//SC- O(N)

/**
 * Use buckets to record the last position of digit 0 ~ 9 in this num.
 *
 * Loop through the num array from left to right. For each position, we check whether there exists a larger digit in this num (start from 9 to current digit). We also need to make sure the position of this larger digit is behind the current one. If we find it, simply swap these two digits and return the result.
 */
public class MaxSwap {

    public static void main(String args[]){

        int num = 2736;

        MaxSwap obj = new MaxSwap();
        System.out.println(obj.maximumSwap(num));
    }
    public int maximumSwap(int num) {

        char arr[] = String.valueOf(num).toCharArray();

        int lastIndex[] = new int[10];

        for(int i=0;i<arr.length;i++){
            lastIndex[arr[i]-'0']=i;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=9;j>arr[i]-'0';j--){
                if(lastIndex[j]>i && j!=(arr[i]-'0')){
                    char c = arr[i];
                    arr[i] = arr[lastIndex[j]];
                    arr[lastIndex[j]] = c;
                    return Integer.valueOf(new String(arr));
                }
            }
        }

        return num;
    }
}
