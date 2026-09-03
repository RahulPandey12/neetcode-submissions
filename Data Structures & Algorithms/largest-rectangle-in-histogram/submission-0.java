class Solution {
    public int largestRectangleArea(int[] heights) {
       int[] nearestSmallestToLeftArr= nearestSmallestToLeftArr(heights);
       int[] nearestSmallestToRightArr= nearestSmallestToRightArr(heights);
       int maxHeight=0;
       for(int i=0;i<heights.length;i++){
        maxHeight=Math.max(maxHeight,(nearestSmallestToRightArr[i]-nearestSmallestToLeftArr[i]-1)*heights[i]);
       }
       return maxHeight;
      } 
      public int[] nearestSmallestToLeftArr(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int result[]= new int[heights.length];
        for(int i=0;i<heights.length;i++){
           if(stack.isEmpty()){
              result[i]=-1;
           }
           else if(!stack.isEmpty() && heights[stack.peek()]<heights[i]){
           result[i]=stack.peek();
           }
            else if(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                    
                }
                if(stack.isEmpty()){
              result[i]=-1;
           }
           else{
            result[i]=stack.peek();
           }
        }
         stack.push(i);
      }
      return result;
      }
      public int[] nearestSmallestToRightArr(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int result[]= new int[heights.length];
         for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
              result[i]=heights.length;
           }
           else if(!stack.isEmpty() && heights[stack.peek()]<heights[i]){
           result[i]=stack.peek();
           }
            else if(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                    
                }
                if(stack.isEmpty()){
              result[i]=heights.length;
           }
           else{
            result[i]=stack.peek();
           }
        }
        stack.push(i);
      }
          return result;
    }
}

