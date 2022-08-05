package code.tagged.facebook;

//https://www.youtube.com/watch?v=sClFsx12VgM&t=2s
//TC - O(N)
//SC - O(N)
public class MinimumRemoveToMakeValidParanthesis {

    public static void main(String args[]){

        MinimumRemoveToMakeValidParanthesis obj = new MinimumRemoveToMakeValidParanthesis();

        System.out.println(obj.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(obj.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(obj.minRemoveToMakeValid("(a(b(c)d)"));
    }

    public String minRemoveToMakeValid(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        char c[] = s.toCharArray();

        int count = 0;

        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                count++;
            }
            else if(c[i]==')'){

                if(count>0){
                    count--;
                }
                else{
                    c[i] = '.';
                }
            }
        }

        count=0;
        for(int i=c.length-1;i>=0;i--){
            if(c[i]==')'){
                count++;
            }
            else if(c[i]=='('){
                if(count>0){
                    count--;
                }
                else{
                    c[i] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(c[i]!='.'){
                sb.append(c[i]);
            }
        }

        return sb.toString();
    }
}
