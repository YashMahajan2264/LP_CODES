import java.util.*;
public class FIFO_PageReplace {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);

   System.out.print("Enter the number of pages:- ");
   int noOfPages = sc.nextInt();

   System.out.print("Enter the number of frames:- ");
   int noOfFrames = sc.nextInt();

   System.out.print("Enter the page-reference string(space seperated ):- ");
   int[] pageRefernce = new int[noOfPages];

   for(int i=0;i<noOfPages ;i++)
   {
    pageRefernce[i]=sc.nextInt();
   }

   int[] frames = new int[noOfFrames];
   Arrays.fill(frames,-1);

   int pagefault = 0;
   int currentindex =0;

   for(int page : pageRefernce)
   {
    boolean pagehit = false;

    for(int frame : frames)
    {
        if(frame == page)
        {
            pagehit = true;
            break;
        }
    }
    if(!pagehit)
    {
        frames[currentindex]=page;
        currentindex =(currentindex+1)%noOfFrames;
        pagefault++;
    }

    System.out.print("Frames:- ");
    for(int frame: frames)
    {
        System.out.print(frame+" ");
    }
    System.out.println();
   }
    System.out.println("The total no of page fault :- "+pagefault);
    sc.close();
 }
}