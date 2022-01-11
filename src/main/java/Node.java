public class Node {
    Node next;
    Job job;
        
    Node(Job job) {
        this.job = job;
        next = null;
    }
 }
