## @file BodyT.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief Contains a ADT for working with bodies of any shape
#  @date 16/02/2021

from Shape import Shape


## @brief An ADT for representing bodies of various shape
#  @details Any object can be a body if it has center of mass, mass and
#           moment of inertia
class BodyT(Shape):

    ## @brief Contructor for the class BodyT. Assumes the provided arguments
    #         will be of correct type
    #  @param x List of all points in body along x-axis
    #  @param y List of all points in body along y-axis
    #  @param m List of all mass contained in the body at certain points
    #  @throws ValueError throws error if the length of x, y and m are not equal
    #          or any of the mass in m is less than 0
    def __init__(self, x, y, m):
        self.__cmx = self.__cm__(x, m)
        self.__cmy = self.__cm__(y, m)
        self.__m = sum(m)
        value = (self.__cm__(x, m) ** 2 + self.__cm__(y, m) ** 2)
        self.__moment = self.__mmom__(x, y, m) - sum(m) * value
        eq_len = len(x) == len(y) == len(m)
        mass_error = False
        for i in m:
            if i <= 0:
                mass_error = True

        if not eq_len or mass_error:
            raise ValueError

    @staticmethod
    def __cm__(z, m):
        return sum([z * i for i in m]) / sum(m)

    @staticmethod
    def __mmom__(x, y, m):
        s = 0
        for i in range(len(m)):
            s += m[i] * (x[i] ** 2 + y[i] ** 2)
        return s

    ## @brief Gets the x-axis of the center of mass of body
    #  @return Float representing the x-axis
    def cm_x(self):
        return self.__cmx

    ## @brief Gets the y-axis of the center of mass of body
    #  @return Float representing the y-axis
    def cm_y(self):
        return self.__cmy

    ## @brief Gets the  mass of the  body
    #  @return Float representing the mass
    def mass(self):
        return self.__m

    ## @brief Gets the moment of inertia of body
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return self.__moment
