/**
 * Created by dxs134530 on 4/13/2016.
 */
public class Permute
{
    public static int[] arr;
    public static int iCount = 0;

    //Heap's Algorithm implementation
    public static void heapsAlgorithm(int n, boolean bPrintOutput)
    {
        //Reference: https://en.wikipedia.org/wiki/Heap%27s_algorithm
        if (n == 1)
        {
            if(bPrintOutput == true)
            {
                for(int j=0; j< arr.length; j++)
                {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
            iCount++;
        }
        else
        {
            for(int i=0; i< n-1; i++)
            {
                heapsAlgorithm(n-1, bPrintOutput);
                if(n%2 ==0)
                {
                    int temp = arr[n-1];
                    arr[n-1] = arr[i];
                    arr[i] = temp;
                }
                else
                {
                    int temp = arr[n-1];
                    arr[n-1] = arr[0];
                    arr[0] = temp;
                }
            }
            heapsAlgorithm(n-1, bPrintOutput);
        }
    }

    public static void visit(boolean bPrintOutput)
    {
        if(bPrintOutput == true)
        {
            for(int i=0; i< arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    //Take 2 permutation algorithm
    public static void permuteTake2(int i, boolean bPrintOutput)
    {
        if(i == 0)
        {
            visit(bPrintOutput);
            iCount++;
        }
        else
        {
            for(int j=0; j< i; j++)
            {
                //Swap elements at j and i positions
                int iTemp1 = arr[j];
                arr[j] = arr[i-1];
                arr[i-1] = iTemp1;

                permuteTake2(i-1, bPrintOutput);

                //Swap elements back at j and i positions
                int iTemp2 = arr[j];
                arr[j] = arr[i-1];
                arr[i-1] = iTemp2;
            }
        }
    }
}
