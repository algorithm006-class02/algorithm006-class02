#!/usr/bin/python3

def remove(m, total = 100):
	if m <= 1 or m >=100:
		print("ERROR")
		return []

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
	return [idx + 1 for idx, a in enumerate(circle) if a == 0]
