import matplotlib.pyplot as plt
import numpy as np
time = [511132.0, 257106.0, 150877.0, 74925.0, 108282.0, 75951.0, 74411.0, 101611.0, 66714.0, 109308.0, 85702.0, 1170061.0, 653285.0, 658416.0, 712301.0, 1088978.0, 644560.0, 669193.0, 656877.0, 665087.0,
        1924956.0, 1343005.0, 766698.0, 657903.0, 639942.0, 724104.0, 881138.0, 671759.0, 754895.0, 671246.0, 618388.0, 2442246.0, 1363532.0, 647639.0, 651745.0, 755921.0, 656363.0, 1950615.0, 1378414.0, 650718.0]
print(*time)
list1 = range(1, 41)
print(*list1)

plt.plot(list1, time)
plt.xlabel('number')
plt.ylabel('time taken (nanoseconds)')
plt.title('Fibbonacci Java implentation using Iterations')
plt.grid(True)
plt.show()
