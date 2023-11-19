import java.util.*;
public class SJF2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int total=0,temp;
        int[][] arr=new int[10][4];
        System.out.println("enter the no of process-->");
        int  n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the burst time of "+(i+1)+" process->");
            arr[i][1]=sc.nextInt();
            arr[i][0]=i+1;
        }        
        //sorting
        for(int i=0;i<n-1;i++)
        {
            int index=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j][1]<arr[index][1])
                {
                    index=j;
                }
            }
            temp=arr[i][1];
            arr[i][1]=arr[index][1];
            arr[index][1]=temp;
            temp=arr[i][0];
            arr[i][0]=arr[index][0];
            arr[index][0]=temp;
        }
        //waiting time;
        arr[0][2]=0;
        for(int i=0;i<n;i++)
        {
            arr[i][2]=0;
            for(int j=0;j<i;j++)
            {
                arr[i][2]+=arr[j][1];
            }
            total+=arr[i][2];
        }
        float avg_wt=(float)total/n;
        total=0;
        System.out.println("Process\tBurst\tWaiting\tTurnaround\n");
        for(int i=0;i<n;i++)
        {
            arr[i][3]=arr[i][1]+arr[i][2];
            System.out.println(arr[i][0]+"\t"+arr[i][1]+"\t"+arr[i][2]+"\t"+arr[i][3]);
            total+=arr[i][3];
        }
        float avg_tat=(float)total/n;
        System.out.println("Turn around -->"+avg_tat);
        System.out.println("Waiting time-->"+avg_wt);
        sc.close();
    }
}
