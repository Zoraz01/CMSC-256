package cmsc256;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RamStringTest {
    private WackyStringInterface myString;


    @Test
    public void testCountVCURAMS1() throws Exception{
        myString = new RamString("Rodney the Rams");
        int result = myString.countVCURams();
        assertEquals(1,result);
    }
    @Test
    public void testCountVCURAMS2() throws Exception{
        myString = new RamString("Hello");
        int result = myString.countVCURams();
        assertEquals(0,result);
    }
    @Test
    public void testCountVCURAMS3() throws Exception{
        myString = new RamString("Go VCURAMS");
        int result = myString.countVCURams();
        assertEquals(2,result);
    }

    @Test
    public void testCountVCURAMS4() throws Exception{
        myString = new RamString("vcu");
        int result = myString.countVCURams();
        assertEquals(0,result);
    }
    @Test
    public void testCountVCURAMS5() throws Exception{
        myString = new RamString("RAMS");
        int result = myString.countVCURams();
        assertEquals(1,result);
    }
    @Test
    public void testHasRams1() throws Exception{
        myString = new RamString("Rodney the Rams");
        boolean result = myString.hasRams();
        assertEquals(false,result);
    }
    @Test
    public void testHasRams2() throws Exception{
        myString = new RamString("1rams");
        boolean result = myString.hasRams();
        assertEquals(true,result);
    }
    @Test
    public void testHasRams3() throws Exception{
        myString = new RamString("Go rams");
        boolean result = myString.hasRams();
        assertEquals(false,result);
    }
    @Test
    public void testHasRams4() throws Exception{
        myString = new RamString("VCU");
        boolean result = myString.hasRams();
        assertEquals(false,result);
    }
    @Test
    public void testHasRams5() throws Exception{
        myString = new RamString("rams rams");
        boolean result = myString.hasRams();
        assertEquals(true,result);
    }
    @Test
    public void testHasRepeatingrefix1() throws Exception{
        myString = new RamString("VCU is in VCU");
        boolean result = myString.hasRepeatingPrefix(3);
        assertEquals(true,result);
    }
    @Test
    public void testHasRepeatingrefix4() throws Exception{
        myString = new RamString("How do How");
        boolean result = myString.hasRepeatingPrefix(3);
        assertEquals(true,result);
    }
    @Test
    public void testHasRepeatingrefix2() throws Exception{
        myString = new RamString("man i just did a man");
        boolean result = myString.hasRepeatingPrefix(3);
        assertEquals(true,result);
    }
    @Test
    public void testHasRepeatingrefix3() throws Exception{
        myString = new RamString("true");
        boolean result = myString.hasRepeatingPrefix(5);
        assertEquals(false,result);
    }
    @Test
    public void testHasRepeatingrefix5() throws Exception{
        myString = new RamString("Well look at me");
        boolean result = myString.hasRepeatingPrefix(4);
        assertEquals(false,result);
    }
    @Test
    public void testMakeNumberSubsitution1() throws Exception{
        myString = new RamString("give some");
        String result = myString.makeNumberSubstitutions();
        assertEquals("g1v3 50m3",result);
    }
    @Test
    public void testMakeNumberSubsitution2() throws Exception{
        myString = new RamString("gotta");
        String result = myString.makeNumberSubstitutions();
        assertEquals("g0tta",result);
    }
    @Test
    public void testMakeNumberSubsitution3() throws Exception{
        myString = new RamString("can");
        String result = myString.makeNumberSubstitutions();
        assertEquals("can",result);
    }
    @Test
    public void testRemoveNot1() throws Exception{
        myString = new RamString("Do not do that");
        String result = myString.removeNot();
        assertEquals("Do do that",result);
    }
    @Test
    public void testRemoveNot2() throws Exception{
        myString = new RamString("How could you not not do that");
        String result = myString.removeNot();
        assertEquals("How could you do that",result);
    }
    @Test
    public void testRemoveNot3() throws Exception{
        myString = new RamString("How do you do");
        String result = myString.removeNot();
        assertEquals("How do you do",result);
    }

}