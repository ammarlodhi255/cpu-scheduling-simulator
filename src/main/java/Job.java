import javax.swing.*;

public class Job {
    long burstTime;
    long arrivalTime;
    String processID;
    long startTime;
    long endTime;
    long waitTime;
    JProgressBar progressBar;
    JLabel burstTimeLabel;
    int lastRemainingBurst;
    JLabel waitTimeLabel;
    int pBarValue = 0;
    int priority;
    
    public Job(String processID, long arrivalTime, long burstTime, long startTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.startTime = startTime;
        lastRemainingBurst = (int) burstTime;
    }
}
