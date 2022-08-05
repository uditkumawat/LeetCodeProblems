package code.may.challenge;

public class BackspaceStringCompare {

    public static void main(String args[]){

        BackspaceStringCompare obj = new BackspaceStringCompare();

        System.out.println(obj.backspaceCompare("ab##","c#d#"));
    }

        public boolean backspaceCompare(String s, String t) {
            int skipS = 0;
            int skipT = 0;

            int i = s.length()-1;
            int j = t.length()-1;

            while(i>=0 || j>=0){

                while(i>=0){
                    if(s.charAt(i)=='#'){
                        skipS++;
                        i--;
                    }
                    else if(skipS>0){
                        skipS--;
                        i--;
                    }
                    else{
                        break;
                    }
                }

                while(j>=0){
                    if(t.charAt(j)=='#'){
                        skipT++;
                        j--;
                    }
                    else if(skipT>0){
                        skipT--;
                        j--;
                    }
                    else{
                        break;
                    }
                }

                if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j)){
                    return false;
                }

                if((i>=0) != (j>=0)){
                    return false;
                }

                i--;
                j--;
            }

            return true;
        }

}
