import random
f=open("input0.txt","w+")

q=100

f.write(str(q)+"\n")

arr=[]
for j in range (q):


	if(j%3==0):
	
		arr=[]

		var1=random.randint(90,100)
		var2=random.randint(1,var1//8)
		su=0;
		for i in range (var1):
			arr.append(random.randint(100,1000))
			su+=arr[i];
		
		print(su)
		
	
		var3=((su//var1)*var2)//4;
		
		var4=random.randint(1,var1)
	
		f.write(str(var1)+" "+str(var2)+" "+str(var3)+" "+str(var4)+"\n")
	
		for i in range (var1):
			f.write(str(arr[i])+" ")
		
		f.write("\n")
	
	
	
		c1=1
		c2=2
		for i in range (var1-1):
			f.write(str(c1)+" "+str(c2)+"\n")
			c2+=1;
			if(i%2!=0):
				c1+=1



	elif(j%3==1):
	
		arr=[]

		var1=random.randint(10000,100000)
		var2=random.randint(1,var1//8)
		su=0;
		for i in range (var1):
			arr.append(random.randint(10000,100000))
			su+=arr[i];
		
		print(su)
		
	
		var3=((su//var1)*var2)//4;
	
		var4=random.randint(1,var1)
	
		f.write(str(var1)+" "+str(var2)+" "+str(var3)+" "+str(var4)+"\n")
	
		for i in range (var1):
			f.write(str(arr[i])+" ")
		
		f.write("\n")
	
	
	
		c1=1
		c2=2
		for i in range (var1-1):
			f.write(str(c1)+" "+str(c2)+"\n")
			c2+=1;
			if(i%2!=0):
				c1+=1
			
			
	
	else:
	
		arr=[]

		var1=random.randint(1000,10000)
		var2=random.randint(1,var1//8)
		su=0;
		for i in range (var1):
			arr.append(random.randint(1000,10000))
			su+=arr[i];
		
		print(su)
		
	
		var3=((su//var1)*var2)//4;
	
		var4=random.randint(1,var1)
	
		f.write(str(var1)+" "+str(var2)+" "+str(var3)+" "+str(var4)+"\n")
	
		for i in range (var1):
			f.write(str(arr[i])+" ")
		
		f.write("\n")
		
			
	
		n=var1		
		k = n-2
		arr =[]
		for i in range(k):
			arr.append(random.randint(1,n))

		virtex_set = [0 for i in range(n)]


		tree = []

		for i in range(k):
			virtex_set[arr[i]-1] += 1
	
		for i in range(k):
			for j in range(n):
				if virtex_set[j] == 0:
					virtex_set[j] = -1
					tree.append([j+1,arr[i]])
					virtex_set[arr[i]-1] -= 1
					break
		j=0		
		for i in range(n):
			if  virtex_set[i] ==0 and j==0:
				tree.append([i+1, None])
				j += 1
			elif virtex_set[i] == 0 and  j==1:
				tree[-1][1] = i+1
	
		for i in tree:
			f.write(str(i[0])+" "+str(i[1])+"\n")
	
	

		

f.close()
