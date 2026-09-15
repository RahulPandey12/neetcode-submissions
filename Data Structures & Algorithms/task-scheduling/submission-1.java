class Solution {
    public int leastInterval(char[] tasks, int n) {
        //store frequency in map
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char task: tasks){
            hmap.put(task,hmap.getOrDefault(task,0)+1);
        }
        //Max Heap
        PriorityQueue<Task> availableTasks = new PriorityQueue<>((a,b)->Integer.compare(b.frequency,a.frequency));
        for(Integer freq:hmap.values()){
            availableTasks.add(new Task(freq,0));
        }
        int time=0;
        Queue<Task> coolingTasks = new LinkedList<>();
        while(!availableTasks.isEmpty() ||                  !coolingTasks.isEmpty()){
            time++;
            if(!coolingTasks.isEmpty() && coolingTasks.peek().nextAvailableTime<=time){
                Task task=coolingTasks.poll();
                availableTasks.add(task);
            }
            if(!availableTasks.isEmpty()){
                Task task=availableTasks.poll();
                task.frequency--;
                if(task.frequency>0){
                 task.nextAvailableTime=time+n+1;
                  coolingTasks.add(task);
                }
            }
            

        }
        return time;
    }
}
class Task {
    public int frequency;
    public int nextAvailableTime;
    public Task(int frequency,int nextAvailableTime){
        this.frequency=frequency;
        this.nextAvailableTime=nextAvailableTime;
    }

}
