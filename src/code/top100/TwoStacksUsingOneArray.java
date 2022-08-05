package code.top100;

public class TwoStacksUsingOneArray<V> {

    private int maxSize;
    private int top1, top2; //Store top value indices of Stack 1 and Stack 2
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacksUsingOneArray(int max_size) {
        this.maxSize = max_size;
        this.top1 = -1;
        this.top2 = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            return array[top2++];
        }
        return null;
    }
}
