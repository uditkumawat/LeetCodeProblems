package code.booking.com;

//https://leetcode.com/problems/reverse-words-in-a-string-ii/
//TC-O(n)
public class ReverseWordsInStringII {

    public static void main(String args[]){

        char s[] = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        for(char c:s){
            System.out.print(c+" ");
        }

        System.out.println("After reversing");

        ReverseWordsInStringII obj = new ReverseWordsInStringII();
        obj.reverseWords(s);

        for(char c:s){
            System.out.print(c+" ");
        }

    }
    public void reverseWords(char[] s) {

        if(s==null || s.length==0){
            return;
        }

        int left = 0;
        int right = 0;


        while(right<s.length){
            while(right<s.length && s[right]!=' '){
                right++;
            }

            reverse(s,left,right-1);

            while(right<s.length && s[right]==' '){
                right++;
            }

            left = right;
        }

        reverse(s,0,s.length-1);
    }

    public void reverse(char s[],int left,int right){
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
