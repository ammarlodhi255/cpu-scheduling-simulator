
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class CPUScheduler extends Thread {
    Job[] jobBatch;
    Scheduler policy;
    JTextArea textArea;
    JTextField textField;
    JProgressBar[] pbars;
    JLabel[] burstTimes;
    ComputationThread[] myThreads = new ComputationThread[SchedulingGUI.NUM_OF_PROCESSES];
    JLabel[] waitingTimes, priorities;
    static int statusSum = 0;
    
    public CPUScheduler(Job[] jobBatch, Scheduler policy, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
            JLabel[] burstTimes, JLabel[] waitingTimes, JLabel[] priorities) {
        this.jobBatch = jobBatch;
        this.policy = policy;
        this.textArea = textArea;
        this.textField = textField;
        this.pbars = pbars;
        this.burstTimes = burstTimes;
        this.waitingTimes = waitingTimes;
        this.priorities = priorities;
    }
    
    public void run() {    
        if(CalcSimulation.algo.equals("FCFS")) {
            Job arrivedJob;
            
            for(int i = 0; i < jobBatch.length; i++) {
                arrivedJob = jobBatch[i];
                policy.enqueue(arrivedJob);
            }
            
            int i = 0;
            while(!policy.isEmpty()) {
                JProgressBar pbar = pbars[i];
                JLabel burstTime = burstTimes[i];
                long arrivalTime = policy.peek().job.arrivalTime;
                //pbar.setBackground(Color.blue);

                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = policy.dequeue();
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                waitingTimes[i].setText(String.valueOf(durationInS) + "s");
                myThreads[i] = new ComputationThread(newJob, policy, textArea, textField, pbar, burstTime);
                myThreads[i].t.start();
                i++;
           }
        } else if(CalcSimulation.algo.equals("Round Robin")) {

            for(int i = 0; i < jobBatch.length; i++) {
                jobBatch[i].progressBar = pbars[i];
                jobBatch[i].burstTimeLabel = burstTimes[i];
                jobBatch[i].waitTimeLabel = waitingTimes[i];
                policy.enqueue(jobBatch[i]); 
            }
            
            int i = 0;
            while(!policy.isEmpty()) {
                long arrivalTime = policy.peek().job.arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}
                
                Job newJob = policy.dequeue();
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                newJob.waitTimeLabel.setText(String.valueOf(durationInS) + "s");
                myThreads[0] = new ComputationThread(newJob, policy, textArea, textField, 
                        newJob.progressBar, newJob.burstTimeLabel);
                myThreads[0].t.start();
                try {
                    myThreads[0].t.join();
                } catch(Exception ex) {}
            }
            
            for(int j = 1; j < myThreads.length; j++)
                myThreads[j] = new ComputationThread(null, null, null, null, null, null);
        } 
        else if (CalcSimulation.algo.equals("Priority Scheduling")) {
            
            MaxPriorityQueue mp = new MaxPriorityQueue();
            MaxPriorityQueue tempmp = new MaxPriorityQueue();
            
            for(int i = 0; i < jobBatch.length; i++) {
                int priority = (new java.util.Random().nextInt(10) + 1);
                JProgressBar pbar = pbars[i];
                JLabel burstTime = burstTimes[i];
                jobBatch[i].progressBar = pbar;
                jobBatch[i].burstTimeLabel = burstTime;
                jobBatch[i].priority = priority;
                jobBatch[i].waitTimeLabel = waitingTimes[i];
                priorities[i].setText(String.valueOf(jobBatch[i].priority));
                mp.insert(jobBatch[i]);
                tempmp.insert(jobBatch[i]);
            }
                 
            while(!tempmp.isEmpty()) {
                policy.enqueue(tempmp.extractMax());
            }
            
            while(!mp.isEmpty()) {
                long arrivalTime = mp.getMax().arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = mp.extractMax();
                policy.dequeue();
                newJob.waitTime = System.nanoTime() - newJob.startTime;
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                newJob.waitTimeLabel.setText(String.valueOf(durationInS) + "s");
                ComputationThread cpu = new ComputationThread(newJob, policy, textArea, 
                        textField, newJob.progressBar, newJob.burstTimeLabel);
                cpu.t.start();
                
                try {
                    cpu.t.join();
                } catch(InterruptedException ex) {}
           }
        } else {
            MaxPriorityQueue tempmp = new MaxPriorityQueue();
            
            for(int i = 0; i < jobBatch.length; i++) {
                int priority = (int) jobBatch[i].burstTime;
                JProgressBar pbar = pbars[i];
                JLabel burstTime = burstTimes[i];
                jobBatch[i].progressBar = pbar;
                jobBatch[i].burstTimeLabel = burstTime;
                jobBatch[i].priority = priority;
                jobBatch[i].waitTimeLabel = waitingTimes[i];
                priorities[i].setText(String.valueOf(jobBatch[i].priority));
                tempmp.insert(jobBatch[i]);
            }
            
            while(!tempmp.isEmpty()) {
                policy.enqueue(tempmp.extractMax());
            }
            
            while(!policy.isEmpty()) {
                long arrivalTime = policy.peek().job.arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = policy.dequeue();
                newJob.waitTime = System.nanoTime() - newJob.startTime;
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                newJob.waitTimeLabel.setText(String.valueOf(durationInS) + "s");
                ComputationThread cpu = new ComputationThread(newJob, policy, textArea, 
                        textField, newJob.progressBar, newJob.burstTimeLabel);
                cpu.t.start();
                
                try {
                    cpu.t.join();
                } catch(InterruptedException ex) {}
           }
        }
        
        System.out.println("GOT OUT");
        if(!CalcSimulation.algo.equals("Priority Scheduling") && 
                !CalcSimulation.algo.equals("Shortest Job First")) {
            try {
                for(int j = 0; j < myThreads.length; j++)
                    myThreads[j].t.join();
            } catch(InterruptedException ex) {}
        }
        
        textField.setText("Idle");
        textField.setForeground(Color.red);
        
        long avgWaitTime = 0;
        long avgTurnaroundTime = 0;
        long totalExecutionTime = 0;
        
        for(int j = 0; j < jobBatch.length; j++) {
            avgWaitTime += jobBatch[j].waitTime;
            avgTurnaroundTime += jobBatch[j].endTime;
        }
        
        avgWaitTime /= jobBatch.length;
        avgWaitTime = TimeUnit.NANOSECONDS.toSeconds(avgWaitTime);
        CalcSimulation.avgWaitField.setText(String.valueOf(avgWaitTime) + "s");
        
        avgTurnaroundTime = TimeUnit.NANOSECONDS.toSeconds(avgTurnaroundTime/jobBatch.length);
        CalcSimulation.avgServeField.setText(String.valueOf(avgTurnaroundTime) + "s");
        
        totalExecutionTime = System.nanoTime() - CalcSimulation.STRTTIME;
        totalExecutionTime = TimeUnit.NANOSECONDS.toSeconds(totalExecutionTime);
        CalcSimulation.totalExecField.setText(String.valueOf(totalExecutionTime) + "s");
    }
    
}
