import java.util.LinkedList;
import java.util.Scanner;

public class LRU_Page2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of pages:- ");
        int noOfPages = sc.nextInt();

        System.out.print("Enter the number of frames:- ");
        int noOfFrames = sc.nextInt();

        System.out.print("Enter the page-reference string(space seperated ):- ");
        int[] pageRefernce = new int[noOfPages];

        for(int i=0;i<noOfPages;i++)
        {
            pageRefernce[i]=sc.nextInt();
        }

        LinkedList<Integer> frames=new LinkedList<>();
        int pagefault=0;
        for(int page:pageRefernce)
        {
            if(!frames.contains(page))
            {
                if(frames.size()>=noOfFrames)
                {
                    frames.removeFirst();
                }
                pagefault++;
                frames.addLast(page);

            }
            else
            {
                frames.remove(frames.indexOf(page));
                frames.addLast(page);
            }
            System.out.print("Frames:-");
            for(int frame:frames)
            {
                System.out.print(frame+" ");

            }
            System.out.println();
        }
        System.out.println("Total pafefault are -->"+pagefault);
    }
}
