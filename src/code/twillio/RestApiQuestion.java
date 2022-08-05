package code.twillio;

/*
 * Complete the 'getUserTransaction' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER uid
 *  2. STRING txnType
 *  3. STRING monthYear
 *
 *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
 */
public class RestApiQuestion {

    /*
    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


class Result {

    class PageInfo {

        int page;
        int per_page;
        int total_pages;
        Data[] data;

        public PageInfo(int page, int per_page, int total_pages, Data[] data) {
            this.page = page;
            this.per_page = per_page;
            this.total_pages = total_pages;
            this.data = data;
        }
        public Data[] getData() {
            return data;
        }
    }

    public enum TxnType {
        credit,
        debit;
    }


class Location {
    int id ;
    String address;
    String city;
    String zipCode;

    public Location(int id, String address, String city, String zipCode) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }
}


class Data {

    int id;
    String userId;
    String userName;

    String timestamp;
    TxnType txnType;
    String amount;
    Location location;
    String ip;

    public Data(int id, String userId, String userName, String timestamp, TxnType txnType, String amount, Location location, String ip) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.timestamp = timestamp;
        this.txnType = txnType;
        this.amount = amount;
        this.location = location;
        this.ip = ip;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public String getTimestamp(){
        return this.timestamp;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public TxnType getTxnType() {
        return txnType;
    }

    public String getAmount() {
        return amount;
    }

    public Location getLocation() {
        return location;
    }
    public String getIp() {
        return ip;
    }
}


    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {

        List<Integer> res = new ArrayList<>();
        List<Data> data = new ArrayList<>();
        PageInfo c = getData(uid,1);
        addData(data,c);
        for(int page=2;page<=c.total_pages;page++){
            c = getData(uid, page);
            addData(data, c);
        }

        monthYear = monthYear.substring(1);
        System.out.println("Starting "+ monthYear);
        Map<String,Double> totalSpendingsGroup = getTotalMonthlySpendings(data);
        Map<String,Integer> countGroupings = getCountGroupings(data);

        Double averageSpending = totalSpendingsGroup.get(monthYear)/countGroupings.get(monthYear);
        System.out.println(averageSpending);
        //calculate
        calculateRes(averageSpending,monthYear,data,res,txnType);
        return res;
    }

    public static void calculateRes(Double averageSpending,String monthYear,List<Data> data,List<Integer> res,String txnType){

        for(int i=0;i<data.size();i++){
            Data dt = data.get(i);
            if(dt.getTxnType().toString().equalsIgnoreCase(txnType)){
                String at = dt.getAmount().substring(1).replaceAll(",","");;
                Double amount = Double.valueOf(at);
                if(amount>averageSpending){
                    res.add(dt.getId());
                }
            }
        }
    }
    public static Map<String,Double> getTotalMonthlySpendings(List<Data> data){

        Map<String,Double> map = new HashMap<>();
        for(int i=0;i<data.size();i++){
            Data dt = data.get(i);
            if(dt.getTxnType().toString().equalsIgnoreCase("debit")){
                String monthYear = getMonthYearCombination(dt.getTimestamp());
                System.out.println("In loop "+monthYear);
                String at = dt.getAmount().substring(1).replaceAll(",","");
                Double amount = Double.valueOf(at);
                if(map.containsKey(monthYear)){
                    Double oldAmount = map.get(monthYear);
                    Double newAmount = oldAmount+amount;
                    map.put(monthYear,newAmount);
                }
                else{
                    map.put(monthYear,amount);
                }
            }
        }
        return map;
    }

    public static Map<String,Integer> getCountGroupings(List<Data> data){

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<data.size();i++){
            Data dt = data.get(i);
            if(dt.getTxnType().toString().equalsIgnoreCase("debit")){
                String monthYear = getMonthYearCombination(dt.getTimestamp());
                map.put(monthYear,map.getOrDefault(monthYear,0)+1);
            }
        }
        return map;
    }

    public static void addData(List<Data> data,PageInfo c){
        if(c!=null && c.getData()!=null && c.getData().length>0){
            for(int i=0;i<c.getData().length;i++){
                data.add(c.getData()[i]);
            }
        }
    }

    public static String getMonthYearCombination(String timestamp){

        Timestamp ts = new Timestamp(Long.valueOf(timestamp));
        Date date = new Date(ts.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.print(calendar.get(Calendar.YEAR)+" sdgdgsg "+ calendar.get(Calendar.MONTH));
        long time = Long.valueOf(timestamp);
        Instant instant = Instant.ofEpochSecond(time);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant,ZoneId.of("UTC"));
        String res = calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        return res;
    }

    public static PageInfo getData(int uid,int pageNumber){

        String url = "https://jsonmock.hackerrank.com/api/transactions/search?userId="+uid+"&page="+pageNumber;
        // System.out.println(url);
        String srcOutput = getApiData(url);
        //System.out.print(srcOutput);
        PageInfo c = mapHoldingToResponse(srcOutput);
        return c;
    }

    public static PageInfo mapHoldingToResponse(String holdingResponse){
        try{
            Gson gson = new GsonBuilder().create();
            PageInfo r = gson.fromJson(holdingResponse , PageInfo.class);
            return r;
        }catch(Exception ex){
            System.out.println("error in holding gson parding =["+ex+"]");
        }
        return null;
    }

    public static String getApiData(String urll){
        try{
            URL url = new URL(urll);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            String inline ="";
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                inline+= scanner.nextLine();
            }
            scanner.close();
            return inline;

        }catch(Exception e){
            System.out.println("exception code ="+e);
        }
        return "";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int uid = Integer.parseInt(bufferedReader.readLine().trim());

        String txnType = bufferedReader.readLine();

        String monthYear = bufferedReader.readLine();

        List<Integer> result = Result.getUserTransaction(uid, txnType, monthYear);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

     */
}
