import java.awt.Color;
import java.io.File;
import javax.swing.*;

public class CalcSimulation extends javax.swing.JFrame {
    Job[] jobBatch;
    int numOfJobs;
    public FCFSPolicy fifo;
    String sourcePath;
    static String algo;
    JProgressBar[] pbars = new JProgressBar[10];
    JLabel[] burstTimes = new JLabel[10], waitingTimes = new JLabel[10];
    JLabel[] priorities = new JLabel[10];
    static long STRTTIME;
    
    public CalcSimulation(Job[] jobBatch, int numOfJobs, String sourcePath, String algo) {
        this.jobBatch = jobBatch;
        this.numOfJobs = numOfJobs;
        this.sourcePath = sourcePath;
        this.algo = algo;
        initComponents();
        jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\dark-abstract2.jpg"));
        selectedAlgo.setText(algo);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        pbars[0] = jProgressBar1;
        pbars[1] = jProgressBar2;
        pbars[2] = jProgressBar3;
        pbars[3] = jProgressBar4;
        pbars[4] = jProgressBar5;
        pbars[5] = jProgressBar6;
        pbars[6] = jProgressBar7;
        pbars[7] = jProgressBar8;
        pbars[8] = jProgressBar9;
        pbars[9] = jProgressBar10;
        
        burstTimes[0] = bst1;
        burstTimes[1] = bst2;
        burstTimes[2] = bst3;
        burstTimes[3] = bst4;
        burstTimes[4] = bst5;
        burstTimes[5] = bst6;
        burstTimes[6] = bst7;
        burstTimes[7] = bst8;
        burstTimes[8] = bst9;
        burstTimes[9] = bst10;
        
        waitingTimes[0] = bst11;
        waitingTimes[1] = bst12;
        waitingTimes[2] = bst13;
        waitingTimes[3] = bst14;
        waitingTimes[4] = bst15;
        waitingTimes[5] = bst16;
        waitingTimes[6] = bst17;
        waitingTimes[7] = bst18;
        waitingTimes[8] = bst19;
        waitingTimes[9] = bst20;
        
        priorities[0] = pt1;
        priorities[1] = pt2;
        priorities[2] = pt3;
        priorities[3] = pt4;
        priorities[4] = pt5;
        priorities[5] = pt6;
        priorities[6] = pt7;
        priorities[7] = pt8;
        priorities[8] = pt9;
        priorities[9] = pt10;
        
        STRTTIME = System.nanoTime();
    }

    public void start() {
        if(algo.equals("FCFS")) {
            fifo = new FCFSPolicy(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, fifo, jTextArea1, selectedJob, 
                    pbars, burstTimes, waitingTimes, priorities);
            scheduler.start();
        } else if (algo.equals("Round Robin")) {
            RoundRobinPolicy rr = new RoundRobinPolicy(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, rr, jTextArea1, selectedJob, 
                    pbars, burstTimes, waitingTimes, priorities);
            scheduler.start();
        } else if(algo.equals("Priority Scheduling")) {
            
            jLabel14.setText("Priority");
            
            PriorityPolicy pp = new PriorityPolicy(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, pp, jTextArea1, selectedJob, 
                    pbars, burstTimes, waitingTimes, priorities);
            scheduler.start();
        } else {
            jLabel14.setText("Burst");
            Stack stack = new Stack(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, stack, jTextArea1, selectedJob, 
                    pbars, burstTimes, waitingTimes, priorities);
            scheduler.start();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        algoSelected2 = new javax.swing.JLabel();
        selectedAlgo = new javax.swing.JTextField();
        pt1 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar6 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar7 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar8 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar9 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jProgressBar10 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bst3 = new javax.swing.JLabel();
        bst1 = new javax.swing.JLabel();
        bst2 = new javax.swing.JLabel();
        bst6 = new javax.swing.JLabel();
        bst5 = new javax.swing.JLabel();
        bst4 = new javax.swing.JLabel();
        bst10 = new javax.swing.JLabel();
        bst8 = new javax.swing.JLabel();
        bst7 = new javax.swing.JLabel();
        bst9 = new javax.swing.JLabel();
        bst11 = new javax.swing.JLabel();
        bst12 = new javax.swing.JLabel();
        bst13 = new javax.swing.JLabel();
        bst14 = new javax.swing.JLabel();
        bst15 = new javax.swing.JLabel();
        bst16 = new javax.swing.JLabel();
        bst17 = new javax.swing.JLabel();
        bst18 = new javax.swing.JLabel();
        bst19 = new javax.swing.JLabel();
        bst20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        avgServeLabel = new javax.swing.JLabel();
        selectedJob = new javax.swing.JTextField();
        avgWaitField = new javax.swing.JTextField();
        avgServeField = new javax.swing.JTextField();
        totalExecField = new javax.swing.JTextField();
        avgTurnLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pt2 = new javax.swing.JLabel();
        pt3 = new javax.swing.JLabel();
        pt4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pt5 = new javax.swing.JLabel();
        pt6 = new javax.swing.JLabel();
        pt7 = new javax.swing.JLabel();
        pt8 = new javax.swing.JLabel();
        pt9 = new javax.swing.JLabel();
        pt10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new AbsoluteLayout());

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new AbsoluteConstraints(0, 570, 330, 50));

        jProgressBar1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.add(jProgressBar1, new AbsoluteConstraints(580, 70, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ready Queue");
        jPanel1.add(jLabel2, new AbsoluteConstraints(110, 550, 120, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Algorithm: ");
        jPanel1.add(jLabel3, new AbsoluteConstraints(10, 10, 110, 30));

        algoSelected2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        algoSelected2.setForeground(new java.awt.Color(255, 255, 255));
        algoSelected2.setText("CPU:");
        jPanel1.add(algoSelected2, new AbsoluteConstraints(10, 50, 70, 30));

        selectedAlgo.setBackground(new java.awt.Color(102, 102, 102));
        selectedAlgo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        selectedAlgo.setForeground(new java.awt.Color(255, 255, 255));
        selectedAlgo.setText("jTextField1");
        jPanel1.add(selectedAlgo, new AbsoluteConstraints(120, 10, 250, 30));

        pt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt1.setForeground(new java.awt.Color(255, 255, 255));
        pt1.setText("0");
        jPanel1.add(pt1, new AbsoluteConstraints(470, 70, 30, 30));
        jPanel1.add(jProgressBar2, new AbsoluteConstraints(580, 120, 270, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("P2:");
        jPanel1.add(jLabel4, new AbsoluteConstraints(530, 120, 30, 30));
        jPanel1.add(jProgressBar3, new AbsoluteConstraints(580, 170, 270, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("P3:");
        jPanel1.add(jLabel5, new AbsoluteConstraints(530, 170, 30, 30));
        jPanel1.add(jProgressBar4, new AbsoluteConstraints(580, 220, 270, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("P4:");
        jPanel1.add(jLabel6, new AbsoluteConstraints(530, 220, 30, 30));
        jPanel1.add(jProgressBar5, new AbsoluteConstraints(580, 270, 270, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("P5:");
        jPanel1.add(jLabel7, new AbsoluteConstraints(530, 270, 30, 30));
        jPanel1.add(jProgressBar6, new AbsoluteConstraints(580, 320, 270, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("P6:");
        jPanel1.add(jLabel8, new AbsoluteConstraints(530, 320, 30, 30));
        jPanel1.add(jProgressBar7, new AbsoluteConstraints(580, 370, 270, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("P7:");
        jPanel1.add(jLabel9, new AbsoluteConstraints(530, 370, 30, 30));
        jPanel1.add(jProgressBar8, new AbsoluteConstraints(580, 420, 270, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("P8:");
        jPanel1.add(jLabel10, new AbsoluteConstraints(530, 420, 30, 30));
        jPanel1.add(jProgressBar9, new AbsoluteConstraints(580, 470, 270, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("P9:");
        jPanel1.add(jLabel11, new AbsoluteConstraints(530, 470, 30, 30));
        jPanel1.add(jProgressBar10, new AbsoluteConstraints(580, 520, 270, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("P10:");
        jPanel1.add(jLabel12, new AbsoluteConstraints(530, 520, 30, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Waiting Time");
        jPanel1.add(jLabel13, new AbsoluteConstraints(1110, 20, 120, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Priority");
        jPanel1.add(jLabel14, new AbsoluteConstraints(450, 20, 70, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Remaining Burst Time");
        jPanel1.add(jLabel15, new AbsoluteConstraints(890, 20, 210, 30));

        bst3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst3.setForeground(new java.awt.Color(255, 255, 255));
        bst3.setText("0");
        jPanel1.add(bst3, new AbsoluteConstraints(990, 170, 80, 20));

        bst1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst1.setForeground(new java.awt.Color(255, 255, 255));
        bst1.setText("0");
        jPanel1.add(bst1, new AbsoluteConstraints(990, 70, 80, 20));

        bst2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst2.setForeground(new java.awt.Color(255, 255, 255));
        bst2.setText("0");
        jPanel1.add(bst2, new AbsoluteConstraints(990, 120, 80, 20));

        bst6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst6.setForeground(new java.awt.Color(255, 255, 255));
        bst6.setText("0");
        jPanel1.add(bst6, new AbsoluteConstraints(990, 320, 80, 20));

        bst5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst5.setForeground(new java.awt.Color(255, 255, 255));
        bst5.setText("0");
        jPanel1.add(bst5, new AbsoluteConstraints(990, 270, 80, 20));

        bst4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst4.setForeground(new java.awt.Color(255, 255, 255));
        bst4.setText("0");
        jPanel1.add(bst4, new AbsoluteConstraints(990, 220, 80, 20));

        bst10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst10.setForeground(new java.awt.Color(255, 255, 255));
        bst10.setText("0");
        jPanel1.add(bst10, new AbsoluteConstraints(990, 520, 80, 20));

        bst8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst8.setForeground(new java.awt.Color(255, 255, 255));
        bst8.setText("0");
        jPanel1.add(bst8, new AbsoluteConstraints(990, 420, 80, 20));

        bst7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst7.setForeground(new java.awt.Color(255, 255, 255));
        bst7.setText("0");
        jPanel1.add(bst7, new AbsoluteConstraints(990, 370, 80, 20));

        bst9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst9.setForeground(new java.awt.Color(255, 255, 255));
        bst9.setText("0");
        jPanel1.add(bst9, new AbsoluteConstraints(990, 470, 80, 20));

        bst11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst11.setForeground(new java.awt.Color(255, 255, 255));
        bst11.setText("0");
        jPanel1.add(bst11, new AbsoluteConstraints(1150, 70, 80, 20));

        bst12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst12.setForeground(new java.awt.Color(255, 255, 255));
        bst12.setText("0");
        jPanel1.add(bst12, new AbsoluteConstraints(1150, 120, 80, 20));

        bst13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst13.setForeground(new java.awt.Color(255, 255, 255));
        bst13.setText("0");
        jPanel1.add(bst13, new AbsoluteConstraints(1150, 170, 80, 20));

        bst14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst14.setForeground(new java.awt.Color(255, 255, 255));
        bst14.setText("0");
        jPanel1.add(bst14, new AbsoluteConstraints(1150, 220, 80, 20));

        bst15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst15.setForeground(new java.awt.Color(255, 255, 255));
        bst15.setText("0");
        jPanel1.add(bst15, new AbsoluteConstraints(1150, 270, 80, 20));

        bst16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst16.setForeground(new java.awt.Color(255, 255, 255));
        bst16.setText("0");
        jPanel1.add(bst16, new AbsoluteConstraints(1150, 320, 80, 20));

        bst17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst17.setForeground(new java.awt.Color(255, 255, 255));
        bst17.setText("0");
        jPanel1.add(bst17, new AbsoluteConstraints(1150, 370, 80, 20));

        bst18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst18.setForeground(new java.awt.Color(255, 255, 255));
        bst18.setText("0");
        jPanel1.add(bst18, new AbsoluteConstraints(1150, 420, 80, 20));

        bst19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst19.setForeground(new java.awt.Color(255, 255, 255));
        bst19.setText("0");
        jPanel1.add(bst19, new AbsoluteConstraints(1150, 470, 80, 20));

        bst20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst20.setForeground(new java.awt.Color(255, 255, 255));
        bst20.setText("0");
        jPanel1.add(bst20, new AbsoluteConstraints(1150, 520, 80, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Average Waiting Time:");
        jPanel1.add(jLabel17, new AbsoluteConstraints(10, 200, 220, 50));

        avgServeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgServeLabel.setForeground(new java.awt.Color(255, 255, 255));
        avgServeLabel.setText("Average Turnaround Time:");
        jPanel1.add(avgServeLabel, new AbsoluteConstraints(10, 260, 250, 50));

        selectedJob.setBackground(new java.awt.Color(102, 102, 102));
        selectedJob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        selectedJob.setForeground(new java.awt.Color(255, 255, 255));
        selectedJob.setText("P1");
        jPanel1.add(selectedJob, new AbsoluteConstraints(120, 50, 110, 30));

        avgWaitField.setBackground(new java.awt.Color(102, 102, 102));
        avgWaitField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgWaitField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(avgWaitField, new AbsoluteConstraints(280, 210, 80, 30));

        avgServeField.setBackground(new java.awt.Color(102, 102, 102));
        avgServeField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgServeField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(avgServeField, new AbsoluteConstraints(280, 270, 80, 30));

        totalExecField.setBackground(new java.awt.Color(102, 102, 102));
        totalExecField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalExecField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(totalExecField, new AbsoluteConstraints(280, 330, 80, 30));

        avgTurnLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgTurnLabel1.setForeground(new java.awt.Color(255, 255, 255));
        avgTurnLabel1.setText("Total Execution Time:");
        jPanel1.add(avgTurnLabel1, new AbsoluteConstraints(10, 320, 250, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("P1:");
        jPanel1.add(jLabel16, new AbsoluteConstraints(530, 70, 30, 30));

        pt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt2.setForeground(new java.awt.Color(255, 255, 255));
        pt2.setText("0");
        jPanel1.add(pt2, new AbsoluteConstraints(470, 120, 30, 30));

        pt3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt3.setForeground(new java.awt.Color(255, 255, 255));
        pt3.setText("0");
        jPanel1.add(pt3, new AbsoluteConstraints(470, 170, 30, 30));

        pt4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt4.setForeground(new java.awt.Color(255, 255, 255));
        pt4.setText("0");
        jPanel1.add(pt4, new AbsoluteConstraints(470, 220, 30, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Status Bar");
        jPanel1.add(jLabel18, new AbsoluteConstraints(660, 20, 100, 30));

        pt5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt5.setForeground(new java.awt.Color(255, 255, 255));
        pt5.setText("0");
        jPanel1.add(pt5, new AbsoluteConstraints(470, 270, 30, 30));

        pt6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt6.setForeground(new java.awt.Color(255, 255, 255));
        pt6.setText("0");
        jPanel1.add(pt6, new AbsoluteConstraints(470, 320, 30, 30));

        pt7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt7.setForeground(new java.awt.Color(255, 255, 255));
        pt7.setText("0");
        jPanel1.add(pt7, new AbsoluteConstraints(470, 370, 30, 30));

        pt8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt8.setForeground(new java.awt.Color(255, 255, 255));
        pt8.setText("0");
        jPanel1.add(pt8, new AbsoluteConstraints(470, 420, 30, 30));

        pt9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt9.setForeground(new java.awt.Color(255, 255, 255));
        pt9.setText("0");
        jPanel1.add(pt9, new AbsoluteConstraints(470, 470, 30, 30));

        pt10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt10.setForeground(new java.awt.Color(255, 255, 255));
        pt10.setText("0");
        jPanel1.add(pt10, new AbsoluteConstraints(470, 520, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Programming Files\\CPUSchedulingSimulation\\src\\main\\java\\dark-abstract2.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new AbsoluteConstraints(0, 0, 1250, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algoSelected2;
    public static javax.swing.JTextField avgServeField;
    private javax.swing.JLabel avgServeLabel;
    private javax.swing.JLabel avgTurnLabel1;
    public static javax.swing.JTextField avgWaitField;
    private javax.swing.JLabel bst1;
    private javax.swing.JLabel bst10;
    private javax.swing.JLabel bst11;
    private javax.swing.JLabel bst12;
    private javax.swing.JLabel bst13;
    private javax.swing.JLabel bst14;
    private javax.swing.JLabel bst15;
    private javax.swing.JLabel bst16;
    private javax.swing.JLabel bst17;
    private javax.swing.JLabel bst18;
    private javax.swing.JLabel bst19;
    private javax.swing.JLabel bst2;
    private javax.swing.JLabel bst20;
    private javax.swing.JLabel bst3;
    private javax.swing.JLabel bst4;
    private javax.swing.JLabel bst5;
    private javax.swing.JLabel bst6;
    private javax.swing.JLabel bst7;
    private javax.swing.JLabel bst8;
    private javax.swing.JLabel bst9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar10;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JProgressBar jProgressBar8;
    private javax.swing.JProgressBar jProgressBar9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel pt1;
    private javax.swing.JLabel pt10;
    private javax.swing.JLabel pt2;
    private javax.swing.JLabel pt3;
    private javax.swing.JLabel pt4;
    private javax.swing.JLabel pt5;
    private javax.swing.JLabel pt6;
    private javax.swing.JLabel pt7;
    private javax.swing.JLabel pt8;
    private javax.swing.JLabel pt9;
    private javax.swing.JTextField selectedAlgo;
    private javax.swing.JTextField selectedJob;
    public static javax.swing.JTextField totalExecField;
    // End of variables declaration//GEN-END:variables
}
