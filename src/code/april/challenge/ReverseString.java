package code.april.challenge;

//https://leetcode.com/problems/reverse-string/solution/
//TC - O(N) to swap n/2 elements
//SC - O(1)
public class ReverseString {

    public static void main(String args[]){

        char s[] = {'h','e','l','l','o'};

        ReverseString obj = new ReverseString();
        obj.print(s);
        obj.reverseString(s);
        System.out.println("\nAfter reversing");
        obj.print(s);
    }

    public void print(char s[]){
        for(char c:s){
            System.out.print(c+" ");
        }
    }
    public void reverseString(char[] s) {

        if(s==null || s.length==0){
            return;
        }

        reverse(s,0,s.length-1);
        return;
    }

    private void reverse(char s[],int left,int right){
        while(left<=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
