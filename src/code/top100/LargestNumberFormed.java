package code.top100;

import java.util.Arrays;

//TC - O(nlogn)
//SC- O(n)
public class LargestNumberFormed {

    public static void main(String args[]){

        int arr[] = {3,39,9,0,110};
        String str = formLargestNumber(arr);

        System.out.print(str);

    }

    public static String formLargestNumber(int arr[]){
        if(arr==null || arr.length==0){
            return null;
        }
        int n = arr.length;
        String strs[] = new String[n];
        for(int i=0;i<n;i++){
            strs[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strs,(a,b)->{

            String s1 = a+b;
            String s2 = b+a;
            return s1.compareTo(s2);
        });

        if(strs[0].equals("0")){
            return "0";
        }

        String s = new String();
        for(String str:strs){
            s+=str;
        }

        return s;
    }
}
