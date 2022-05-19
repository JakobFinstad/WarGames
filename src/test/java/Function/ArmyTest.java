package Function;

import Data.CavalryUnit;
import Data.InfantryUnit;
import Data.RangedUnit;
import Data.Unit;
import Function.Army;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArmyTest {
    Army testArmy = new Army("TestArmy");
    Unit unit1 = new RangedUnit("Test1",10);
    Unit unit2 = new RangedUnit("Test2",10);
    Unit unit3 = new CavalryUnit("Test3",10);
    Unit unit4 = new CavalryUnit("Test4",10);
    Unit unit5 = new InfantryUnit("Test5",10);
    Unit unit6 = new InfantryUnit("Test6",10);

    @Test
    public void getNameTest(){
        Army testName = new Army("Testname");
        assertEquals("Testname",testName.getName());
    }

    @Test
    public void testAdd(){
        List<Unit> testList = new ArrayList<>();
        testList.add(unit1);
        testList.add(unit2);
        assertEquals(0,testArmy.getAllUnits().size());
        testArmy.add(unit3);
        assertEquals(1,testArmy.getAllUnits().size());
        testArmy.addAll(testList);
        assertEquals(3,testArmy.getAllUnits().size());
    }
}
