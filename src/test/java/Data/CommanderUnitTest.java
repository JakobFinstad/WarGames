package Data;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommanderUnitTest {
    CommanderUnit commanderUnitAttacker = new CommanderUnit("Test1",10,10,10);
    CommanderUnit commanderUnitDefender = new CommanderUnit("Test2",20,20,20);
    CommanderUnit dummyTarget = new CommanderUnit("Test3",0,0,0);

    @Test
    public void testDefaultContstructor(){
        CommanderUnit negativeString = new CommanderUnit("",10,10,10);
        CommanderUnit positiveTest = new CommanderUnit("Test", 10,10,10);
        CommanderUnit negativeHealth = new CommanderUnit("Test",-10,10,10);
        CommanderUnit negativeAttack = new CommanderUnit("Test",10,-10,10);
        CommanderUnit negativeArmor = new CommanderUnit("Test",1,1,-1);
        assertEquals(0,negativeArmor.getArmor());
        assertEquals(0,negativeAttack.getAttack());
        assertEquals(0,negativeHealth.getHealth());
        assertEquals("Invalid name",negativeString.getName());
    }

    @Test
    public void testBasicConstructor(){
        CommanderUnit negativeString2 = new CommanderUnit("",1);
        CommanderUnit positiveTest2 = new CommanderUnit("Test",1);
        CommanderUnit negativeHealth2 = new CommanderUnit("Test",-1);
        assertEquals(0,negativeHealth2.getHealth());
        assertEquals("Invalid name", negativeString2.getName());
    }

    @Test
    public void testAttack() {
        commanderUnitAttacker.attack(commanderUnitDefender);
        assertEquals(20, commanderUnitDefender.getHealth());
        dummyTarget.attack(commanderUnitAttacker);
        dummyTarget.attack(commanderUnitAttacker);
        assertEquals(10, commanderUnitAttacker.getHealth());
        commanderUnitDefender.attack(commanderUnitAttacker);
        assertEquals(0, commanderUnitAttacker.getHealth());
    }
}
