## @file TriangleT.py
#  @author Emily Sanderson 400088490 sanderse
#  @brief A template module that inherits Shape to create a triangle
#  @date12/01/2021

from Shape import Shape


## @brief An abstract data type that represents a Triangle
class TriangleT(Shape):

    ## @brief TriangleT constructor
    #  @details given the position, side length and mass, creates a Triangle
    #  @param xs x-direction position of triangle center of mass
    #  @param ys y-direction position of triangle center of mass
    #  @param ss side length (equilateral triangle)
    #  @param ms mass of Triangle
    #  @throws ValueError if side length or mass are not greater than 0
    def __init__(self, xs, ys, ss, ms):
        if not (ss > 0 and ms > 0):
            raise ValueError()
        self.__x = xs
        self.__y = ys
        self.__s = ss
        self.__m = ms

    ## @brief cm_x returns the x position of the center of mass
    #  @return value representing the x-pos of the center of mass
    def cm_x(self):
        return self.__x

    ## @brief cm_y returns the y position of the center of mass
    #  @return value representing the y-pos of the center of mass
    def cm_y(self):
        return self.__y

    ## @brief mass returns the mass of TriangleT
    #  @return value representing the mass of TriangleT
    def mass(self):
        return self.__m

    ## @brief cm_x returns the moment of inertia of TriangleT
    #  @return value of moment of inertia
    def m_inert(self):
        return (self.__m * (self.__s ** 2)) / 12
