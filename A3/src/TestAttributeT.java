/**
 * Author: Rizwan Ahsan, ahsanm7
 * Revised: March 29, 2021
 * 
 * Description: Tests the AttributT module
 */

package src;

import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TestAttributeT
{

    private AttributeT att;

    @Before
    public void setUp() {
        IndicatorT[] ind = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        att = new AttributeT("Students", ind);
    }

    @After
    public void tearDown() {
        att = null;
    }

    @Test
    public void testgetName() {
        assertTrue(att.getName().equals("Students"));
    }

    @Test
    public void testgetIndicators() {
        assertTrue(Arrays.equals(att.getIndicators(), new IndicatorT[]{IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt}));
    }

}
