package code.bloomberg;

public class MaximumNestingDepthOfParanthesis {

    public int maxDepth(String s) {
        int maxLength = 0;

        int count = 0;

        for(char c:s.toCharArray()){
            if(c=='('){
                count++;
                maxLength = Math.max(maxLength,count);
            }
            else if(c==')'){
                count--;
            }
        }

        return maxLength;
    }
}
