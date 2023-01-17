

import numpy as np

a = np.matrix([[1,0,4],[2,1,1],[3,1,0],[0,2,2]])
b = np.matrix([[2,4],[1,1],[3,0]])

print(np.matmul(a,b))

"""
Output:
    [[14  4]
    [ 8  9]
    [ 7 13]
    [ 8  2]]
"""


