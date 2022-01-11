public interface Scheduler {
   public void allocateCPU(Job job); 
   public Job dequeue();
   public void enqueue(Job job);
   public String getRemainingProcesses();
   public boolean isEmpty();
   public Node peek();
}
