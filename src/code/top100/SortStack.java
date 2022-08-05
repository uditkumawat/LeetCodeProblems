package code.top100;

import java.util.Stack;

//https://www.youtube.com/watch?v=MOGBRkkOhkY
public class SortStack {

    public static void main(String args[]){

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);

        System.out.println("Initially");

        SortStack obj = new SortStack();
        obj.print(stack);
        obj.sort(stack);

        System.out.println("\nAfter sorting");
        obj.print(stack);
    }

    public void print(Stack<Integer> stack){
        for(int num:stack){
            System.out.print(num+" ");
        }
    }

    public void sort(Stack<Integer> stack){

        if(stack.size()==1){
            return;
        }

        int value = stack.pop();
        sort(stack);
        insert(value,stack);
    }

    public void insert(int val,Stack<Integer> stack){
        if(stack.isEmpty() || stack.peek()<val){
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        insert(val,stack);
        stack.push(temp);
    }
}
