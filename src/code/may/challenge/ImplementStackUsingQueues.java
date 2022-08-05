package code.may.challenge;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/
//TC - O(N)
//SC - O(N)
public class ImplementStackUsingQueues {

    Queue<Integer> q;
    public ImplementStackUsingQueues() {
        q = new LinkedList<>();
    }

    public static void main(String args[]){

        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        obj.push(6);

        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.print(obj.empty());
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.print(obj.empty());
    }
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while(size>1){
            q.add(q.remove());
            size--;
        }
    }

    public int pop() {
        if(!q.isEmpty()){
            return q.poll();
        }
        else{
            return -1;
        }
    }

    public int top() {
        if(!q.isEmpty()){
            return q.peek();
        }
        else{
            return -1;
        }
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
