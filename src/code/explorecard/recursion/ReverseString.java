package code.explorecard.recursion;

public class ReverseString {

    public static void main(String args[]){

        char s[] = {'h','e','l','l','o'};

        ReverseString obj = new ReverseString();
        System.out.println(s);
        obj.reverseString(s);
        System.out.println(s);

    }
    public void reverseString(char[] s) {

        if(s==null || s.length==0){
            return;
        }

        reverseString(s,0,s.length-1);

        return;
    }

    public void reverseString(char s[],int left,int right){
        if(left>right){
            return;
        }
        reverseString(s,left+1,right-1);
        swap(s,left,right);
    }

    public void swap(char s[],int left,int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
