package code.explorecard.binarySearch;

public class Pow {

    public static void main(String args[]){

        double x = 2.00000;
        int n = -2;

        Pow obj = new Pow();

        System.out.println(obj.myPow(x,n));
    }

    public double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = n*-1;
        }

        if(n==0){
            return 1;
        }

        double temp = myPow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }
        else{
            return temp*temp*x;
        }
    }
}
