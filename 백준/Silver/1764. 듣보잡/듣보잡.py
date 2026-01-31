import sys

N, M = map(int, input().split())
listen = dict()
no_listen_no_see = []
for i in range(N):
    listen[input()] = 1
for j in range(M):
    see = input()
    if see in listen:
        no_listen_no_see.append(see)

no_listen_no_see.sort()
print(len(no_listen_no_see))

for k in no_listen_no_see:
    print(k)

