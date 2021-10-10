package code.google;

public class RelativeSortArray {

    public static void main(String args[]){
        RelativeSortArray obj = new RelativeSortArray();
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};

        int res[] = obj.relativeSortArray(arr1,arr2);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        if(arr2==null || arr2.length==0){
            return new int[0];
        }

        int count[] = new int[1001];

        for(int num:arr1){
            count[num]++;
        }

        int index=0;
        for(int num:arr2){
            while(count[num]-->0){
                arr1[index++] = num;
            }
        }

        for(int i=0;i<count.length;i++){
            while(count[i]-->0){
                arr1[index++] = i;
            }
        }

        return arr1;
    }
}
