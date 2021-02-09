## @file TriangleT.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief Contains a class for working with traingles
#  @date 11/02/2021

from Shape import Shape


## @brief An ADT class for representing triangles
class TriangleT(Shape):

    ## @brief Constructor for the class TriangleT
    #  @param x x-axis of the triangle
    #  @param y y-axis of the triangle
    #  @param r radius of the triangle
    #  @param m mass of the triangle
    #  @throws ValueError throws if s and m value is not greater than 0
    def __init__(self, x, y, s, m):
        if s <= 0 or m <= 0:
            raise ValueError
        self.__x = x
        self.__y = y
        self.__s = s
        self.__m = m

    ## @brief Gets the x-axis of the triangle
    #  @return Float representing the x-axis
    def cm_x(self):
        return self.__x

    ## @brief Gets the y-axis of the triangle
    #  @return Float representing the y-axis
    def cm_y(self):
        return self.__y

    ## @brief Gets the mass of the triangle
    #  @return Float representing the mass
    def mass(self):
        return self.__m

    ## @brief Gets the moment of inertia of the triangle
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return (self.__m * self.__s ** 2) / 12
