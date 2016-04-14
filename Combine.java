/**
 * Created by dxs134530 on 4/13/2016.
 */
public class Combine
{
    public static boolean[] bArr;
    public static int[] arr;
    public static int iCount = 0;
    public static int k;
    public static void visit(boolean bPrintOutput)
    {
        int iTrueCount = 0;
        for(int i=0; i< bArr.length; i++)
        {
            if(bArr[i])
            {
                iTrueCount++;
            }
        }
        if(iTrueCount == k)
        {
            iCount++;
            if(bPrintOutput == true)
            {
                for(int i=0; i< bArr.length; i++)
                {
                    if(bArr[i])
                    {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void combine(int n, int k, boolean bPrintOutput)
    {
        if (k == 0)
        {
            visit(bPrintOutput);
        }
        else if (k > n && n==0)
        {
            bArr[0] = true;
            combine(0, k-1, bPrintOutput);
            bArr[0] = false;
            return;
        }
        else
        {
            combine(n-1, k, bPrintOutput);
            if(n < bArr.length)
            {
                bArr[n] = true;
            }
            combine(n-1, k-1, bPrintOutput);
            if(n< bArr.length)
            {
                bArr[n] = false;
            }
        }
    }
}
