## @file BodyT.py
#  @author Emily Sanderson 400088490 sanderse
#  @brief A template module that inherits Shape to create a body
#  @date12/01/2021

from Shape import Shape
import numpy as np


## @brief An abstract data type that represents a Body
class BodyT(Shape):

    ## @brief BodyT constructor
    #  @details given a sequence of x, y and mass values, creates a BodyT
    #  @param xs seq of x-direction positions of Body center of the center of mass
    #  @param ys seq of y-direction positions of Body center of the center of mass
    #  @param ms seq of masses of Body
    #  @throws ValueError if moment or mass are not greater than 0
    def __init__(self, xs, ys, ms):
        if not (len(xs) == len(ys) and len(ys) == len(ms)):
            raise ValueError()
        for j in ms:
            if j <= 0:
                raise ValueError()
        self.__cmx = np.dot(xs, ms) / sum(ms)
        self.__cmy = np.dot(ys, ms) / sum(ms)
        self.__m = sum(ms)
        squared = self.__m * (self.__cmx ** 2 + self.__cmy ** 2)
        self.__moment = np.dot(ms, np.add(np.square(xs), np.square(ys))) - squared

    ## @brief cm_x returns the center of mass in the x direction
    #  @return value representing the x-pos of the center of mass
    def cm_x(self):
        return self.__cmx

    ## @brief cm_y rthe center of mass in the x direction
    #  @return value representing the y-pos of the center of mass
    def cm_y(self):
        return self.__cmy

    ## @brief mass returns the mass of BodyT
    #  @return value representing the mass of BodyT
    def mass(self):
        return self.__m

    ## @brief cm_x returns the moment of inertia of BodyT
    #  @return value of moment of inertia
    def m_inert(self):
        return self.__moment
