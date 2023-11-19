import java.util.*;
public class Optimal_PageReplace {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of frames:-");
        int noOfFrames = sc.nextInt();

        System.out.print("Enter the number of pages :-");
        int noOfPages = sc.nextInt();

        System.out.print("Enter the page refernces string eg. 1 2 3 4: -");
        sc.nextLine();//Consume the new line
        String input = sc.nextLine();

        String[] referenceString = input.split(" ");
        if(referenceString.length!= noOfPages)
        {
            System.out.println("Number of refrences does not  match to input string length");
            return;
        }

        ArrayList<Integer> frames = new ArrayList<>();
        int pagefault =0;
        for(int i=0;i<noOfPages ;i++)
        {
            int page = Integer.parseInt(referenceString[i]);
            if(!frames.contains(page))
            {
                pagefault++;
                if(frames.size() < noOfFrames)
                {
                    frames.add(page);

                }
                else
                {
                    int index = predictOptimal(frames,referenceString,i);
                    frames.set(index,page);
                }
            }
        }
        System.out.println("The total number of page faults are "+pagefault);
        sc.close();

    }
    private static int predictOptimal(ArrayList<Integer> frames, String[] referenceString, int currentIndex)
    {
        int farthest =-1;
        int index =-1;
        for(int i=0;i<frames.size();i++)
        {
            int frame=frames.get(i);
            int j;
            for( j=currentIndex+1;j<referenceString.length;j++)
            {
                if(frame == Integer.parseInt(referenceString[j]))
                {
                    if( j > farthest)
                    {
                        farthest =j;
                        index=i;
                    }
                    break;
                }
            }
            if(j == referenceString.length)
            {
                return i;
            }
        }
        return (index ==-1 )?0:index;
    } 
}
