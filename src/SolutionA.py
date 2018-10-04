import sys

price = sys.stdin.readline()
price = price.split()
priceInt = [(int(price[a]) * (a + 1)) for a in range(len(price))]
priceInt.insert(0, 0)
carIn = []
carOut = []

for i in sys.stdin:
    prices = i.split()
    carIn.append(int(prices[0]))
    carOut.append(int(prices[1]))
carIn.sort()
carOut.sort()

counter = 1
start = carIn.pop(0)
result = 0
while carIn:
    if carIn[0] < carOut[0]:
        result += priceInt[counter] * (carIn[0] - start)
        counter += 1
        start = carIn.pop(0)
    else:
        result += priceInt[counter] * (carOut[0] - start)
        counter -= 1
        start = carOut.pop(0)
while carOut:
    result += priceInt[counter] * (carOut[0] - start)
    counter -= 1
    start = carOut.pop(0)
print result