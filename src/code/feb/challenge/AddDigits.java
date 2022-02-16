package code.feb.challenge;

public class AddDigits {

    public static void main(String args[]){

        int num = 38;

        AddDigits obj = new AddDigits();

        System.out.println(obj.addDigits(num));

    }
    public int addDigits(int num) {

        int ans = num;

        while(ans>10){
            ans = getSum(ans);
        }

        return ans;
    }

    public int getSum(int num){
        int res = 0;
        while(num!=0){
            res = res+num%10;
            num = num/10;
        }
        return res;
    }
}
