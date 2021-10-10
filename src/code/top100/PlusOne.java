package code.top100;

public class PlusOne {

    public static void main(String args[]){

        int nums[] = {1,3,9};

        int n[] = plusOne(nums);

        for(int i:n){
            System.out.print(i+" ");
        }

    }

    public static int[] plusOne(int[] digits) {

        if(digits==null || digits.length==0){
            return new int[0];
        }

        int n = digits.length;

        for(int i=n-1;i>=0;i--){
            if(digits[i]==9){
                digits[i] = 0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }

        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}
