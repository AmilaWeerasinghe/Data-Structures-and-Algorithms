
#!/usr/bin/python
import timeit
import datetime as dt
import matplotlib.pyplot as plt
import numpy as np


def fib_r(x):
    if (x <= 2):
        return 1
    return fib_r(x-1) + fib_r(x-2)


def fib_i(x):
    a = 1
    b = 1
    fib = 1
    i = 2
    while i < x:
        fib = a + b
        a = b
        b = fib
        i += 1

    return fib


"""
# measure time for recursion
a = []
time = []
for x in range(1, 41):
    start_r = dt.datetime.now()
    print("Fib of " + str(x) + " = " + str(fib_r(x)))
    end_r = dt.datetime.now()
    elapsed_r = (end_r - start_r).microseconds
    elapsed_r = elapsed_r*1000
    time.append(elapsed_r)
    print("Python recursion, number =" + str(x) + " time = "+str(elapsed_r))



print(*time)
list1 = range(1, 41)
print(*list1)

plt.plot(list1, time)
plt.xlabel('number')
plt.ylabel('time taken (nanoseconds)')
plt.title('Fibbonacci Python implentation using recursion')
plt.grid(True)
plt.show()
"""
a = []
time = []
# measure time for iteration
for x in range(1, 41):
    start_i = dt.datetime.now()
    print("Fib of " + str(x) + " = " + str(fib_i(x)))
    end_i = dt.datetime.now()
    elapsed_i = (end_i - start_i).microseconds
    elapsed_i = elapsed_i*1000
    time.append(elapsed_i)
    print("Python iterations, number =" + str(x) + " time = "+str(elapsed_i))

print(*time)
list1 = range(1, 41)
print(*list1)

plt.plot(list1, time)
plt.xlabel('number')
plt.ylabel('time taken (nanoseconds)')
plt.title('Fibbonacci Python implentation using iteration')
plt.grid(True)
plt.show()
