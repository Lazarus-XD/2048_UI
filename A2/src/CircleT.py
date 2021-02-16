## @file CircleT.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief Contains a ADT for circle
#  @date 16/02/2021

from Shape import Shape


## @brief CircleT is an abstract class for circle.
#  @details A circle is composed of x, y axis, radius and mass
class CircleT(Shape):

    ## @brief Constructor for the class CircleT. Assumes the arguments
    #         provided will be of correct type
    #  @param x x-axis of the circle
    #  @param y y-axis of the circle
    #  @param r radius of the circle
    #  @param m mass of the circle
    #  @throws ValueError throws if r and m value is not greater than 0
    def __init__(self, x, y, r, m):
        if r <= 0 or m <= 0:
            raise ValueError
        self.__x = x
        self.__y = y
        self.__r = r
        self.__m = m

    ## @brief Gets the x-axis of center of mass of circle
    #  @return Float representing the x-axis
    def cm_x(self):
        return self.__x

    ## @brief Gets the y-axis of center of mass of the circle
    #  @return Float representing the y-axis
    def cm_y(self):
        return self.__y

    ## @brief Gets the mass of the circle
    #  @return Float representing the mass
    def mass(self):
        return self.__m

    ## @brief Gets the moment of inertia of the circle
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return (self.__m * self.__r ** 2) / 2
