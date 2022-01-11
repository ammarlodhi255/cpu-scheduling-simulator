import javax.swing.*;

public class ComputationThread implements Runnable {
    Scheduler policy;
    Thread t;
    Job job;
    JTextField textField;
    JTextArea readyQueue;
    JProgressBar pbar;
    JLabel burstTime;
    
    ComputationThread(Job job, Scheduler policy, JTextArea readyQueue, JTextField textField, 
            JProgressBar pbar, JLabel burstTime) {
        this.policy = policy;
        t = new Thread(this);
        this.job = job;
        this.readyQueue = readyQueue;
        this.textField = textField;
        this.pbar = pbar;
        this.burstTime = burstTime;
    }
    
    public void assignJob(Job job) {
        this.job = job;
    }
    
    public void run() {
        policy.allocateCPU(job);
        boolean status = true;
        
        if(CalcSimulation.algo.equals("FCFS") || CalcSimulation.algo.equals("Priority Scheduling")
                || CalcSimulation.algo.equals("Shortest Job First")) {
            int min = 0;
            int max = (int) job.burstTime;
            
            pbar.setMinimum(min);
            pbar.setMaximum(max);
            pbar.setValue(0);
            
            String remProcesses = policy.getRemainingProcesses();
            readyQueue.setText(remProcesses);

            int remainingBurstTime = (int) job.burstTime; 

            for(int i = 0; i < max; i++) {
                pbar.setValue(i);
                try {
                    Thread.sleep(50);
                    synchronized(this) {
                        textField.setText("");
                        textField.setText(job.processID);
                    }
                } catch(InterruptedException ex) {}
                remainingBurstTime--;
                burstTime.setText(String.valueOf(remainingBurstTime) + "ms");
            }
            
            if(status) {
                CPUScheduler.statusSum++;
                System.out.println(CPUScheduler.statusSum);
            }
        } else if(CalcSimulation.algo.equals("Round Robin")) {
            int min = job.pBarValue;
            int max = (int) job.burstTime;
            
            pbar.setMinimum(0);
            pbar.setMaximum(max);

            int remainingBurstTime = (int) job.lastRemainingBurst; 
            int exceedTime = 0;
            
            String remProcesses = policy.getRemainingProcesses();
            readyQueue.setText(remProcesses);
            
            for(int i = min; i < max; i++) {
                pbar.setValue(i);
                try {
                    Thread.sleep(50);
                    
                    if(exceedTime == RoundRobinPolicy.TIME_QUANTUM - 1 && remainingBurstTime > 0) { 
                        job.lastRemainingBurst = remainingBurstTime;
                        job.pBarValue = i;
                        policy.enqueue(job);
                        break;
                    }
                    synchronized(this) {
                        textField.setText("");
                        textField.setText(job.processID);
                    }
                } catch(InterruptedException ex) {}
                remainingBurstTime--;
                burstTime.setText(String.valueOf(remainingBurstTime) + "ms");
                exceedTime++;
            }
            
            readyQueue.setText(policy.getRemainingProcesses());
        } 
        
        job.endTime = System.nanoTime() - job.startTime;
        //remProcesses = policy.getRemainingProcesses();
       // readyQueue.setText(remProcesses);
    }
}
