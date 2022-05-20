package function;

import data.CavalryUnit;
import data.InfantryUnit;
import data.RangedUnit;
import data.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class that tests the army and the armies function.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class ArmyTest {

    Army testArmy;
    Unit unit1;
    Unit unit2;
    Unit unit3;
    Unit unit4;
    Unit unit5;
    Unit unit6;

    @BeforeEach
    public void setup() {
            Army testArmy = new Army("TestArmy");
            Unit unit1 = new RangedUnit("Test1", 10);
            Unit unit2 = new RangedUnit("Test2", 10);
            Unit unit3 = new CavalryUnit("Test3", 10);
            Unit unit4 = new CavalryUnit("Test4", 10);
            Unit unit5 = new InfantryUnit("Test5", 10);
            Unit unit6 = new InfantryUnit("Test6", 10);
    }

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
