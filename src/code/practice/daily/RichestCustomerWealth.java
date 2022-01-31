package code.practice.daily;

public class RichestCustomerWealth {

    public static void main(String args[]){

        int accounts[][] = {{2,8,7},{7,1,3},{1,9,5}};

        RichestCustomerWealth obj = new RichestCustomerWealth();

        System.out.println(obj.maximumWealth(accounts));
    }
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for(int i=0;i<accounts.length;i++){
            int sum = 0;
            for(int j=0;j<accounts[i].length;j++){
                sum = sum + accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,sum);
        }

        return maxWealth;
    }
}
