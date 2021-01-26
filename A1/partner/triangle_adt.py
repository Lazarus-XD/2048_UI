## @file triangle_adt.py
#  @author Emily Sanderson
#  @brief Provides the TriangleT ADT class for representing a Triangle
#  @date Jan 18/2021

from math import sqrt
from enum import Enum
from itertools import permutations


## @brief An ADT that represents a triangle
class TriangleT:

    ## @brief TriangleT constructor
    #  @details Initializes a TriangleT object 
    #  @throws ValueError if triangle has negative side lengths
    #  @param a Length of first side of Triangle
    #  @param b Length of second side of Triangle
    #  @param c Length of third side of Triangle
    def __init__(self, a, b, c):
        if (a < 0 or b < 0 or c < 0):
            raise ValueError("Triangle cannot have negative side lengths")
        self.__a = a
        self.__b = b
        self.__c = c

    ## @brief Gets the sides of a triangle 
    #  @return Returns a tuple of three integers
    def get_sides(self):
        return (self.__a, self.__b, self.__c)

    ## @brief Sorts sides of triangle
    #  @return Returns an array of sorted sides lengths
    def __sort_sides__(self):
        return sorted(self.get_sides())

    ## @brief Tests whether two triangles are equivalent
    #  @param obj Other triangle used in comparison
    #  @return Returns True if two triangleT objects are the same
    def equal(self, obj):
        self_sides = self.__sort_sides__()
        obj_sides = obj.__sort_sides__()
        if (self_sides == obj_sides):
            return True
        return False

    ## @brief Calculates the perimeter of Triangle
    #  @throws ValueError if triangle is invalid
    #  @return Returns the perimeter as an int of Triangle
    def perim(self):
        if not self.is_valid():
            raise Exception("Invalid Triangle")
        return self.__a + self.__b + self.__c

    ## @brief Calculates the area of a triangle
    #  @throws ValueError if triangle is invalid
    #  @return Returns the area of a triangle, as a float
    def area(self):
        if not self.is_valid():
            raise Exception("Invalid Triangle")
        p = self.perim() / 2
        return sqrt(p * (p - self.__a) * (p - self.__b) * (p - self.__c))

    ## @brief Determines is the triangleT object represents a valid Triangle
    #  @details The sum of two sides must be greater than the third side to be valid
    #  @return Returns True is triangleT rep a valid triangle, False o/w
    def is_valid(self):
        if (self.__a + self.__b > self.__c and
                self.__a + self.__c > self.__b and 
                self.__c + self.__b > self.__a):
            return True
        return False

    ## @brief Creates an object of the Class TriType
    #  @throws ValueError if triangle is invalid
    #  @return Returns a TriType object
    def tri_type(self):
        if not self.is_valid():
            raise Exception("Invalid Triangle")
        sorted_sides = self.__sort_sides__()
        for perm in permutations(self.get_sides()):
            if (perm[0]**2 + perm[1]**2 == perm[2]**2):
                return TriType.right
        if (sorted_sides[0] == sorted_sides[2]):
            return TriType.equilat
        elif ((sorted_sides[0] == sorted_sides[1]) or 
              (sorted_sides[1] == sorted_sides[2])):
            return TriType.isosceles
        else:
            return TriType.scalene


## @brief An Enum that represents the types of Triangles
#  @details Elements of TriType correspond to the triangle types
class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4
