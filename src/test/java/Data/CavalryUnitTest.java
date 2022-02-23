package Data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CavalryUnitTest {
    CavalryUnit cavalryUnitAttacker = new CavalryUnit("Test1",10,10,10);
    CavalryUnit cavalryUnitDefender = new CavalryUnit("Test2",20,20,20);
    CavalryUnit dummyTarget = new CavalryUnit("Test3",0,0,0);

    @Test
    public void testDefaultContstructor(){
        CavalryUnit negativeString = new CavalryUnit("",10,10,10);
        CavalryUnit positiveTest = new CavalryUnit("Test", 10,10,10);
        CavalryUnit negativeHealth = new CavalryUnit("Test",-10,10,10);
        CavalryUnit negativeAttack = new CavalryUnit("Test",10,-10,10);
        CavalryUnit negativeArmor = new CavalryUnit("Test",1,1,-1);
        assertEquals(0,negativeArmor.getArmor());
        assertEquals(0,negativeAttack.getAttack());
        assertEquals(0,negativeHealth.getHealth());
        assertEquals("Invalid name",negativeString.getName());
    }

    @Test
    public void testBasicConstructor(){
        CavalryUnit negativeString2 = new CavalryUnit("",1);
        CavalryUnit positiveTest2 = new CavalryUnit("Test",1);
        CavalryUnit negativeHealth2 = new CavalryUnit("Test",-1);
        assertEquals(0,negativeHealth2.getHealth());
        assertEquals("Invalid name", negativeString2.getName());
    }

    @Test
    public void testAttack() {
        cavalryUnitAttacker.attack(cavalryUnitDefender);
        assertEquals(20, cavalryUnitDefender.getHealth());
        dummyTarget.attack(cavalryUnitAttacker);
        dummyTarget.attack(cavalryUnitAttacker);
        assertEquals(10, cavalryUnitAttacker.getHealth());
        cavalryUnitDefender.attack(cavalryUnitAttacker);
        assertEquals(0, cavalryUnitAttacker.getHealth());
    }

}
