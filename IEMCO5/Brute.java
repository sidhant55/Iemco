import java.util.*;
import java.io.*;

class inputs
{
    public BufferedReader reader;
    public StringTokenizer token;
    
    inputs(InputStream str)
    {
        reader=new BufferedReader(new InputStreamReader(str));
        token=null;
    }
    
    int nextInt()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return Integer.parseInt(token.nextToken());
    }
    
    long nextLong()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return Long.parseLong(token.nextToken());
    }
    
    String next()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return token.nextToken();
    }
    
}


class Solution {

    public static void main(String args[]) {
        inputs in = new inputs(System.in);
        int t = in.nextInt();
        while (--t >= 0) {
            int n=in.nextInt();
            int q=in.nextInt();

            long arr[]=new long [n];

            for (int i=0;i<n;i++)
            {
                arr[i]=in.nextLong();
            }

            while(--q>=0)
            {
                int flag=in.nextInt();
                if (flag==1)
                {
                    int b=in.nextInt()-1;
                    long amt=in.nextLong();
                    arr[b]=arr[b]+amt;
                }
                else if (flag==2)
                {
                    int b=in.nextInt()-1;
                    long amt=in.nextLong();
                    int l=in.nextInt();
                    int r=in.nextInt();
                    int left=(n+b)-l;
                    int right=(n+b)+r;
                    long val=0;
					for (int i=left;i<=right;i++)
					{
						i=i%n;
						val=val+arr[i];
			
					}	
                    if (val<amt)
                        System.out.println("NO");
                    else
                        System.out.println("YES");
                }
            }

        }
    }
}
