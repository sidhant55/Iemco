import random
f=open("input4.txt","w+")

t=5
f.write(str(t)+"\n")
for i in range (t):
	n=random.randint(95000,100000)
	q=random.randint(95000,100000)
	f.write(str(n)+" "+str(q)+"\n")
	arr=[]
	brr1=[]
	brr2=[]
	for j in range(n):
		arr.append(random.randint(0,10000))
		f.write(str(arr[j])+" ")
	f.write("\n")

	for j in range(q//2):
		a=1
		b=random.randint(1,n)
		c=(random.randint(0,10000-arr[b-1]))
		brr1.append([a,b,c])

	for j in range(q//2+q%2):
		a=2
		b=random.randint(1,n)
		c=random.randint(50000000,250000000)
		d=n//2
		e=n-d-2
		brr2.append([a,b,c,d,e])

	for j in range (q//2):
		f.write(str(brr1[j][0])+" "+str(brr1[j][1])+" "+str(brr1[j][2])+"\n")
		f.write(str(brr2[j][0])+" "+str(brr2[j][1])+" "+str(brr2[j][2])+" "+str(brr2[j][3])+" "+str(brr2[j][4])+"\n")
	
	if (q%2!=0):
		f.write(str(brr2[j][0])+" "+str(brr2[j][1])+" "+str(brr2[j][2])+" "+str(brr2[j][3])+" "+str(brr2[j][4])+"\n")

f.close()