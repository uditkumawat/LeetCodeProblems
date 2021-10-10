package code.top100;

public class SumOfTwoIntegers {

    int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }

    public int getSubtract(int a, int b) {
        return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
    }

    public int negate(int x) {
        return ~x + 1;
    }
}
