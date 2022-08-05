package code.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    Queue<Iterator> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();

        if(!v1.isEmpty())
            q.add(v1.iterator());
        if(!v2.isEmpty())
            q.add(v2.iterator());
    }

    public int next() {
        Iterator it = q.poll();
        int num = (int) it.next();

        if(it.hasNext()){
            q.add(it);
        }

        return num;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }
}
