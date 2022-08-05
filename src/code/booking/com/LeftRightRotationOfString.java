package code.booking.com;

//https://www.geeksforgeeks.org/left-rotation-right-rotation-string-2/
public class LeftRightRotationOfString {

    public static void main(String args[]){

        String str = "leetcode";

        int left = 5;
        int right = 1;

        LeftRightRotationOfString obj = new LeftRightRotationOfString();

        System.out.println(obj.rotateString(str,left,right));
    }

    public String rotateString(String str,int left,int right){

        char arr[] = str.toCharArray();
        rotateUtilLeft(arr,left);
        rotateUtilRight(arr,right);

        return String.valueOf(arr);
    }

    private void rotateUtilLeft(char arr[],int d){
        rotate(arr,0,d-1);
        rotate(arr,d,arr.length-1);
        rotate(arr,0,arr.length-1);
    }

    private void rotateUtilRight(char arr[],int d){
        rotateUtilLeft(arr,arr.length-d);
    }

    private void rotate(char arr[],int l,int r){
        while(l<r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
