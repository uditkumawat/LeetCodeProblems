package code.top100;

public class ReapeatingAndMissingNumber {

    public static void main(String args[]){

        //if elements are from 1 to 5

        int n = 5;
        int arr[] = {1,2,3,3,4};

        boolean count[] = new boolean[n+1];

        for(int i=0;i<arr.length;i++){
            if(count[arr[i]]){
                System.out.println("Repeating element" +arr[i]);
            }
            count[arr[i]] = true;
        }

        for(int i=1;i<count.length;i++){
            if(count[i]==false){
                System.out.println("Missing element "+i);
            }
        }

    }
}
