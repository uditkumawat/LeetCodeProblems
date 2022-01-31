package code.google;

public class ProductofArrayByItelsf {

    public static int[] findProduct(int arr[])
    {

        if(arr==null || arr.length==0){
            return arr;
        }

        int [] result = new int[arr.length];
        int temp = 1;

        for(int i=0;i<arr.length;i++){
            result[i] = temp;
            temp = temp*arr[i];
        }

        temp = 1;

        for(int i=arr.length-1;i>=0;i--){
            result[i] = result[i]*temp;
            temp = temp * arr[i];
        }

        return result;
    }
}
