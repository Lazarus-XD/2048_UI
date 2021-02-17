## @file Scene.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief Contains an ADT for working with different types of scenes
#  @date 16/02/2021
#  @details Demonstrates the movement of a shape with time

from scipy.integrate import odeint


## @brief An ADT for representing a scene
class Scene():

    ## @brief Constructor for the Scene class
    #  @param s A Shape object
    #  @param fx unbalanced force function in x direction
    #  @param fy unbalanced force function in y direction
    #  @param vx initial velocity in x direction
    #  @param vy initial velocity in y direction
    def __init__(self, s, fx, fy, vx, vy):
        self.__s = s
        self.__fx = fx
        self.__fy = fy
        self.__vx = vx
        self.__vy = vy

    ## @brief Gets the shape object that was passed in the constructor
    #  @return A shape object
    def get_shape(self):
        return self.__s

    ## @brief Gets the unbalanced forces in x, y directions
    #  @return A tuple of unbalanced forces
    def get_unbal_forces(self):
        return self.__fx, self.__fy

    ## @brief Gets the initial velocities in x, y directions
    #  @return A tuple of velocities
    def get_init_velo(self):
        return self.__vx, self.__vy

    ## @brief Changes the set variable which contains shape object
    #         to the new object
    def set_shape(self, s):
        self.__s = s

    ## @brief Changes the unbalanced forces in both x, y directions
    def set_unbal_forces(self, fx, fy):
        self.__fx = fx
        self.__fy = fy

    ## @brief Changes the initial velocities in both x, y directions
    def set_init_velo(self, vx, vy):
        self.__vx = vx
        self.__vy = vy

    ## @brief Simulates the movement of the shape with time
    #  @return tuple of list
    def sim(self, tf, nsteps):
        t = sorted([(i * tf) / (nsteps - 1) for i in range(nsteps)])

        def ode(w, tau):
            third = self.__fx(tau) / self.__s.mass()
            fourth = self.__fy(tau) / self.__s.mass()
            return [w[2], w[3], third, fourth]

        odeint_val = odeint(ode, [self.__s.cm_x(), self.__s.cm_y(), self.__vx, self.__vy], t)
        return t, odeint_val
