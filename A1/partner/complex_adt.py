## @file complex_adt.py
#  @author Emily Sanderson
#  @brief Provides the ComplexT ADT class for representing complex numbers
#  @date Jan 18/2021

from math import sqrt
import numpy as np


## @brief An ADT that represents a complex number
class ComplexT:

    ## @brief ComplexT constructor
    #  @details Initializes a ComplexT obkect with a real & imaginary part
    #  @param x x is the real part of the complex number
    #  @param y y is the imaginary part of the complex number
    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    ## @brief Compare two ComplexT Objects
    #  @param other Other ComplexT Object to be compared to
    #  @return Returns True if objs have the same real & imag parts, False o/w
    def __eq__(self, other):
        if (other.__x == self.__x and other.__y == self.__y): 
            return True
        return False

    ## @brief Gets the real value of the complex number
    #  @return the real value of the complex number
    def real(self):
        return self.__x

    ## @brief Gets the imaginary value of the complex number
    #  @return the imaginary value of the complex number
    def imag(self):
        return self.__y

    ## @brief Calculates the abs value of complex number
    #  @return  The absolute value of the complex number
    def get_r(self):
        return sqrt(self.__x ** 2 + self.__y ** 2)

    ## @brief Calculates the argument of the complex number
    #  @return The argument of the complex number
    def get_phi(self):
        return np.arctan2(self.__y, self.__x)

    ## @brief Determines if the argument and current object are equal
    #  @param obj obj is a ComplexT object used for comparison
    #  @return Returns true if arg and current obj are equal
    def equal(self, obj):
        return self.__eq__(obj)

    ## @brief Calculates the complex conjugate
    #  @return Returns a ComplexT object with new params
    def conj(self):
        return ComplexT(self.__x, (-1) * self.__y)

    ## @brief Calculates the addition of two ComplexT objects
    #  @param obj ComplexT object being added to self
    #  @return Returns a ComplexT object that is the addition of obj and self
    def add(self, obj):
        return ComplexT(self.__x + obj.__x, self.__y + obj.__y)

    ## @brief Calculates the subtraction of the ComplexT argument from obj
    #  @param obj ComplexT object being subtracted from self
    #  @return ComplexT object that is the subtraction of obj minus the arg
    def sub(self, obj):
        return ComplexT(self.__x - obj.__x, self.__y - obj.__y)

    ## @brief Calculates the multiplication of two ComplexT objects
    #  @param obj ComplexT object that is to be multipled by self
    #  @return ComplexT object that is the mult of current obj and param
    def mult(self, obj):
        return ComplexT(self.__x * obj.__x - self.__y * obj.__y, 
                        self.__x * obj.__y + self.__y * obj.__x)

    ## @brief Calculates the reciprocal of ComplexT object
    #  @throws ValueError if Complex Number is 0
    #  @return Returns the Reciprocal of the complex number
    def recip(self):
        if (self.__x == 0 and self.__y == 0):
            raise ValueError("Cannot divide by 0")
        return ComplexT(self.__x / (self.__x ** 2 + self.__y ** 2),
                        -self.__y / (self.__x ** 2 + self.__y ** 2))

    ## @brief Calculates the division of two ComplexT objects
    #  @param obj ComplexT object that divides self
    #  @throws ValueError if denominator Complex Number is 0
    #  @return ComplexT object that is the results of the div of current obj and param
    def div(self, obj):
        if (obj.__x == 0 and obj.__y == 0):
            raise ValueError("Cannot divide by 0")
        return self.mult(obj.recip())

    ## @brief Calculates the positive square root of the current object
    #  @return Returns the positive square root of the complex number
    def sqrt(self):
        if (self.__y == 0):
            return ComplexT(sqrt(self.__x), 0)
        else:
            return ComplexT(sqrt((self.get_r() + self.__x) / 2),
                            (self.__y / abs(self.__y)) * 
                            sqrt((self.get_r() - self.__x) / 2))
