package code.top100;

public class PermutationsOfString {

    public static void main(String args[]){

        char c[] = {'A','B','C'};

        permutations(c);
    }

    public static void permutations(char c[]){
        if(c==null || c.length==0){
            return;
        }
        util(c,0);
    }

    public static void util(char c[],int index){
        if(index==c.length-1){
            for(char ct:c){
                System.out.print(ct+" ");
            }
            System.out.println();
            return;
        }
        for(int i=index;i<c.length;i++) {
            swap(c, i, index);
            util(c, index + 1);
            swap(c, i, index);
        }
    }

    public static void swap(char c[],int i1,int i2){
        char ct = c[i1];
        c[i1] = c[i2];
        c[i2] = ct;
    }
}
