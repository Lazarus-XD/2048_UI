## @file Shape.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief An interface for shape
#  @date 11/02/2021

from abc import ABC, abstractmethod


class Shape(ABC):

    @abstractmethod
    def cm_x(self):
        pass

    @abstractmethod
    def cm_y(self):
        pass

    @abstractmethod
    def mass(self):
        pass

    @abstractmethod
    def m_inert(self):
        pass