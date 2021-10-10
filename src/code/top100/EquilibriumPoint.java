package code.top100;

//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=c9imv2LvgWk
public class EquilibriumPoint {

    public static void main(String args[]){

        int arr[]={1,2,6,4,0,-1};

        int equiIndex = getEquiPoint(arr);

        System.out.println(equiIndex);
    }

    public static int getEquiPoint(int arr[]){

        if(arr==null || arr.length==0){
            return -1;
        }
        int n = arr.length;
        int sum[] = new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1]+arr[i];
        }

        int leftSum = 0;
        int rightSum = 0;

        for(int i=0;i<n;i++){
            leftSum = sum[i]-arr[i];
            rightSum = sum[n-1]-sum[i];
            System.out.println(leftSum+" "+rightSum);
            if(leftSum==rightSum){
                return i;
            }
        }

        return -1;
    }
}
