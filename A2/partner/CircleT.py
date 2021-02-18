## @file CircleT.py
#  @author Emily Sanderson 400088490 sanderse
#  @brief A template module that inherits Shape to create a circle
#  @date12/01/2021

from Shape import Shape


## @brief An abstract data type that represents a Circle
class CircleT(Shape):

    ## @brief CircleT constructor
    #  @details given the position, radius and mass, creates a Circle
    #  @param xs x-direction position of circle center of mass
    #  @param ys y-direction position of circle center of mass
    #  @param rs radius of circle
    #  @param ms mass of circle
    #  @throws ValueError if radius or mass are not greater than 0
    def __init__(self, xs, ys, rs, ms):
        if not (rs > 0 and ms > 0):
            raise ValueError()
        self.__x = xs
        self.__y = ys
        self.__r = rs
        self.__m = ms

    ## @brief cm_x returns the x position of the center of mass
    #  @return value representing the x-pos of the center of mass
    def cm_x(self):
        return self.__x

    ## @brief cm_y returns the y position of the center of mass
    #  @return value representing the y-pos of the center of mass
    def cm_y(self):
        return self.__y

    ## @brief mass returns the mass of CircleT
    #  @return value representing the mass of CircleT
    def mass(self):
        return self.__m

    ## @brief cm_x returns the moment of inertia of CircleT
    #  @return value of moment of inertia
    def m_inert(self):
        return (self.__m * (self.__r ** 2)) / 2
