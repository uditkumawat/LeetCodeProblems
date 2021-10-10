package code.top100;

import java.util.Arrays;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        int map1[] = new int[256];
        int map2[] = new int[256];

        Arrays.fill(map1,-1);
        Arrays.fill(map2,-1);


        for(int i=0;i<s.length();i++){

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1[c1]==-1 && map2[c2]==-1){
                map1[c1] = c2;
                map2[c2] = c1;
            }
            else if(!(map1[c1]==c2 && map2[c2]==c1)){
                return false;
            }
        }

        return true;
    }
}
