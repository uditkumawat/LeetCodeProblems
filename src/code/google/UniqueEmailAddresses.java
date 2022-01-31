package code.google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String args[]){

        String emails[] = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};

        UniqueEmailAddresses obj = new UniqueEmailAddresses();

        System.out.println(obj.numUniqueEmails(emails));

    }
    public int numUniqueEmails(String[] emails) {

        Set<String> res = new HashSet<>();

        for(String email:emails){

            String updatedEmail = func(email);

            res.add(updatedEmail);
        }

        return res.size();
    }

    public String func(String email){

        StringBuilder sb = new StringBuilder();

        String tokens[] = email.split("@");

        for(char c:tokens[0].toCharArray()){
            if(c=='+'){
                break;
            }
            if(c=='.'){
                continue;
            }
            sb.append(c);
        }

        sb.append(tokens[1]);

        return sb.toString();
    }

}
