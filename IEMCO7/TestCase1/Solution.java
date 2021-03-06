import java.util.*;
import java.io.*;
/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
Integer.parseInt(st.nextToken());
Long.parseLong(st.nextToken());
Scanner sc = new Scanner(System.in);


*/

public class code{
    
    static HashMap<Integer,Node> luckup = new HashMap<Integer,Node>();
    static int par[];
    public static class Info{
        int paths;
        long value;
        public Info(int p,long v){
            paths = p;
            value = v;
        }
    }
    
    public static class Node{
        int id;
        long w;
        int parent;
        int nbf;
        int fils_termine;
        int paths;
        LinkedList<Info> values = new LinkedList<Info>();
        public Node(int id,long w){
            this.id = id;
            this.w = w;
            nbf = 0;
            fils_termine = 0;
            paths = 0;
        }
    }
    
    public static Node getNode(int id){
        return luckup.get(id);
    }
    
    public static int bfs(int n,int l,long s){
        
        LinkedList<Integer> nextToVisit = new LinkedList<Integer>();
        Node node;
        for(int i=1;i<=n;i++){
            node = getNode(i);
            if(node.w>s) return -1;
            if(node.nbf==0){
                node.values.add(new Info(1,node.w));
                nextToVisit.add(i);
            }
        }
        
        Info i;
        Info ip;
        long wp;
        int rep = 0;
       
        while(!nextToVisit.isEmpty()){
            node = getNode(nextToVisit.poll());
            Iterator<Info> it = node.values.iterator();
            
            if(node.id==1){
                
                return (node.paths+1);
            }
            wp = getNode(node.parent).w;
            
            while(it.hasNext()){
                i = it.next();
                
                i.paths++;
                if(i.paths>l) continue;
                i.value += wp;
                if(i.value>s) continue;
                Iterator<Info> itp = getNode(node.parent).values.iterator();
                rep = 0;
                while(itp.hasNext()){
                    ip = itp.next();
                    rep = verifie(i,ip);
                    if(rep == 1) {
                        itp.remove();
                        continue;
                    }
                    if(rep == -1) break;
                    
                }
                if(rep == -1) continue;
                getNode(node.parent).values.add(i);
               
            }
            getNode(node.parent).paths++;
            getNode(node.parent).paths += node.paths;
            getNode(node.parent).nbf--;
            if(getNode(node.parent).nbf==0){
                nextToVisit.add(node.parent);
                if(!getNode(node.parent).values.isEmpty()){
                    getNode(node.parent).paths--;
                }
                if(getNode(node.parent).values.isEmpty()){
                    getNode(node.parent).values.add(new Info(1,wp));
                    
                }
            }
           
            
        }
        return -1;
    }
    
    public static int verifie(Info i1,Info i2){
        // i2 hia dial linkedList dial parent
        
        // -1 i1 mamezianach
        // 1 i2 mamezianach
        // 0 bjoj zwane
        if(i1.value>=i2.value && i1.paths>=i2.paths) return -1;
        if(i1.paths<=i2.paths && i1.value<=i2.value) return 1;
        return 0;
    }
    
    
    static void DFSUtil(ArrayList<ArrayList<Integer>> arr, int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = arr.get(v).listIterator(); 
        while (i.hasNext()) 
        { 
            
            int n = i.next(); 
            
            if (!visited[n]) 
            {
            	par[n]=v;
                DFSUtil(arr, n, visited); 
                }
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    static void DFS(ArrayList<ArrayList<Integer>> arr,int v, int V) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(arr, v, visited); 
    } 
    
    
    
    
    public static void main(String[] args) throws Exception{
    
    
    
    Scanner in=new Scanner(System.in);
	
	int t=in.nextInt();
	String ans="";
	int k=0;
	
	while(--t>=0)
	{
		k++;
		if(k==6)
		{
			System.out.println(n);
		}
        
		int n = in.nextInt();
		int l = in.nextInt();
		long s = in.nextLong();
		int r=in.nextInt();
		long w = 0;
		
		for(int i=1;i<=n;i++){
		    w = in.nextLong();
		    luckup.put(i,new Node(i,w));
		}
		
		HashMap<Integer, ArrayList<Integer>> hm=new HashMap<>();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
	
		for(int i=0;i<n;i++)
		arr.add(new ArrayList<Integer>());
		
		for(int i=2;i<=n;i++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			
			arr.get(a-1).add(b-1);
			arr.get(b-1).add(a-1);
			
		}
		
		par=new int [n];
		
	
		DFS(arr,r-1,n);
	
		getNode(1).parent = 0;
		int p = 0;
		for(int i=2;i<=n;i++){
		    p = par[i-1]+1;
		    getNode(i).parent = p;
		    getNode(p).nbf++;
		    
		}
		
		int paths = bfs(n,l,s);
		
		System.out.println(paths);
		
		
		}
    }
}
