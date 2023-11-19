import java.util.*;
public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of process-->");
        int n= sc.nextInt();
        int[] at=new int[n];//arrival time;
        int[] bt=new int[n];//burst time
        int[] ct=new int[n];//completion time
        int[] wt=new int[n];//weight time
        int[] tat=new int[n];//turnaroundtime 
        int[] id=new int[n]; //id
        int temp;
        float avg_wt=0,avg_tat=0;

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the Arrival time of "+(i+1)+" process-->");
            at[i]= sc.nextInt();
            System.out.print("Enter the burst time of "+(i+1)+" process-->");
            bt[i]=sc.nextInt();
            id[i]=i+1;
        }
        //sorting on the basis of arrival time
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(at[j]>at[j+1])
                {
                    temp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=temp;
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
                    temp=id[j];
                    id[j]=id[j+1];
                    id[j+1]=temp;
                }
            }
        }
        //calculating completion time
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                ct[i]=at[i]+bt[i];
            }
            else if(at[i] > ct[i-1])
            {
                ct[i]=at[i]+bt[i];
            }
            else
            {
                ct[i]=ct[i-1]+bt[i];
            }
            tat[i]=ct[i]-at[i];
            wt[i]=tat[i]-bt[i];
            avg_tat+=tat[i];
            avg_wt+=wt[i];

        }
        System.out.println("\npid  arrival busrt completion turn weight\n");
        for(int i=0;i<n;i++)
        {
            System.out.println(id[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
        System.out.println("The total weight time is "+avg_wt);
        System.out.println("The total TurnAround time is "+avg_tat);
        sc.close();
    }
}
