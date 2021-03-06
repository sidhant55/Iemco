import java.util.*;

public class Solution { 

    static final int ALPHABET_SIZE = 16; 
    
    static HashMap<Character,Integer> hm=new HashMap<>();
    
   
    static class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
        boolean isEndOfWord; 
        int count;
          
        TrieNode(){ 
            isEndOfWord = false; 
            count=1;
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
            
            hm.put('0',0);
			hm.put('1',1);
			hm.put('2',2);
			hm.put('3',3);
			hm.put('4',4);
			hm.put('5',5);
			hm.put('6',6);
			hm.put('7',7);
			hm.put('8',8);
			hm.put('9',9);
			hm.put('A',10);
			hm.put('B',11);
			hm.put('C',12);
			hm.put('D',13);
			hm.put('E',14);
			hm.put('F',15);
        } 
    }; 
       
    static TrieNode root;  

    static void insert(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = hm.get(key.charAt(level));
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
            else
            	pCrawl.children[index].count++;
       
            pCrawl = pCrawl.children[index]; 
            
        } 
       
        pCrawl.isEndOfWord = true; 
    } 
       
    static int search(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode pCrawl = root; 
        int i=0;
       
        for (level = 0; level < length; level++) 
        { 
            index = hm.get(key.charAt(level)); 
       
            if (pCrawl.children[index] == null) 
                break;
       
            pCrawl = pCrawl.children[index]; 
            i++;
        } 
       
        return ( i == length ) ? pCrawl.count : 0;
    }
       
 
    public static void main(String args[]) 
    {
    	
    	Scanner in=new Scanner(System.in);
        root = new TrieNode(); 
        
        int n=in.nextInt();
        int q=in.nextInt();
        
        if (n>100000 || q>100000)
        throw new RuntimeException("mmm");
        
        assert n<=100000: "problem in n";
        assert q<=100000: "problem is q";
        
        for(int i=0;i<n;i++)
        {
        	String x=in.next();
        	int l=x.length();
        	if (l>100)
        	throw new RuntimeException("mmm");
        	assert l<=100: "problem in length1";
        	insert(x);
        }
       
        for(int i=0;i<q;i++)
        {
        	String x=in.next();
        	int l=x.length();
        	if (l>100)
        	throw new RuntimeException("mmm");
        	assert l<=100: "problem in length2";
        	System.out.println(search(x));
        }
         
    } 
} 
