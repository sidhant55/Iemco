import java.util.*;
public class brute { 
       
 
    public static void main(String args[])
    {
    	
    	Scanner in=new Scanner(System.in);
        
        int n=in.nextInt();
        int q=in.nextInt();
        
        Set<String> hm=new TreeSet<String>();
        String arr[]=new String[n];
        
        for(int i=0;i<n;i++)
        {
        	String x=in.next();
        	arr[i]=x;
        	hm.add(x);
        }
       
        for(int i=0;i<q;i++)
        {
        	String x=in.next();
        	int c=0;
        	for(int j=0;j<n;j++)
        	{
        		if(x.equals(arr[j].substring(0,x.length())))
        		c++;
        	}
        	System.out.println(c);
        }
         
    } 
} 
