package Data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RangedUnitTest {
    RangedUnit rangedUnitAttacker = new RangedUnit("Test1",10,10,10);
    RangedUnit rangeUnitDefender = new RangedUnit("Test2",20,20,20);
    RangedUnit dummyTarget = new RangedUnit("Test3",0,0,0);

    @Test
    public void testDefaultConstructor(){
        RangedUnit negativeString = new RangedUnit("",10,10,10);
        RangedUnit positiveTest = new RangedUnit("Test", 10,10,10);
        RangedUnit negativeHealth = new RangedUnit("Test",-10,10,10);
        RangedUnit negativeAttack = new RangedUnit("Test",10,-10,10);
        RangedUnit negativeArmor = new RangedUnit("Test",1,1,-1);
        assertEquals(0,negativeArmor.getArmor());
        assertEquals(0,negativeAttack.getAttack());
        assertEquals(0,negativeHealth.getHealth());
        assertEquals("Invalid name",negativeString.getName());
    }

    @Test
    public void testBasicConstructor(){
        RangedUnit negativeString2 = new RangedUnit("",1);
        RangedUnit positiveTest2 = new RangedUnit("Test",1);
        RangedUnit negativeHealth2 = new RangedUnit("Test",-1);
        assertEquals(0,negativeHealth2.getHealth());
        assertEquals("Invalid name", negativeString2.getName());
    }

   @Test
   public void testAttack(){
        rangedUnitAttacker.attack(rangeUnitDefender);
        assertEquals(20,rangeUnitDefender.getHealth());
        dummyTarget.attack(rangedUnitAttacker);
        dummyTarget.attack(rangedUnitAttacker);
        assertEquals(10, rangedUnitAttacker.getHealth());
        rangeUnitDefender.attack(rangedUnitAttacker);
        assertEquals(0,rangedUnitAttacker.getHealth());
   }

}
