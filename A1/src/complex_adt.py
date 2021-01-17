## @file complex_adt.py
#  @author Rizwan Ahsan
#  @brief
#  @date 

import math

class ComplexT():
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def real(self):
        return self.x

    def imag(self):
        return self.y

    def get_r(self):
        return math.sqrt(self.x**2 + self.y**2)
