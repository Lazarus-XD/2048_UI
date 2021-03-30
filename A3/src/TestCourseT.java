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
}
