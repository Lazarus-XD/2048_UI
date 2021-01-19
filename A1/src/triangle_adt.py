## @file triangle_adt.py
#  @author Rizwan Ahsan
#  @brief Contains a class for working with triangles
#  @date 01/19/2021

import math
from enum import Enum, auto

## @brief An ADT class for representing triangles
#  @details A triangle is composed of three sides
class TriangleT():

    ## @brief Contructor for TriangleT class
    #  @details Creates a triangle based on the provided arguments
    #  @param x Integer representing a side of the triangle
    #  @param y Integer representing a side of the triangle
    #  @param z Integer representing a side of the triangle
    #  @throws Exception Throws if all arguments are not integer or if any of the sides
    #  are less than or equal to zero
    def __init__(self, x, y, z):
        if isinstance(x, int) and isinstance(y, int) and isinstance(z, int):
            if x <= 0 or y <= 0 or z <= 0:
                raise Exception("Length of each sides must be greater than 0")
            self.__x = x
            self.__y = y
            self.__z = z
        else:
            raise Exception("All arguments must be of type integer")

    ## @brief Gets the values of all the sides of the triangle
    #  @return Tuple containing all the sides
    def get_sides(self):
        return (self.__x, self.__y, self.__z)

    ## @brief Checks if the provided triangle is equal to this triangle
    #  @param triangle The triangle which is used to compare the equality
    #  @return True is both the triangles are equal, false otherwise
    def equal(self, triangle):
        sides1 = self.get_sides()
        sides2 = triangle.get_sides()
        return sides1[0] == sides2[0] and sides1[1] == sides2[1] and sides1[2] == sides2[2]

    ## @brief Gets the perimeter of the triangle
    #  @return Integer which represents the perimeter of the triangle
    def perim(self):
        return self.__z + self.__y + self.__x

    ## @brief Gets the area of the traingle
    #  @return Float representing the area of the triangle
    def area(self):
        half = self.perim() / 2
        return math.sqrt(half * (half - self.__x) * (half - self.__y) * (half - self.__z))

    ## @brief Checks if the provided sides creates a valid triangle or not
    #  @return True if the triangle is valid, false otherwise
    def is_valid(self):
        cond1 = self.__x + self.__y <= self.__z
        cond2 = self.__z + self.__y <= self.__x
        cond3 = self.__x + self.__z <= self.__y
        if cond1 or cond2 or cond3:
            return False
        else:
            return True

    ## @brief Gets a TriType by checking with the provided sides
    #  @return TriType for the provided sides
    def tri_type(self):
        if self.__y == self.__x == self.__z:
            return TriType.equilat

        if self.__x == self.__y or self.__y == self.__z or self.__z == self.__x:
            return TriType.isosceles

        a, b, c = self.__x ** 2, self.__y ** 2, self.__z ** 2
        if max(a, b, c) == (a + b + c - max(a, b, c)):
            return TriType.right

        if self.__y != self.__x != self.__z:
            return TriType.scalene

## @brief TriType class is an enumeration of the different types of triangle
class TriType(Enum):

    ## enum value equilat
    equilat = auto()

    ## enum value isosceles
    isosceles = auto()

    ## enum value scalene
    scalene = auto()

    ## enum value right
    right = auto()