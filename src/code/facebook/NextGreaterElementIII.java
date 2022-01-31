package code.facebook;

public class NextGreaterElementIII {

    public static void main(String args[]){

        int num = 95431;
        NextGreaterElementIII obj = new NextGreaterElementIII();
        System.out.println(obj.nextGreaterElement(num));
    }
    public int nextGreaterElement(int n) {

        if(n==0){
            return -1;
        }

        char arr[] = String.valueOf(n).toCharArray();

        int i=arr.length-2;

        while(i>=0 && arr[i+1]<=arr[i]){
            i--;
        }

        if(i<0){
            return -1;
        }

        int j = arr.length-1;

        //finding a number larger than arr[i]
        while(j>=0 && arr[j]<=arr[i]){
            j--;
        }

        swap(arr,i,j);
        reverse(arr,i+1);

        return Integer.parseInt(new String(arr));
    }

    public void swap(char arr[],int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char arr[],int start){
        int left = start;
        int right = arr.length-1;
        while(left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
    }
}
