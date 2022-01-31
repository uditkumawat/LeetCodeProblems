package code.google;

public class LicenceKeyFormatting {

    public static void main(String args[]){

        String s = "5F3Z-2e-9-w";

        LicenceKeyFormatting obj = new LicenceKeyFormatting();

        System.out.println(obj.licenseKeyFormatting(s,7));

    }
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int count = k;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='-'){
                continue;
            }
            sb.append(s.charAt(i));
            count--;

            if(count==0 && i!=0){
                sb.append("-");
                count=k;
            }
        }

        return sb.reverse().toString().toUpperCase();
    }
}
