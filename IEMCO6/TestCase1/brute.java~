import java.util.*;
import java.io.*;
import java.io.File;
public class brute { 
       
 
    public static void main(String args[]) throws FileNotFoundException
    {
    	
    	Scanner in=new Scanner(System.in);
	File outFile;
    FileWriter fWriter;
    PrintWriter pWriter=null;
	try
	{
		File file =new File("input0.txt");
		in = new Scanner(file);
		outFile = new File ("output0.txt");
		fWriter = new FileWriter (outFile);
		pWriter = new PrintWriter (fWriter);
		System.out.println(file);
	}
	catch(Exception e)
	{
		System.out.println("File Not Found");
	}
        
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
        	pWriter.println(c);
        }
        pWriter.close();
         
    } 
} 
