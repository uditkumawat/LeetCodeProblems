package code.facebook;

//Second approach - https://www.youtube.com/watch?v=nxT9M8SQpAA
public class NumberComplement {

    public static void main(String args[]){

        int num = 5;

        NumberComplement obj = new NumberComplement();

        System.out.println(obj.findComplement(num));

    }
    public int findComplement(int num) {

        int no = 0; // number greater than num which is having all bits set
        int power = 0;

        while(no<num){
            no+=Math.pow(2,power);
            power++;
        }

        return no-num;
    }

    public int find1sComplement(int num){

        int res = 0;
        int i = 0;

        while(num!=0){
            //setting 1 bit only when we get 0 at any bit position
            if((num&1)==0){
                res = res+(1<<i);
            }
            i<<=1;
            num>>=1;
        }

        return res;
    }
}
