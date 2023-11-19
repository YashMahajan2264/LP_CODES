import java.util.*;
public class LRU_PageReplace {
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

        LinkedList<Integer>frames = new LinkedList<>();
        int pagefault =0;

        for(int page : pageRefernce)
        {
            if(!frames.contains(page))
            {
                if(frames.size() >= noOfFrames)
                {
                    frames.removeFirst();
                    
                }
                frames.addLast(page);
                pagefault++;
            }
            else
            {
                frames.remove(frames.indexOf(page));//Move the used page to the end
                frames.addLast(page);
            }

            System.out.print("Frames:- ");
            for(int frame : frames)
            {
                System.out.println(frame+" ");

            }
            System.out.println();
        }
        System.out.println("The Total number of page fault :- "+pagefault);
        sc.close();

    }
}
