import sys

T = int(input())

for i in range(T):
    n = int(input())
    clothes = dict()
    for j in range(n):
        name, type = input().split()
        if type in clothes:
            clothes[type] += 1
        else:
            clothes[type] = 1
    answer = 1
    for k in clothes.values():
        answer *= (k + 1)
    
    print(answer - 1)