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

    def get_phi(self):
        if self.x > 0:
            return math.atan(self.y / self.x)
        elif self.x < 0:
            if self.y < 0:
                return math.atan(self.y / self.x) - math.pi
            else:
                return math.atan(self.y / self.x) + math.pi
        else:
            if self.y > 0:
                return math.pi / 2
            elif self.y < 0:
                return - math.pi / 2
            else:
                return "undefined"

            