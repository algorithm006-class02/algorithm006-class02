#!/usr/bin/python3

def remove(m, total = 100):
	if m <= 1 or m >=100:
		print("ERROR")
		return []
	
	ans = []
	circle = [0 for i in range(total)]
	count = total
	i = - 1
	j = 0
	while count >= m:
		i = (i + 1) % total
		while circle[i] != 0:
			i = (i + 1) % total
		j += 1
		if j % m == 0:
			circle[i] = 1
			count -= 1	
	for i in range(total):
		if circle[i] == 0:
			ans.append(i + 1)	
	return ans
