package code.design;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
public class OnlineStockSpan {

    class Node{
        int index;
        int price;
        Node(int index,int price){
            this.index = index;
            this.price = price;
        }
    }

    Stack<Node> stack;
    int index;
    public OnlineStockSpan() {
        index = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        if(stack.isEmpty() || stack.peek().price>=price){
            Node node = new Node(index++,price);
            stack.push(node);
            return 1;
        }
        else{
            int count = 0;
            while(!stack.isEmpty() && stack.peek().price<price){
                stack.pop();
            }
            count = (index-stack.peek().index);
            Node node = new Node(index++,price);
            stack.push(node);
            return count;
        }
    }

    public static void main(String args[]){

        OnlineStockSpan obj = new OnlineStockSpan();

        System.out.println(obj.next(100));

        System.out.println(obj.next(80));

        System.out.println(obj.next(60));

        System.out.println(obj.next(70));

        System.out.println(obj.next(60));

        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
