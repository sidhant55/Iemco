
#include <string.h> 
#include <iostream> 

using namespace std;

int main(){
	int n,q;
	cin>>n>>q;
	string arr[100000];
	for(int i=0;i<n;i++){
		cin>>arr[i];
		
	}
	for(int i=0;i<q;i++)
        {
        	string x;
        	cin>>x;
        	int c=0;
        	for(int j=0;j<n;j++)
        	{
        		if(x.compare(arr[j].substr(0,x.length()))==0)
        		c++;
        	}
        	cout<<c<<endl;
        }
}
