class Twitter {
    HashMap<Integer,List<Tweet>> hmap;
    
    HashMap<Integer, HashSet<Integer>> followMap;
   int time=0;
    public Twitter() {
        hmap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        hmap.computeIfAbsent(userId, key-> new ArrayList<>()).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet>  pq= new PriorityQueue<>((a,b)->Integer.compare(b.time,a.time));
       List<Tweet> twittList= hmap.get(userId);
       if(twittList!=null){
        for(Tweet tweet: twittList)
           pq.add(tweet);
       }
        // 2. Followed users' tweets
    if (followMap.containsKey(userId)) {

        for (int followeeId : followMap.get(userId)) {

            List<Tweet> followeeTweets = hmap.get(followeeId);

            if (followeeTweets != null) {
                for (Tweet tweet : followeeTweets) {
                    pq.add(tweet);
                }
            }
        }
    }
    List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && result.size() < 10){
            result.add(pq.poll().tweetId);
        }
        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap
        .computeIfAbsent(followerId, key -> new HashSet<>())
        .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
         if (followMap.containsKey(followerId)) {
        followMap.get(followerId).remove(followeeId);
    }
    }
}
class Tweet {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}
