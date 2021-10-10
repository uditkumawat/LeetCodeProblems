package code.top100;

public class RelativeSort {

    public static void main(String args[]){

        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};

        int arr[] = relativeSort(arr1,arr2);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static int[] relativeSort(int arr1[],int arr2[]){
        int cnt[] = new int[1001];
        for(int i:arr1){
            cnt[i]++;
        }

        int i=0;
        for(int n:arr2){
            while(cnt[n]-->0){
                arr1[i++] = n;
            }
        }

        for(int n=0;n<1001;n++){
            while(cnt[n]-->0){
                arr1[i++]=n;
            }
        }

        return arr1;
    }
}
