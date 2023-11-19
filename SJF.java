import java.util.*;
public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //matrix for id,bt,wt,tat
        int[][] Y=new int[100][4];
        int total=0;
        System.out.print("enter the no of process-->");
        int n=sc.nextInt();

        //input busrt time;
        for(int i=0;i<n;i++)
        {
            System.out.print("enter the burst time of "+i+1+" process -->");
            Y[i][1]=sc.nextInt();
            Y[i][0]=i+1;
        }
        //sorting acc to burst time
        for(int i=0;i<n;i++)
        {
            int index=i;
            for(int j=i+1;j<n;j++)
            {
                if(Y[j][1]<Y[index][1])
                {
                    index=j;
                }
            }
            int temp=Y[i][1];
            Y[i][1]=Y[index][1];
            Y[index][1]=temp;
            temp=Y[i][0];
            Y[i][0]=Y[index][0];
            Y[index][0]=temp;
        }
        //calculating weight time;
        Y[0][2]=0;
        for(int i=0;i<n;i++)
        {
            Y[i][2]=0;
            for(int j=0;j<i;j++)
            {
                Y[i][2]+=Y[j][1];
            }
            total+=Y[i][2];
        }
        float avg_wt=(float)total/n;
        total=0;

        System.out.println("Pid\tBT\tWT\tTT");
        for(int i=0;i<n;i++)
        {
            Y[i][3]=Y[i][1]+Y[i][2];
            total+=Y[i][3];
            System.out.println(Y[i][0]+"\t"+Y[i][1]+"\t"+Y[i][2]+"\t"+Y[i][3]);
        }
        float avg_tat=(float)total/n;
        System.out.println("The avg weight time is "+avg_wt);
        System.out.println("The avg Turnaround time is "+avg_tat);
        sc.close();
    }
}
