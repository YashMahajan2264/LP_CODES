import java.util.*;
public class RoundRobin {
    public static void main(String[] args) {
        int i,n,sq=0,qt,bt[],rem_bt[],wt[],tat[],temp,count=0;
        float avg_tat=0,avg_wt=0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of process (not more than 10)-->");
        n=sc.nextInt();
        bt=new int[10];
        wt=new int[10];
        tat=new int[10];
        rem_bt=new int[10];

        System.out.print("Enter the burst time-->");
        for( i=0;i<n;i++)
        {
            System.out.print("p"+(i+1)+"-->");
            bt[i]=sc.nextInt();
            rem_bt[i]=bt[i];
        }
        System.out.print("Enter the quqntum time -->");
        qt=sc.nextInt();

        while(true)
        {
            for(i=0,count=0;i<n;i++)
            {
                temp=qt;
                if(rem_bt[i]==0)
                {
                    count++;
                    continue;
                }
                if(rem_bt[i]>qt)
                {
                    rem_bt[i]=rem_bt[i]-qt;
                }
                else
                if(rem_bt[i]>=0)
                {
                    temp=rem_bt[i];
                    rem_bt[i]=0;
                }
                sq=sq+temp;
                tat[i]=sq;
                
            }
            if(count==n)
            break;
        }
        System.out.println("----------------------------------------------");
        System.out.println("\nProcess\tBurstTime\tTurnAround\tWaitingTime\n");
        for( i=0;i<n;i++)
        {
            wt[i]=tat[i]-bt[i];
            avg_tat=tat[i];
            avg_wt=wt[i];
            System.out.println((i+1)+"\t\t"+bt[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
        }
        avg_tat=avg_tat/n;
        avg_wt=avg_wt/n;
        System.out.println("The avg waiting time is "+avg_wt);
        System.out.println("The avg turnaround Time  is "+avg_tat);


    }
}
