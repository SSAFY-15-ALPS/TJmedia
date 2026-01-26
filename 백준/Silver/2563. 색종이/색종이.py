answer = [[False] * 100 for _ in range(100)]
number = int(input())
for num in range(number):
  a, b = map(int,input().split())
  for i in range(a, a+10, 1):
    for j in range(b, b+10, 1):
      answer[i][j] = True

cnt = 0  
for row in answer:
  for x in row:
    if x == True:
      cnt += 1

print(cnt)