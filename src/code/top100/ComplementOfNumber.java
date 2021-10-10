package code.top100;

//https://www.youtube.com/watch?v=LA1BnKiarEQ&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=121
public class ComplementOfNumber {

    public int findComplement(int num){

        int result = 0;
        int i=0;
        while(num!=0){

            if((num&1)==0){
                result+=1<<i;
            }

            i++;
            num=num>>1;
        }
        return result;
    }
}
