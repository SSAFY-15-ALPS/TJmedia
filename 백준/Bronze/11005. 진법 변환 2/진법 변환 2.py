number, zin = map(int, input().split())

answer = ''

while number > 0:

    tmp = number % zin
    if tmp < 10:
        tmp = str(tmp)
        tmp = tmp + answer
    else:
        tmp = ord('A') + (tmp-10)
        tmp = chr(tmp) + answer

    answer = tmp
    tmp = ''

    number = number // zin

print(answer)