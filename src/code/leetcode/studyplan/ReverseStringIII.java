package code.leetcode.studyplan;

public class ReverseStringIII {

    public String reverseWords(String s) {

        int left = 0;
        int right = 0;
        char c[] = s.toCharArray();

        while(right<s.length()){

            while(right<s.length() && c[right]==' '){
                right++;
            }

            left = right;

            while(right<s.length() && c[right]!=' '){
                right++;
            }

            swap(c,left,right-1);
        }

        return new String(c);
    }

    public void swap(char str[],int left,int right){

        while(left<right){
            char c = str[left];
            str[left] = str[right];
            str[right] = c;

            left++;
            right--;
        }
    }
}
