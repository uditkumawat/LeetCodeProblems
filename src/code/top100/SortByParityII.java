package code.top100;

public class SortByParityII {

    public static void main(String args[]){

        int arr[] = {4,5,3,2,6};

        for(int i:arr){
            System.out.print(i+" ");
        }
        int i = 0;
        int j = 1;
        int n = arr.length;
        while(i<n && j<n){
            while(i<n && arr[i]%2==0){
                i=i+2;
            }

            while(j<n && arr[j]%2==1){
                j=j+2;
            }

            if(i<n && j<n){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println();
        for(int k:arr){
            System.out.print(k+" ");
        }
    }
}
