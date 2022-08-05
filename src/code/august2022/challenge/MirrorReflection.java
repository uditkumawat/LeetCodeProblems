package code.august2022.challenge;

//https://leetcode.com/problems/mirror-reflection/submissions/
public class MirrorReflection {

    public int mirrorReflection(int p, int q) {

        int ext = q;
        int reflection = p;

        while(ext%2==0 && reflection%2==0){
            ext = ext/2;
            reflection = reflection/2;
        }

        if(ext%2==0 && reflection%2!=0){
            return 0;
        }

        if(ext%2==1 && reflection%2==0){
            return 2;
        }

        if(ext%2==1 && reflection%2!=0){
            return 1;
        }

        return -1;
    }
}
