## @file Plot.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief A library used for plotting graphs
#  @date 16/02/2021
#  @details Displays 3 seperate graphs denoting x versus t, y versus t and
#           y versus x respectively

from matplotlib import pyplot as plt


## @brief A function to plot graphs
#  @throws ValueError throws if the length of w and t are not equal
def plot(w, t):
    if len(w) != len(t):
        raise ValueError

    x = []
    y = []

    for i in range(len(w)):
        x.append(w[i][0])
        y.append(w[i][1])

    fig, axes = plt.subplots(3)
    fig.suptitle('Motion simulation')
    axes[0].plot(t, x)
    axes[1].plot(t, y)
    axes[2].plot(x, y)

    axes[0].set(ylabel='x (m)')
    axes[1].set(ylabel='y (m)')
    axes[2].set(xlabel='x (m)', ylabel='y (m)')

    plt.show()
