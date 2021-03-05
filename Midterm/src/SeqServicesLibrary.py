## @file SeqServicesLibrary.py
#  @author Rizwan Ahsan
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021


def max_val(s):
    if len(s) == 0:
        raise ValueError
    return max(s)


def count(t, s: list):
    if len(s) == 0:
        raise ValueError
    return sum([1 for i in s if i == t])


def spices(s):
    if len(s) == 0:
        raise ValueError
    return ["nutmeg" if i <= 0 else "ginger" for i in s]


def new_max_val(s, f):
    if len(s) == 0:
        raise ValueError
    lst = []
    for i in s:
        if f:
            lst.append(i)
    return max_val(lst)