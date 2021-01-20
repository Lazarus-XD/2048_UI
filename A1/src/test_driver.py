## @file test_driver.py
#  @author Rizwan Ahsan
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date 01/20/2021

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
import cmath

passed = 0
failed = 0

##complex_adt.py tests
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
#test 1
if a.get_phi() == cmath.phase(b):
    print("ComplexT.get_phi() test 1 PASSES")
    passed += 1
else:
    print("ComplexT.get_phi() test 1 FAILS")
    failed += 1

#test 2
if ComplexT(-10.0, 0.0).get_phi() == cmath.phase(complex(-10.0, 0.0)):
    print("ComplexT.get_phi() test 2 PASSES")
    passed += 1
else:
    print("ComplexT.get_phi() test 2 FAILS")
    failed += 1

#test 3
if ComplexT(0.0, 0.0).get_phi() == 0.0:
    print("ComplexT.get_phi() test 3 PASSES")
    passed += 1
else:
    print("ComplexT.get_phi() test 3 FAILS")
    failed += 1

#test 4
if ComplexT(0.0, 50.0).get_phi() == cmath.phase(complex(0.0, 50.0)):
    print("ComplexT.get_phi() test 4 PASSES")
    passed += 1
else:
    print("ComplexT.get_phi() test 4 FAILS")
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
    print("ComplexT.recip() test FAILS")
    failed += 1

#special test for recip method
try:
    ComplexT(0.0, 0.0).recip()
    print("ComplexT.recip() special test FAILS")
    failed += 1
except:
    print("ComplexT.recip() special test PASSES")
    passed += 1

#test for div method
div1 = a.div(c)
div2 = b.__truediv__(f)
if div1 == ComplexT(round(div2.real, 5), round(div2.imag, 5)):
    print("ComplexT.div() test PASSES")
    passed += 1
else:
    print("ComplexT.div() test FAILS")
    failed += 1

#special test for div method
try:
    a.div(ComplexT(0.0, 0.0))
    print("ComplexT.div() special test FAILS")
    failed += 1
except:
    print("ComplexT.div() special test PASSES")
    passed += 1

#test for sqrt method
sqrt = a.sqrt()
sqrt2 = cmath.sqrt(b)
if ComplexT(round(sqrt.real(), 5), round(sqrt.imag(), 5)) == ComplexT(round(sqrt2.real, 5), round(sqrt2.imag, 5)):
    print("ComplexT.sqrt() test PASSES")
    passed += 1
else:
    print("ComplexT.sqrt() test FAILS")
    failed += 1


##triangle_adt.py tests
tri = TriangleT(3, 4, 5)
tri2 = TriangleT(5, 6, 7)

#test for get_sides method
if tri.get_sides() == (3, 4, 5):
    print("TriangleT.get_sides() test PASSES")
    passed += 1
else:
    print("TriangleT.get_sides() test FAILS")
    failed += 1

#test for equal method
if not tri.equal(tri2):
    print("TriangleT.equal() test PASSES")
    passed += 1
else:
    print("TriangleT.equal() test FAILS")
    failed += 1

#test for get_sides method
if tri.perim() == 12:
    print("TriangleT.perim() test PASSES")
    passed += 1
else:
    print("TriangleT.perim() test FAILS")
    failed += 1

#test for area method
if tri.area() == 6:
    print("TriangleT.area() test PASSES")
    passed += 1
else:
    print("TriangleT.area() test FAILS")
    failed += 1

#test for is_valid method
if tri.is_valid():
    print("TriangleT.is_valid() test PASSES")
    passed += 1
else:
    print("TriangleT.is_valid() test FAILS")
    failed += 1

#test for tri_type method
#test 1
if tri.tri_type() == TriType.right:
    print("TriangleT.tri_type() test 1 PASSES")
    passed += 1
else:
    print("TriangleT.tri_type() test 1 FAILS")
    failed += 1

#test 2
if TriangleT(5,5,5).tri_type() == TriType.equilat:
    print("TriangleT.tri_type() test 2 PASSES")
    passed += 1
else:
    print("TriangleT.tri_type() test 2 FAILS")
    failed += 1

#test 3
if TriangleT(7,5,5).tri_type() == TriType.isosceles:
    print("TriangleT.tri_type() test 3 PASSES")
    passed += 1
else:
    print("TriangleT.tri_type() test 3 FAILS")
    failed += 1

#test 4
if TriangleT(7,9,13).tri_type() == TriType.scalene:
    print("TriangleT.tri_type() test 4 PASSES")
    passed += 1
else:
    print("TriangleT.tri_type() test 4 FAILS")
    failed += 1

print(f"\nPASSED: {passed}/26, FAILED: {failed}/26")