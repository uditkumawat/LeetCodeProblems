package code.salesforce;

//https://leetcode.com/problems/next-greater-element-iii/submissions/

/**
 * Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed. Here, nn refers to the number of digits in the given number.
 *
 * Space complexity : O(n)O(n). An array aa of size nn is used, where nn is the number of digits in the given number.
 */
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {

        char a[] = (""+n).toCharArray();

        int i = a.length-2;

        while(i>=0 && a[i]>=a[i+1]){
            i--;
        }

        if(i<0){
            return -1;
        }

        int j = a.length-1;

        while(j>=0 && a[j]<=a[i]){
            j--;
        }

        swap(a,i,j);
        reverse(a,i+1,a.length-1);

        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char a[],int i,int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void reverse(char a[] ,int left,int right){
        while(left<=right){
            swap(a,left,right);
            left++;
            right--;
        }
    }
}
