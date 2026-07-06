class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int maxHeight=0;
        int currentHeight=0;
        while(i<j){
          currentHeight=(j-i)*Math.min(heights[i],heights[j]);
          if(heights[i]<heights[j]){
              i++;
          }
          else {
            j--;
          }
          maxHeight=Math.max(currentHeight,maxHeight);
        }
        return maxHeight;
    }
}
