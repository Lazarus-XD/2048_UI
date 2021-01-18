## @file triangle_adt.py
#  @author Rizwan Ahsan
#  @brief 
#  @date

import math

class TriangleT():
    def __init__(self, x, y, z):
        if isinstance(x, int) and isinstance(y, int) and isinstance(z, int):
            self.__x = x
            self.__y = y
            self.__z = z
        elif x <= 0 or y <= 0 or z <= 0:
            raise Exception("Length of each sides must be greater than 0")
        else:
            raise Exception("All arguments must be of type integer")

    def get_sides(self):
        return (self.__x, self.__y, self.__z)

    def equal(self, triangle):
        sides1 = self.get_sides()
        sides2 = triangle.get_sides()
        return sides1[0] == sides2[0] and sides1[1] == sides2[1] and sides1[2] == sides2[2]

    def perim(self):
        return self.__z + self.__y + self.__x

    def area(self):
        half = self.perim() / 2
        return math.sqrt(half * (half - self.__x) * (half - self.__y) * (half - self.__z))

    def is_valid(self):
        cond1 = self.__x + self.__y <= self.__z
        cond2 = self.__z + self.__y <= self.__x
        cond3 = self.__x + self.__z <= self.__y
        if cond1 or cond2 or cond3:
            return False
        else:
            return True
