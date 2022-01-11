import java.io.*;
import javax.swing.*;

public class RoundRobinPolicy implements Scheduler {
    static final long TIME_QUANTUM = 140; // quantum of time is set to 150s
    File sourceFile;
    
    RoundRobinPolicy(File sourceFile) {
        this.sourceFile = sourceFile;
    }
    
    Node head = null;
    Node tail = null;

    public void enqueue(Job job) {
        Node newNode = new Node(job);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void allocateCPU(Job job) {
        
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(sourceFile));
            String str = new String();
            while((str = bufReader.readLine()) != null) {
                
            }
            
            String remProcesses = getRemainingProcesses();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "IO Error");
            return;
        }
    }

    public Job dequeue() {
        if(isEmpty()) {
            return null;
        } else {
            Job tempJob = head.job;
            head = head.next;
            tempJob.waitTime = System.nanoTime() - tempJob.startTime;
            return tempJob;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public String getRemainingProcesses() {
        Node trav = head;
        String rem = new String();
        if(isEmpty()) return "";
        else {
            while(trav != null) {
                rem += trav.job.processID + " ";
                trav = trav.next;
            }
        }
        return rem;
    }
    
    public Node peek() {
        return head;
    }
}