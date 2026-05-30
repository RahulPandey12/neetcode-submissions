class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> alist = Arrays.stream(nums).boxed().collect(Collectors.toList());
       return alist.stream().collect(Collectors.groupingBy(y->y,Collectors.counting())).entrySet().stream()
       .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()).limit(k).mapToInt(entry->entry.getKey()).toArray();
	
       }
}
