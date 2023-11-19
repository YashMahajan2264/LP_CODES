import java.util.*;
public class Optimal_Page2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of frames:-");
        int noOfFrames = sc.nextInt();

        System.out.print("Enter the number of pages :-");
        int noOfPages = sc.nextInt();

        System.out.print("Enter the page reference string e.g. 1 2 3 4--> ");
        sc.nextLine();
        String input=sc.nextLine();
        String[] refeStrings=input.split(" ");

        if(refeStrings.length != noOfPages)
        {
            System.out.println("The no of pages is not equal to input string length");
            return;
        }

        ArrayList<Integer> frames =  new ArrayList<>();

        int pagefault=0;
        for(int i=0;i<noOfPages;i++)
        {
            int page=Integer.parseInt(refeStrings[i]);
            if(!frames.contains(page))
            {
                pagefault++;
                if(frames.size()<noOfFrames)
                {
                    frames.add(page);
                }
                else
                {
                    int index=optimal_page(frames,refeStrings,i);
                    frames.set(index,page);
                }
            }
        }
        System.out.println("The total page faults are--> "+pagefault);
        
    }
    public static int optimal_page(ArrayList<Integer> frames,String[] refStrings,int currentIndex)
    {
        int farthest=-1;
        int index=-1;
        for(int i=0;i<frames.size();i++)
        {
            int frame=frames.get(i);
            int j;
            for(j=currentIndex+1;j<refStrings.length;j++)
            {
                if(frame==Integer.parseInt(refStrings[j]))
                {
                    if(j>index)
                    {
                        farthest=j;
                        index=i;
                    }
                    break;
                }
            }
            if(j==refStrings.length)
            {
                return i;
            }
        }
        return (index==-1)?0:index;
    }
}
