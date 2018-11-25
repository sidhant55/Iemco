import java.util.*;
import java.io.File;
import java.io.*;

class SegCir {
    long st[];
    int max_size;

    SegCir(long arr[], int n)
    {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max_size];
        constructSTUtil(arr, 0, n - 1, 0);
    }

    long constructSTUtil(long arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    void updateValue(long arr[], int n, int i, long new_val) {
        if (i < 0 || i > n - 1) {
            return;
        }
        long diff = new_val;
        arr[i] =arr[i]+ new_val;
	assert arr[i]<=1000000000: "Balance Add";
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    void updateValueUtil(int ss, int se, int i, long diff, int si) {
        if (i < ss || i > se)
            return;
        st[si] = st[si] + diff;
	assert st[si]<=2000000000: "Tree Add";
        if (se != ss) {
            int mid = ss + (se - ss) / 2;
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    long getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    long getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se)
            return st[si];
        if (se < qs || ss > qe)
            return 0;
        int mid = ss + (se - ss) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    void printVal()
    {
        for (int i=0;i<max_size;i++)
            System.out.print(st[i]+" ");
    }



    public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	File outFile;
    FileWriter fWriter;
    PrintWriter pWriter=null;
	try
	{
		File file =new File("input3.txt");
		in = new Scanner(file);
		outFile = new File ("output3.txt");
		fWriter = new FileWriter (outFile);
		pWriter = new PrintWriter (fWriter);
		System.out.println(file);
	}
	catch(Exception e)
	{
		System.out.println("File Not Found");
	}
        
        int t = in.nextInt();
        while (--t >= 0) {
            int n=in.nextInt();
            int q=in.nextInt();

            long arr[]=new long [3*n];

            for (int i=0;i<n;i++)
            {
                arr[i]=in.nextLong();
                arr[n+i]=arr[i];
                arr[2*n+i]=arr[i];
            }

            SegCir tree=new SegCir(arr,3*n);
	    	int temp=q;
            while(--q>=0)
            {
                int flag=in.nextInt();
                if (flag==1)
                {
                    int b=in.nextInt()-1;
                    long amt=in.nextLong();
                    tree.updateValue(arr,3*n,b,amt);
                    tree.updateValue(arr,3*n,n+b,amt);
                    tree.updateValue(arr,3*n,2*n+b,amt);
                }
                else if (flag==2)
                {
                    int b=in.nextInt()-1;
                    long amt=in.nextLong();
                    int l=in.nextInt();
                    int r=in.nextInt();
			assert ((l+r)<=(n-1)):"error "+(l+" "+r+" "+n );
		assert ((l+r)>=0):"error"+(l+" "+r+" "+n );
                    int left=(n+b)-l;
                    int right=(n+b)+r;
                    long val=tree.getSum(3*n,left,right);
                    if (val<amt)
                        pWriter.println("NO");
                    else
                        pWriter.println("YES");
                }
            }

        }
	pWriter.close();
    }
}
