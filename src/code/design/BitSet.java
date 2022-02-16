package code.design;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=XIH6laaPgVk
public class BitSet {

    int size;
    Set<Integer> ones;
    Set<Integer> zeroes;

    public BitSet(int size) {
        this.size = size;
        this.ones = new HashSet<>();
        this.zeroes = new HashSet<>();
        for(int i=0;i<size;i++){
            zeroes.add(i);
        }
    }

    public void fix(int idx) {
        ones.add(idx);
        zeroes.remove(idx);
    }

    public void unfix(int idx) {
        ones.remove(idx);
        zeroes.add(idx);
    }

    public void flip() {
        Set<Integer> temp = ones;
        ones = zeroes;
        zeroes = temp;
    }

    public boolean all() {
        return ones.size()==this.size;
    }

    public boolean one() {
        return ones.size()>1;
    }

    public int count() {
        return ones.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            if(ones.contains(i)){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        BitSet obj = new BitSet(5);
        obj.fix(3);
        obj.fix(1);
        obj.flip();
        obj.all();
        obj.unfix(0);
        obj.flip();
        System.out.println(obj.one());
        obj.unfix(0);
        System.out.println(obj.count());
        System.out.println(obj.toString());
    }
}
