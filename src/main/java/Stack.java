
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

// Stack implementation with Singly Linked List:
class Stack implements Scheduler {
    private Node top;
    Stack() { top = null; }
    File sourceFile;
    
    Stack(File sourceFile) {
        this.sourceFile = sourceFile;
        top = null;
    }
    
    public boolean isEmpty() { return top == null; }

    public Node peek() {
        if(isEmpty())
            throw new RuntimeException("StackUnderFlow");
        return top;
    }

    public void enqueue(Job job) {
        Node newest = new Node(job);
        if(isEmpty()) top = newest;
        else {
            newest.next = top;
            top = newest;
        }
    }

    public Job dequeue() {
        if(isEmpty())
            throw new RuntimeException("StackUnderflow");
        Job data = top.job;
        top = top.next;
        return data;
    }
    
    public String getRemainingProcesses() {
        Node trav = top;
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
}

