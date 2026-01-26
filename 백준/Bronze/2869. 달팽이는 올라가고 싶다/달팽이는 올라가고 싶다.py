import math

up, down, summit = map(int, input().split())

answer = 0

semi_summit = summit - up
day_up = up - down

if up == summit:
  print(1)
else:
  answer += math.ceil(semi_summit / day_up) + 1
  print(answer)