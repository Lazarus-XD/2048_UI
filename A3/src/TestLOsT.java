/**
 * Author: Rizwan Ahsan, ahsanm7
 * Revised: March 29, 2021
 * 
 * Description: Test cases for LOsT module
 */

package src;

import org.junit.*;

import java.util.Arrays;
import static org.junit.Assert.*;

public class TestLOsT {
    private LOsT lo1;

    @Before
    public void setUp() {
        lo1 = new LOsT("topic 1", 23, 45, 56, 89);
    }

    @After
    public void tearDown() {
        lo1 = null;
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForExceptionIllegalArgument1()
    {
        LOsT lo2 = new LOsT("topic 2", 23, -45, 56, 89);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForExceptionIllegalArgument2()
    {
        LOsT lo3 = new LOsT("topic 3", 0, 0, 0, 0);
    }

    @Test
    public void testgetName()
    {
        assertTrue(lo1.getName().equals("topic 1"));
    }

    @Test
    public void testequals()
    {
        assertTrue(lo1.equals(new LOsT("topic 1", 10, 20, 30, 40)));
    }

    @Test
    public void testmeasures1()
    {
        Norm.setNorms(false, false, false);
        assertTrue(Arrays.equals(lo1.measures(), new double[]{23, 45, 56, 89}));
    }

    @Test
    public void testmeasures2()
    {
        Norm.setNorms(true, true, true);
        double[] d = new double[]{23, 45, 56, 89};
        assertTrue(Arrays.equals(lo1.measures(), Services.normal(d)));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testmeasures3()
    {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        AttributeT att = new AttributeT("Students", ind);
        lo1.measures(att);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testmeasures4()
    {
        lo1.measures(IndicatorT.math);
    }
}
