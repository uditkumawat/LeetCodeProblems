package code.facebook;

/**
 * Time Complexity: O(N)O(N), where NN is the length of A.
 *
 * Space Complexity: O(1)O(1).
 */
public class ValidMountainArray {

    public static void main(String args[]){

        int arr[] = {0,3,2,1};

        ValidMountainArray obj = new ValidMountainArray();

        System.out.println(obj.validMountainArray(arr));

    }
    public boolean validMountainArray(int[] arr) {

        if(arr==null || arr.length<3){
            return false;
        }

        int i=0;

            while(i+1<arr.length && arr[i]<arr[i+1]){
                i++;
            }

            if(i==0 || i==arr.length-1){
                return false;
            }

            while(i+1<arr.length && arr[i]>arr[i+1]){
                i++;
            }



        return i==arr.length-1;
    }
}
