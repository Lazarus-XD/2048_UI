/**
 * Author: Rizwan Ahsan
 * Revised: March 29, 2021
 * 
 * Description: Test cases for CourseT
 */

package src;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCourseT
{

    private CourseT c1;

    @Before
    public void setUp() {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        c1 = new CourseT("2AA4", ind);
    }

    @After
    public void tearDown() {
        c1 = null;
    }

	@Test
    public void testgetName() {
        assertEquals("2AA4", c1.getName());
    }

    @Test
    public void testgetIndicators() {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
//        String[] a = Arrays.toString(c1.getIndicators());
//        String[] b = Arrays.toString(ind);

    }

    @Test (expected = UnsupportedOperationException.class)
    public void testMeasures()
    {
        c1.measures();
    }

    @Test
    public void TestMeasures1() {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        CourseT c2 = new CourseT("Hello", ind);
        LOsT LO1 = new LOsT("topic 1", 1, 2, 3, 4);
        LOsT LO2 = new LOsT("topic 2", 1, 2, 3, 4);
        LOsT LO3 = new LOsT("topic 3", 10, 20, 30, 40);
        c2.addLO(IndicatorT.math, LO1);
        c2.addLO(IndicatorT.math, LO2);
        c2.addLO(IndicatorT.math, LO3);
        assertTrue(Arrays.equals(c2.measures(IndicatorT.math), new double[]{12, 24, 36, 48}));
    }

    @Test
    public void TestMeasures2() {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        AttributeT a = new AttributeT("HI", ind);
        CourseT c2 = new CourseT("Hello", ind);
        LOsT LO1 = new LOsT("topic 1", 2, 5, 5, 8);
        LOsT LO2 = new LOsT("topic 2", 20, 15, 0, 2);
        LOsT LO3 = new LOsT("topic 3", 2, 5, 5, 8);
        c2.addLO(IndicatorT.math, LO1);
        c2.addLO(IndicatorT.math, LO2);
        c2.addLO(IndicatorT.math, LO3);
        c2.addLO(IndicatorT.specEngKnow, LO2);
        c2.addLO(IndicatorT.specEngKnow, LO3);
        c2.addLO(IndicatorT.assumpt, LO1);
        assertTrue(Arrays.equals(c2.measures(a), new double[]{48, 50, 20, 36}));
    }
}
