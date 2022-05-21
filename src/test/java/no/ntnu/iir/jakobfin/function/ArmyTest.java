package no.ntnu.iir.jakobfin.function;


import no.ntnu.iir.jakobfin.data.Unit;
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

    @BeforeEach
    public void setup() {
            testArmy = new Army("TestArmy");
            UnitFactory factory = new UnitFactory();
            unit1 = factory.createUnit("RangedUnit","Test1",10);
            unit2 = factory.createUnit("RangedUnit","Test2",10);;
            unit3 = factory.createUnit("CavalryUnit","Test3",10);;
    }

    @Test
    public void getNameTest(){
        Army testName = new Army("TestName");
        assertEquals("TestName",testName.getName());
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
