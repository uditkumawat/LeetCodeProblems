package code.neetcode150;

import java.util.*;

//https://leetcode.com/problems/design-twitter/discuss/82825/Java-OO-Design-with-most-efficient-function-getNewsFeed
public class DesignTwitter {

    private static int timestamp=0;

    private class Tweet{
        public int timestamp;
        public int tweetId;
        public Tweet next;
        Tweet(int tweetId){
            this.tweetId = tweetId;
            this.timestamp = timestamp++;
            this.next = null;
        }
    }


    private class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int userId){
            this.id = userId;
            this.tweetHead = null;
            this.followed = new HashSet();
            follow(this.id);
        }

        public void follow(int id){
            this.followed.add(id);
        }

        public void unfollow(int id){
            this.followed.remove(id);
        }

        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    private Map<Integer,User> userMap;

    public DesignTwitter() {
        userMap = new HashMap();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }


    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId)){
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b)->{
            return b.timestamp-a.timestamp;
        });

        for(int user:users){
            Tweet tweetHead = userMap.get(user).tweetHead;

            if(tweetHead!=null){
                pq.add(tweetHead);
            }
        }

        int n = 10;
        while(!pq.isEmpty() && n>0){
            Tweet tweet = pq.poll();
            n--;
            res.add(tweet.tweetId);
            if(tweet.next!=null){
                pq.add(tweet.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if(!userMap.containsKey(followerId) || followerId==followeeId){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
