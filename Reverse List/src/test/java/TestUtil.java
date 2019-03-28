import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestUtil {

    private List<String> list1;
    private List<String> list2;

    @Before
    public void setUp() {
        list1 = new ArrayList<>();
        list1.addAll(Arrays.asList("Word 1", "Word 2", "Word 3", "Word 4", "Word 5"));
        list2 = new LinkedList<>();
        list2.addAll(Arrays.asList("Word 5", "Word 4", "Word 3", "Word 2", "Word 1"));
    }

    @Test
    public void testReverse2() {
        List<String> list3 = Util.reverse2(list1);
        assertEquals(list2, list3);
    }

    @Test
    public void testReverse1() {
        Util.reverse1(list2);
        assertEquals(list1, list2);
    }
}