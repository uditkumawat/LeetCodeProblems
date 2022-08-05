package code.design;

public class CircularQueue {

    int arr[];
    int front;
    int tail;
    int k;
    public CircularQueue(int k) {
        this.arr = new int[k];
        this.front = -1;
        this.tail = -1;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(!isFull()){
            if(isEmpty()){
                front = 0;
                tail = 0;
                arr[front] = value;
            }
            else{
                tail++;
                tail = tail % k;
                arr[tail] = value;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            int num = arr[front];
            front++;
            front = front % k;
            return true;
        }
        return false;
    }

    public int Front() {
        if(!isEmpty()){
            return arr[front];
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return arr[tail];
        }
        return -1;
    }

    public boolean isEmpty() {
        return front==-1;
    }

    public boolean isFull() {
        return (tail+1) % k == front;
    }

    public static void main(String args[]){
        CircularQueue obj = new CircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }
}
