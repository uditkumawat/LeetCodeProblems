package code.top100;

//https://www.youtube.com/watch?v=fWS0TCcr-lE
public class RandomPickWithWeight {

    private int prefixSums[];
    private int totalSum;

    public RandomPickWithWeight(int[] w) {

        this.prefixSums = new int[w.length];

        this.prefixSums[0] = w[0];
        for(int i=1;i<w.length;i++){
            this.prefixSums[i] = this.prefixSums[i-1]+w[i];
        }

        this.totalSum = this.prefixSums[this.prefixSums.length-1];
    }

    public static void main(String args[]){
        int arr[] = {1,3};
        RandomPickWithWeight obj = new RandomPickWithWeight(arr);
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }

    public int pickIndex() {
        double index = this.totalSum*Math.random();

        int left = 0;
        int right = this.prefixSums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(this.prefixSums[mid]==index){
                return mid;
            }else if(this.prefixSums[mid]<index){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
