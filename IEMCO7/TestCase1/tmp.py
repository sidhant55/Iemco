import random

n = random.randint(3,20)

k = n-2
print(n)
arr =[]
for i in range(k):
	arr.append(random.randint(1,n))
print(*arr)

virtex_set = [0 for i in range(n)]


tree = []

for i in range(k):
	virtex_set[arr[i]-1] += 1
j=0	
for i in range(k):
	for j in range(n):
		if virtex_set[j] == 0:
			virtex_set[j] = -1
			tree.append([j+1,arr[i]])
			virtex_set[arr[i]-1] -= 1
			break
treel =[]
i = 0	
j=0		
for i in range(n):
	if  virtex_set[i] ==0 and j==0:
		treel.append(i+1)
		j += 1
	elif virtex_set[i] == 0 and  j==1:
		treel.append(i+1)
tree.append(treel)		
print(tree)
