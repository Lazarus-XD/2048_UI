/**
 * Author: Rizwan Ahsan, ahsanm7
 * Revised: March 29, 2021
 * 
 * Description: Test cases for ProgramT
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestProgramT {

    private ProgramT p1;

    @Before
    public void setUp() {
        p1 = new ProgramT();
    }

    @After
    public void tearDown() {
        p1 = null;
    }
	
	@Test (expected = UnsupportedOperationException.class)
    public void testMeasures1() {
        p1.measures();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testMeasures2() {
        p1.measures(IndicatorT.math);
    }
}
