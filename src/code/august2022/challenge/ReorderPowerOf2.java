package code.august2022.challenge;

//https://www.youtube.com/watch?v=6a4bDpcMylo
//TC - O(10*32*logn/log10)
//SC - O(1)
public class ReorderPowerOf2 {

    public boolean reorderedPowerOf2(int n) {

        int inputNumberFreq[] = countFreq(n);

        for(int i=0;i<32;i++){

            int powerOf2 = (int)Math.pow(2,i);

            int powerOf2CountFreq[] = countFreq(powerOf2);

            if(countEquals(inputNumberFreq,powerOf2CountFreq)){
                return true;
            }
        }

        return false;
    }

    private boolean countEquals(int a[],int b[]){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

    public int[] countFreq(int n){
        int count[] = new int[10];
        while(n!=0){
            count[n%10]++;
            n=n/10;
        }
        return count;
    }
}
