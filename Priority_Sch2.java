import java.util.*;
class Process{
    int ProcessId;
    int Priority;
    int BurstTime;

    public Process(int ProcessId,int Priority,int BurstTime)
    {
        this.ProcessId=ProcessId;
        this.Priority=Priority;
        this.BurstTime=BurstTime;
    }
}
public class Priority_Sch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of process--> ");

        int prior,burst;
        int n=sc.nextInt();
        ArrayList<Process> process=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            System.out.print("Enter the burstTime of "+i+" process-->");;
            burst=sc.nextInt();
            System.out.print("Enter the priority of "+i+" proces--> ");
            prior=sc.nextInt();
            process.add(new Process(i, prior, burst));
        }

        Collections.sort(process,(p1,p2)->p2.Priority-p1.Priority);

        int weighTime=0;
        int TurnaroundTime;
        System.out.println("Processid\tPriority\tBurstTime\tWaitingTime\tTurnAround");
        for(Process proce: process)
        {
            TurnaroundTime=weighTime+proce.BurstTime;
            System.out.println(proce.ProcessId+"\t\t"+proce.Priority+"\t\t"+proce.BurstTime+"\t\t"+weighTime+"\t\t"+TurnaroundTime);
            weighTime+=proce.BurstTime;


        }

    }
}
