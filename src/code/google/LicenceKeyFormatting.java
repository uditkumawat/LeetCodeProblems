package code.google;

//TC - O(N)
//SC - O(N)
public class LicenceKeyFormatting {

    public static void main(String args[]){

        String s = "5F3Z-2e-9-w";

        LicenceKeyFormatting obj = new LicenceKeyFormatting();

        System.out.println(obj.licenseKeyFormatting(s,7));

    }
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c!='-'){
                if(count==k){
                    count = 0;
                    sb.append("-");
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }

        return sb.reverse().toString();
    }
}
