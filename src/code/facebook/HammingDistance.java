package code.facebook;

public class HammingDistance {

    public static void main(String args[]){

        HammingDistance obj = new HammingDistance();

        System.out.println(obj.hammingDistance(1,4));
        System.out.println(obj.hammingDistance(3,1));
    }

    public int hammingDistance(int x, int y) {

        int xor = x^y;
        int countBits = 0;

        while(xor!=0){
            if((xor&1)==1){
                countBits++;
            }
            xor>>=1;
        }

        return countBits;
    }
}
