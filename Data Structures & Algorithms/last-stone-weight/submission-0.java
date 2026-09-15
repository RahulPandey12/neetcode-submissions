class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i=0;i<stones.length;i++){
           pq.add(stones[i]);
       }
       int minus=0;
       while(pq.size()>=2){
          int first=pq.poll();
          int second=pq.poll();
          minus=minus+(first-second);
          pq.add(first-second);

       }
       return pq.peek();
    }
}
