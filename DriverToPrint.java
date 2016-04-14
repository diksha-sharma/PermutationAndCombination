/**
 * Created by dxs134530 on 4/13/2016.
 */
public class DriverToPrint
{
    private static int phase = 0;
    private static long startTime, endTime, elapsedTime;
    public static void main(String args[])
    {
        //Execute take 2 version of Heap's permutation algorithm
        System.out.println("Heap's Algorithm Output");
        System.out.println("***********************");
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = arr1;
        Permute p1 = new Permute();
        p1.arr = arr1;
        timer();
        p1.heapsAlgorithm(arr1.length, true);
        System.out.println("Total number of permutations: " + p1.iCount);
        timer();
        System.out.println();

        //Execute take 2 version of permutation algorithm
        System.out.println("Permutation Take 2 Algorithm Output");
        System.out.println("***********************************");
        //Resetting count to 0 for next algorithm
        p1.iCount = 0;
        Permute p2 = new Permute();
        phase = 0;
        p2.arr = arr2;
        timer();
        p2.permuteTake2(arr2.length, true);
        System.out.println("Total number of permutations: " + p2.iCount);
        timer();
        System.out.println();

        //Execute combination algorithm
        System.out.println("Combination Algorithm Output");
        System.out.println("****************************");
        phase = 0;
        int[] arr3 = {2,3,4,5};
        Combine c = new Combine();
        //Initialize the array to false
        c.bArr = new boolean[arr3.length];
        c.arr = arr3;
        for(int i=0; i< c.bArr.length; i++)
        {
            c.bArr[i] = false;
        }
        int iN = arr3.length;
        int iK = 2;
        if(iK < iN)
        {
            c.k = iK;
            timer();
            c.combine(iN, iK, true);
            System.out.println("Total number of combinations: " + c.iCount);
            timer();
        }
        else if(iK == iN)
        {
            timer();
            System.out.println("Total number of combinations: " + 1);
            timer();
        }
        else
        {
            System.out.println("Combination not possible for the input");
        }
    }

    public static void timer()
    {
        if (phase == 0)
        {
            startTime = System.currentTimeMillis();
            phase = 1;
        }
        else
        {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.println("Time: " + elapsedTime + " msec.");
            memory();
            phase = 0;
        }
    }

    public static void memory()
    {
        long memAvailable = Runtime.getRuntime().totalMemory();
        long memUsed = memAvailable - Runtime.getRuntime().freeMemory();
        System.out.println("Memory: " + memUsed / 1000000 + " MB / " + memAvailable / 1000000 + " MB.");
    }

}
