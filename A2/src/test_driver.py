## @file test_All.py
#  @author Rizwan Ahsan, ahsanm7
#  @brief Contains methods for testing all modules in the file
#  @date 16/02/2021
#  @details Tests Shape, CircleT, TriangleT, BodyT, Scene and Plot

import pytest
from CircleT import CircleT
from TriangleT import TriangleT
from BodyT import BodyT
from Scene import Scene
from Plot import plot


class TestCircleT():

    def setup_method(self, method):
        self.c = CircleT(1.0, 10.0, 0.5, 1.0)

    def teardown_method(self, method):
        self.c = None

    def test_cmx(self):
        assert self.c.cm_x() == 1.0

    def test_cmy(self):
        assert self.c.cm_y() == 10.0

    def test_mass(self):
        assert self.c.mass() == 1.0

    def test_m_inert(self):
        assert self.c.m_inert() == 1.0 * 0.5 ** 2 / 2

    def test_error(self):
        with pytest.raises(ValueError):
            CircleT(1.0, 10.0, -0.5, -2.0)


class TestTriangleT():

    def setup_method(self, method):
        self.t = TriangleT(1.0, -10.0, 5, 17.5)

    def teardown_method(self, method):
        self.t = None

    def test_cmx(self):
        assert self.t.cm_x() == 1.0

    def test_cmy(self):
        assert self.t.cm_y() == -10.0

    def test_mass(self):
        assert self.t.mass() == 17.5

    def test_m_inert(self):
        assert self.t.m_inert() == 17.5 * 5 ** 2 / 12

    def test_error(self):
        with pytest.raises(ValueError):
            TriangleT(2.0, 0.0, -1.0, 5.0)


class TestBodyT():

    def setup_method(self, method):
        self.b = BodyT([11, 9, 9, 11], [11, 11, 9, 9], [10, 10, 10, 10])

    def teardown_method(self, method):
        self.b = None

    def test_cmx(self):
        assert self.b.cm_x() == 10

    def test_cmy(self):
        assert self.b.cm_y() == 10

    def test_mass(self):
        assert self.b.mass() == 40

    def test_m_inert(self):
        assert self.b.m_inert() == 80

    def test_error1(self):
        with pytest.raises(ValueError):
            BodyT([11, 9, 9, 11], [11, 11, 9, 9], [10, 10, 10])

    def test_error2(self):
        with pytest.raises(ValueError):
            BodyT([11, 9, 9, 11], [11, 11, 9, 9], [10, 10, 10, -20])


class TestScene():

    def setup_method(self, method):
        self.t = TriangleT(1.0, -10.0, 5, 17.5)
        self.g = 9.81
        self.m = 1
        self.s = Scene(self.t, self.Fx, self.Fy, 10, 20)

    def teardown_method(self, method):
        self.t1 = None

    def Fx(self, t):
        return 5 if t < 5 else 0

    def Fy(self, t):
        return -self.g * self.m if t < 3 else self.g * self.m

    def test_get_shape(self):
        assert self.s.get_shape() == self.t

    def test_get_init_val(self):
        assert self.s.get_init_velo() == (10, 20)

    def test_set_init_val(self):
        self.s.set_init_velo(0, 0)
        assert self.s.get_init_velo() == (0, 0)

    def test_set_shape(self):
        a = CircleT(1.0, 10.0, 0.5, 1.0)
        self.s.set_shape(a)
        assert self.s.get_shape() == a

    def test_sim(self):
        t, wsol = self.s.sim(10, 100)
        