## @file Shape.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief An interface for shape
#  @date 11/02/2021

from abc import ABC, abstractmethod

## @brief Shape provides an interface for all kinds of shape
class Shape(ABC):

    @abstractmethod
    ## @brief A generic method for finding the x-axis
    #  @return a float indicating the x-axis of the shape
    def cm_x(self):
        pass

    @abstractmethod
    ## @brief A generic method for finding the y-axis
    #  @return a float indicating the y-axis of the shape
    def cm_y(self):
        pass

    @abstractmethod
    ## @brief A generic method for finding the mass
    #  @return a float indicating the mass of the shape
    def mass(self):
        pass

    @abstractmethod
    ## @brief A generic method for finding the moment of inertia
    #  @return a float indicating the moment of inertia of the shape
    def m_inert(self):
        pass
