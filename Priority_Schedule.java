import java.util.*;
class Process
{
    int processId;
    int burstTime;
    int priority;

    public Process(int processId,int burstTime,int priority)
    {
        this.processId=processId;
        this.burstTime=burstTime;
        this.priority=priority;
    }
}
public class Priority_Schedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Process> processess = new ArrayList<>();

        System.out.print("Enter the number of process:- ");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++)
        {
            System.out.print("Enter the burst time of "+ i+" process-->");
            int burst = sc.nextInt();
            System.out.print("Enter the priority of "+i+" process-->");
            int prior=sc.nextInt();
            processess.add(new Process(i, burst, prior));
        }
        //sort on priority
        Collections.sort( processess, (p1,p2)->p2.priority-p1.priority);

        int weightTime=0;
        int turnAroundTime;
        System.out.println("ProcessId\tBurstTime\tPriority\tWeightTime\tTurnAT\n");
        for(Process process : processess)
        {
            turnAroundTime=weightTime + process.burstTime;
            System.out.println(process.processId+"\t\t"+process.burstTime+"\t\t"+process.priority+"\t\t"+
            weightTime+"\t\t"+turnAroundTime);

            weightTime+=process.burstTime;

        }
        sc.close();
    }
}
