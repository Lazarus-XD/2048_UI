## @file complex_adt.py
#  @author Rizwan Ahsan
#  @brief Contains a class for working with complex numbers
#  @date 01/20/2021

import math

## @brief An ADT class for representing complex numbers
#  @details A complex number is composed of a real part and an imaginary part
class ComplexT():

    ## @brief Contructor for ComplexT class
    #  @details Creates a complex number based on the provided arguments.
    #  Assumed the arguments provided are going to be of type float
    #  @param x Float representing the real part of the complex number
    #  @param y Float representing the imaginary part of the complex number
    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    ## @brief Gets the real part of the complex number
    #  @return Float representing the real part
    def real(self):
        return self.__x

    ## @brief Gets the imaginary part of the complex number
    #  @return Float representing the imaginary part
    def imag(self):
        return self.__y

    ## @brief Gets the modulus of the complex number
    #  @return Float representing the modulus
    def get_r(self):
        return math.sqrt(self.__x ** 2 + self.__y ** 2)

    ## @brief Gets the argument of the complex number
    #  @return Float representing the argument
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
                return 0.0

    ## @brief Checks if the provided complex number is equal to this complex number
    #  @param complex_num ComplexT to check if it is equal to this one
    #  @return True if they are equal else False
    def equal(self, complex_num):
        return self.real() == complex_num.real() and self.imag() == complex_num.imag()

    ## @brief Checks if the provided complex number is equal to this complex number
    #  @param other ComplexT to check if it is equal to this one
    #  @return True if they are equal else False
    def __eq__(self, other):
        return self.equal(other)

    ## @brief Gets the complex conjugate of the complex number
    #  @return ComplexT representing the complex conjugate
    def conj(self):
        return ComplexT(self.__x, - self.__y)

    ## @brief Adds the given complex number to this number
    #  @param complex_num ComplexT number to add to this number
    #  @return ComplexT which results from adding both the numbers
    def add(self, complex_num):
        return ComplexT(self.__x + complex_num.real(), self.__y + complex_num.imag())

    ## @brief Subtracts the given complex number from this number
    #  @param complex_num ComplexT number to subtract from this number
    #  @return ComplexT which results from the subtraction
    def sub(self, complex_num):
        return ComplexT(self.__x - complex_num.real(), self.__y - complex_num.imag())

    ## @brief Multiplies the given complex number and this number
    #  @param complex_num ComplexT number to multiply to this number
    #  @return ComplexT which results from the multiplication
    def mult(self, complex_num):
        x = self.__x * complex_num.real() - self.__y * complex_num.imag()
        y = self.__x * complex_num.imag() + self.__y * complex_num.real()
        return ComplexT(x, y)

    ## @brief Gets the reciprocal of the complex number
    #  @return ComplexT which is the reciprocal of this complex number
    #  @throws Exception throws if the denom variable is less than or equal to 0
    def recip(self):
        denom = self.__x ** 2 + self.__y ** 2
        if denom <= 0:
            raise Exception("The denominator should be non-zero i.e. x^2 + y^2 must be greater than 0")
        return ComplexT(self.__x / denom, - self.__y / denom)

    ## @brief Divides this number by the provided complex number
    #  @param complex_num ComplexT number which is used to divide this number
    #  @return ComplexT which results from the division of the numbers
    #  @throws Exception throws if the denom variable is less than or equal to 0
    def div(self, complex_num):
        denom = complex_num.real() ** 2 + complex_num.imag() ** 2
        if denom <= 0:
            raise Exception("The argument must be a non-zero complex number")
        x = self.__x * complex_num.real() + self.__y * complex_num.imag()
        y = self.__y * complex_num.real() - self.__x * complex_num.imag()
        return ComplexT(x / denom, y / denom)

    ## @brief Gets the positive square root of the complex number
    #  @return ComplexT which is the positive square root of the complex number
    def sqrt(self):
        r = self.get_r()
        theta = self.get_phi()
        x = math.sqrt(r) * math.cos(theta / 2)
        y = math.sqrt(r) * math.sin(theta / 2)
        return ComplexT(x, y)