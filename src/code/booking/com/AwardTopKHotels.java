package code.booking.com;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1431676/bookingcom-award-top-k-hotels-oa-hackerrank
public class AwardTopKHotels {

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
                                                List<Integer> hotelIds,
                                                List<String> reviews, int k) {
        Set<String> positiveWords = new HashSet<>();
        Set<String> negativeWords = new HashSet<>();

        for (String word: positiveKeywords.split(" ")) {
            positiveWords.add(word.toLowerCase());
        }

        for (String word: negativeKeywords.split(" ")) {
            negativeWords.add(word.toLowerCase());
        }

        Map<Integer, Integer> hotelScore = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++) {
            int hotel = hotelIds.get(i);
            int score = hotelScore.getOrDefault(hotel, 0);
            List<String> review = Arrays.asList(reviews.get(i).split(" "));

            int pos=0, neg=0;
            for (String word: reviews.get(i).split(" ")) {
                if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ',') {
                    word = word.substring(0, word.length() - 1);
                }
                if (positiveWords.contains(word.toLowerCase())) {
                    pos++;
                }
                if (negativeWords.contains(word.toLowerCase())) {
                    neg++;
                }
            }
            hotelScore.put(hotel, score + 3*pos - neg);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: hotelScore.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
