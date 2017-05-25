package courses.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsTest {

    @Test
    public void testCheck() {
        assertEquals(true,  Brackets.check(""));
        assertEquals(true,  Brackets.check("s"));
        assertEquals(true,  Brackets.check("(dsf sdfs)"));
        assertEquals(true,  Brackets.check("[sdfsdf]"));
        assertEquals(true,  Brackets.check("{}"));
        assertEquals(true,  Brackets.check("{(a + d) +c}"));
        assertEquals(true,  Brackets.check("{()[]()}"));
        assertEquals(true,  Brackets.check("{()[{}]()}"));
        assertEquals(true,  Brackets.check("{([])}"));
        assertEquals(true,  Brackets.check("{([([])])}"));
        assertEquals(true,  Brackets.check("[([([])])]"));
        assertEquals(false, Brackets.check("[(]"));
        assertEquals(false, Brackets.check("[(}]"));
        assertEquals(false, Brackets.check("[)"));
        assertEquals(false, Brackets.check("["));
        assertEquals(false, Brackets.check("[)]"));
        assertEquals(false, Brackets.check("}{"));
        assertEquals(false, Brackets.check(")("));
        assertEquals(false, Brackets.check("]["));
    }

}