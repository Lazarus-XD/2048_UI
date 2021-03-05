## @file SetOfInt.py
#  @author Rizwan Ahsan
#  @brief Set of integers
#  @date 03/04/2021


class SetOfInt():

    def __init__(self, x):
        self.s = set()
        for i in x:
            self.s.add(i)

    def is_member(self, x):
        return x in self.s

    def to_seq(self):
        lst = []
        for i in self.s:
            lst.append(i)
        return lst

    def union(self, t):
        lst1 = self.to_seq()
        lst2 = t.to_seq()
        lst = lst1 + lst2
        return SetOfInt(lst)

    def diff(self, t):
        lst1 = self.to_seq()
        lst2 = t.to_seq()
        for i in lst2:
            if i in lst1:
                lst1.remove(i)
        return SetOfInt(lst1)

    def size(self):
        return len(self.s)

    def empty(self):
        return len(self.s) == 0

    def equals(self, t):
        lst1 = t.to_seq()
        lst2 = self.to_seq()
        #sorts the lists in ascending order
        lst2.sort()
        lst1.sort()
        #iterates over the lists to check if all items are equal
        for i in range(len(lst1)):
            if lst1[i] != lst2[i]:
                return False
        return True
