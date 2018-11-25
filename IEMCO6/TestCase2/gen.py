import random
f=open("input1.txt","w+")

n=10000
q=10000
f.write(str(n)+" "+str(q)+"\n")

dic={}
dic[0]='0'
dic[1]='1'
dic[2]='2'
dic[3]='3'
dic[4]='4'
dic[5]='5'
dic[6]='6'
dic[7]='7'
dic[8]='8'
dic[9]='9'
dic[10]='A'
dic[11]='B'
dic[12]='C'
dic[13]='D'
dic[14]='E'
dic[15]='F'

arr=[]
for i in range (n):

	st=""
	
	if(i>=5):
		var1=random.randint(0,i-1)
		var2=random.randint(1,100)
		st=arr[var1][0:var2]
	
	for j in range(len(st),100):
		a=random.randint(0,15)
		st=st+dic[a]
	arr.append(st);
	f.write(str(st)+"\n")
	
for i in range (q):
	a=random.randint(0,10)
	if(a==0):
		st=""
		len1=random.randint(1,100)
		for j in range(len1):
			a=random.randint(0,15)
			st=st+dic[a]
		arr.append(st);
		f.write(str(st)+"\n")
	else:
		b=random.randint(0,n/2)
		len1=random.randint(1,100)
		f.write(arr[b][0:len1]+"\n")
		

f.close()
