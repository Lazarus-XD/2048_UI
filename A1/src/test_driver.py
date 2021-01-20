## @file test_driver.py
#  @author Rizwan Ahsan
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date 01/19/2021

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
import cmath

passed = 0
failed = 0

#complex_adt.py tests
a = ComplexT(2.0, 5.0)
b = complex(2.0, 5.0)
c = ComplexT(1.0, 3.0)
f = complex(1.0, 3.0)
d = b.__sub__(f)
e = b.__mul__(f)

#test of real method
if a.real() == b.real:
    print("ComplexT.real() test PASSES")
    passed += 1
else:
    print("ComplexT.real() test FAILS")
    failed += 1

#test of imag method
if a.imag() == b.imag:
    print("ComplexT.imag() test PASSES")
    passed += 1
else:
    print("ComplexT.imag() test FAILS")
    failed += 1

#test of get_r method
if a.get_r() == abs(b):
    print("ComplexT.get_r() test PASSES")
    passed += 1
else:
    print("ComplexT.get_r() test FAILS")
    failed += 1

#test of get_phi method
if a.get_phi() == cmath.phase(b):
    print("ComplexT.get_phi() test PASSES")
    passed += 1
else:
    print("ComplexT.get_phi() test FAILS")
    failed += 1

#test of equal method
if not a.equal(c):
    print("ComplexT.equal() test PASSES")
    passed += 1
else:
    print("ComplexT.equal() test FAILS")
    failed += 1

#test of conj method
if a.conj() == ComplexT(b.conjugate().real, b.conjugate().imag):
    print("ComplexT.conj() test PASSES")
    passed += 1
else:
    print("ComplexT.conj() test FAILS")
    failed += 1

#test of add method
if a.add(c) == ComplexT(3.0, 8.0):
    print("ComplexT.add() test PASSES")
    passed += 1
else:
    print("ComplexT.add() test FAILS")
    failed += 1

#test of sub method
if a.sub(c) == ComplexT(d.real, d.imag):
    print("ComplexT.sub() test PASSES")
    passed += 1
else:
    print("ComplexT.sub() test FAILS")
    failed += 1

#test of mult method
if a.mult(c) == ComplexT(e.real, e.imag):
    print("ComplexT.mult() test PASSES")
    passed += 1
else:
    print("ComplexT.mult() test FAILS")
    failed += 1

#test for recip method
if a.recip() == ComplexT(2/29, - 5/29):
    print("ComplexT.recip() test PASSES")
    passed += 1
else:
    print("ComplexT.recip() test PASSES")
    failed += 1

#test for div method
div1 = a.div(c)
div2 = b.__truediv__(f)
if div1 == ComplexT(div2.real, div2.imag):
    print("ComplexT.div() test PASSES")
    passed += 1
else:
    print("ComplexT.div() test PASSES")
    failed += 1

#test for sqrt method
sqrt = cmath.sqrt(b)
if a.sqrt() == ComplexT(sqrt.real, sqrt.imag):
    print("ComplexT.sqrt() test PASSES")
    passed += 1
else:
    print("ComplexT.sqrt() test PASSES")
    failed += 1