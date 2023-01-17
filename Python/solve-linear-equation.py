import numpy as np

# Coefficient matrix
a = np.array([[3, 2, -1], [2, -1, 2], [1, 1, -3]])

# Constant terms
b = np.array([1, -3, 4])

# Solving the equations
x, y, z = np.linalg.solve(a, b)

print(x,y,z)

"""
3x + 2y - z = 1
2x - y + 2z = -3
x + y - 3z = 4


Output:
    2.0 -1.0 3.0
"""