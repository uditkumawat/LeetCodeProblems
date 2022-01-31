package code.facebook;

public class Complement10 {

    public static void main(String args[]){

        int n=10;

        Complement10 obj = new Complement10();

        System.out.println(obj.bitwiseComplement(n));
    }
    public int bitwiseComplement(int n) {

        /*

        int no = 0;
        int power=0;
        while(no<n){
            no+=Math.pow(2,power);
            power++;
        }

        return no-n;

         */

        int res = 0;
        int i = 0;
        while(n!=0){

            if((n&1)==0){
                res = res | (1<<i);
            }
            n>>=1;
            i++;
        }

        return res;
    }
}
