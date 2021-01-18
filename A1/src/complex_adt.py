## @file complex_adt.py
#  @author Rizwan Ahsan
#  @brief
#  @date 

import math

class ComplexT():
    def __init__(self, x, y):
        if (isinstance(x, int) or isinstance(x, float)) and (isinstance(y, int) or isinstance(y, float)):
            self.__x = float(x)
            self.__y = float(y)
        else:
            raise Exception("x and y must be float")

    def real(self):
        return self.__x

    def imag(self):
        return self.__y

    def get_r(self):
        return math.sqrt(self.__x ** 2 + self.__y ** 2)

    def get_phi(self):
        if self.__x > 0:
            return math.atan(self.__y / self.__x)
        elif self.__x < 0:
            if self.__y < 0:
                return math.atan(self.__y / self.__x) - math.pi
            else:
                return math.atan(self.__y / self.__x) + math.pi
        else:
            if self.__y > 0:
                return math.pi / 2
            elif self.__y < 0:
                return - math.pi / 2
            else:
                raise Exception("undefined answer")

    def equal(self, complex_num):
        return self.real() == complex_num.real() and self.imag() == complex_num.imag()

    def conj(self):
        return ComplexT(self.__x, - self.__y)

    def add(self, complex_num):
        return ComplexT(self.__x + complex_num.real(), self.__y + complex_num.imag())

    def sub(self, complex_num):
        return ComplexT(self.__x - complex_num.real(), self.__y - complex_num.imag())

    def mult(self, complex_num):
        x = self.__x * complex_num.real() - self.__y * complex_num.imag()
        y = self.__x * complex_num.imag() - self.__y * complex_num.real()
        return ComplexT(x, y)

    def recip(self):
        denom = self.__x ** 2 + self.__y ** 2 #denom cannot be zero
        if denom == 0:
            raise Exception("The denominator should be non-zero i.e. x^2 + y^2 must be greater than 0")
        return ComplexT(self.__x / denom, - self.__y / denom)

    def div(self, complex_num):
        denom = complex_num.real() ** 2 + complex_num.imag() ** 2 #denom cannot be zero
        if denom == 0:
            raise Exception("The argument must be a non-zero complex number")
        x = self.__x * complex_num.real() + self.__y * complex_num.imag()
        y = self.__y * complex_num.real() - self.__x * complex_num.imag()
        return ComplexT(x / denom, y / denom)

    def sqrt(self):
        r = self.get_r()
        theta = self.get_phi()
        x = math.sqrt(r) * math.cos(theta / 2)
        y = math.sqrt(r) * math.sin(theta / 2)
        return ComplexT(x, y)
    