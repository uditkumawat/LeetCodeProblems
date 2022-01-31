package code.airbnb;

/**
 * Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized NestedInteger.
 *
 * Each element is either an integer or a list whose elements may also be integers or other lists.
 */
public class MiniParser {

    /*
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty()) return new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        int sign = 1, len = s.length() ;
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c == '['){
                stack.push(new NestedInteger()); // start of a new NestedInteger
            }else if( c == ']' && stack.size() > 1){ // End of a NesterdInteger
                NestedInteger n = stack.pop();
                stack.peek().add(n);
            }else if(c == '-'){ // just change the sign
                sign = -1;
            }else if(Character.isDigit(c)){ // if digit check for all the continous ones
                int num = c - '0';
                while( i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                num = num * sign;
                if(!stack.isEmpty()){
                    stack.peek().add(new NestedInteger(num)); // add to previous item if not empty
                }else{
                    stack.push(new NestedInteger(num));
                }
                sign = 1; // reset the sign
            }
        }
        return stack.isEmpty() ? new NestedInteger() : stack.pop() ;
    }
    /*
     */
}
