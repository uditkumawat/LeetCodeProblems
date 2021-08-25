package code.leetcode.doordash;

import java.util.*;

public class Twitter {

        private static int timestamp = 0;
        private static Map<Integer,User> userMap;

        class Tweet{
            private int tweetId;
            private int time;
            private Tweet nextTweet;

            Tweet(int tweetId){
                this.tweetId = tweetId;
                this.time = timestamp++;
                this.nextTweet = null;
            }

            public int getTime(){
                return time;
            }

            public int getTweetId(){
                return tweetId;
            }

            public Tweet getTweetHead(){
                return nextTweet;
            }


        }

        class User{
            private int id;
            private Set<Integer> followed;
            private Tweet tweetHead;
            User(int id){
                this.id = id;
                this.followed = new HashSet<>();
                this.followed.add(id);
                this.tweetHead = null;
            }

            //// everytime user post a new tweet, add it to the head of tweet list.
            public void postTweet(int tweetId){
                Tweet t = new Tweet(tweetId);
                t.nextTweet = tweetHead;
                tweetHead = t;
            }

            public void follow(int userId){
                this.followed.add(userId);
            }

            public void unfollow(int userId){
                this.followed.remove(userId);
            }

            public Set<Integer> getFollowers(){
                return this.followed;
            }

            public Tweet getTweetHead(){
                return this.tweetHead;
            }
        }

        public static void main(String args[]){
            Twitter tw = new Twitter();
            tw.init();
            tw.postTweet(1,5);
            System.out.println(tw.getNewsFeed(1));
            tw.follow(1,2);
            tw.postTweet(2,6);
            System.out.println(tw.getNewsFeed(1));
            tw.unfollow(1,2);
            System.out.println(tw.getNewsFeed(1));
        }

        public void init(){
            userMap = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!userMap.containsKey(userId)){
                User user = new User(userId);
                userMap.put(userId,user);
            }
            userMap.get(userId).postTweet(tweetId);
            System.out.println("Tweet posted by "+userId+", tweetId ->"+tweetId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {

            List<Integer> res = new ArrayList<>();
            if(!userMap.containsKey(userId)){
                return res;
            }

            Set<Integer> users = userMap.get(userId).getFollowers();
            System.out.println("UserId-> "+userId+" , followers List->"+users);


            PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(userMap.size(),(a,b)->b.getTime()-a.getTime());

            for(int user:users){
                Tweet tweetHead = userMap.get(user).getTweetHead();
                if(tweetHead!=null){
                    pq.add(tweetHead);
                }
            }

            System.out.println("PriorityQueue size "+pq.size());

            int n=0;
            while(!pq.isEmpty() && n<10){

                Tweet tweet = pq.poll();

                res.add(tweet.getTweetId());

                n++;

                if(tweet.getTweetHead()!=null){
                    pq.add(tweet.getTweetHead());
                }
            }

            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!userMap.containsKey(followerId)){
                User user = new User(followerId);
                userMap.put(followerId,user);
            }
            if(!userMap.containsKey(followeeId)){
                User user = new User(followeeId);
                userMap.put(followeeId,user);
            }
            userMap.get(followerId).follow(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId==followeeId){
                return;
            }
            if(!userMap.containsKey(followerId)){
                User user = new User(followerId);
                userMap.put(followerId,user);
            }
            if(!userMap.containsKey(followeeId)){
                User user = new User(followeeId);
                userMap.put(followeeId,user);
            }

            userMap.get(followerId).unfollow(followeeId);
        }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
