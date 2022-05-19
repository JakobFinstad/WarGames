package Function;

import Data.CavalryUnit;
import Data.InfantryUnit;
import Data.RangedUnit;
import Data.Unit;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ArmyFileManagerTest {

    Army testArmy;
    @Before
    public void setUp(){
        testArmy = new Army("TestArmy");
        Unit unit1 = new RangedUnit("Test1",10);
        Unit unit2 = new RangedUnit("Test2",10);
        Unit unit3 = new CavalryUnit("Test3",10);
        Unit unit4 = new CavalryUnit("Test4",10);
        Unit unit5 = new InfantryUnit("Test5",10);
        Unit unit6 = new InfantryUnit("Test6",10);

        testArmy.add(unit1);
        testArmy.add(unit2);
        testArmy.add(unit3);
        testArmy.add(unit4);
        testArmy.add(unit5);
        testArmy.add(unit6);

    }
    @Test
    public void testFileCreation(){
        ArmyFileManager fileManager = new ArmyFileManager(testArmy.getName());
    }

    @Test
    public void testWriting(){
        ArmyFileManager fileManager = new ArmyFileManager(testArmy.getName());
        try{
            fileManager.writeToFile(testArmy);
        }catch (IOException ioException){
            System.out.println("Something went wrong");
            System.out.println(ioException.getMessage());
        }
    }

    @Test
    public void testReadFromFile() {
        ArmyFileManager fileManager = new ArmyFileManager(testArmy.getName());
        Army army = null;
        try {
            army = fileManager.readFromFile();
            assertEquals(6,army.getAllUnits().size());

        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }

    }
}