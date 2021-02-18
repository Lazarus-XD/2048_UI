## @file Scene.py
#  @author Emily Sanderson
#  @brief Creates the scene
#  @date 12/02/2021
#  @details Returns the scene

from scipy.integrate import odeint


## @brief An abstract data type that represents a scene
class Scene():

    ## @brief Scene constructor
    #  @details Creates a Scene Module given unbalanced force and velocity
    #  @param s xShape input
    #  @param Fx unbalanced force function in x dir
    #  @param Fy unbalanced force function in y dir
    #  @param vx initial velocity in x dir
    #  @param vy initial velocity in y dir
    def __init__(self, s, Fx, Fy, vx, vy):
        self.__s = s
        self.__Fx = Fx
        self.__Fy = Fy
        self.__vx = vx
        self.__vy = vy

    ## @brief Getter that returns the shape object
    #  @return Returns shape
    def get_shape(self):
        return self.__s

    ## @brief Getter that returns the unbalanced forces formulas
    #  @return Returns the unbalanced forces formulas
    def get_unbal_forces(self):
        return self.__Fx, self.__Fy

    ## @brief Getter that returns the initial velocities
    #  @return Returns the initial velocities
    def get_init_velo(self):
        return self.__vx, self.__vy

    ## @brief Setter that sets new shape to current shape
    #  @param sprime Another Shape
    def set_shape(self, sprime):
        self.__s = sprime

    ## @brief Setter that sets new unbalanced forces equations
    #  @param Fxprime New Fx Formula
    #  @param Fyprime New Fy Formula
    def set_unbal_forces(self, Fxprime, Fyprime):
        self.__Fx = Fxprime
        self.__Fy = Fyprime

    ## @brief Setter that sets new initial velocities
    #  @param Fxprime New x velocity
    #  @param Fyprime New y velocity
    def set_init_velo(self, vxprime, vyprime):
        self.__vx = vxprime
        self.__vy = vyprime

    ## @brief Calculates the values of t and runs odeint formula
    #  @param t_final length of simulation
    #  @param nsteps Number of steps taken in
    def sim(self, t_final, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * t_final) / (nsteps - 1))

        def ode(w, tau):
            third = self.__Fx(tau) / self.get_shape().mass()
            fourth = self.__Fy(tau) / self.get_shape().mass()
            return [w[2], w[3], third, fourth]
        init_cond = [self.__s.cm_x(), self.__s.cm_y(), self.__vx, self.__vy]
        return t, odeint(ode, init_cond, t)
