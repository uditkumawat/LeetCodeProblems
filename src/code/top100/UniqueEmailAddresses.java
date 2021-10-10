package code.top100;

import java.util.HashSet;

//https://www.youtube.com/watch?v=IPiMr4AmMOE
public class UniqueEmailAddresses {

    public int numUniqueEmails(String emails[]){

        HashSet<String> uniqueEmails = new HashSet<>();

        for(String email:emails){

            int splitPosition = email.indexOf("@");
            String localName = email.substring(0,splitPosition);
            String domainName = email.substring(splitPosition);

            if(localName.contains("+")){
                int plusPosition = localName.indexOf("+");
                localName = localName.substring(0,plusPosition);
            }

            localName = localName.replace("\\.","");
            String newName = localName+domainName;
            uniqueEmails.add(newName);
        }

        return uniqueEmails.size();
    }
}
