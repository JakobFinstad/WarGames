package function;

import data.CavalryUnit;
import data.InfantryUnit;
import data.RangedUnit;
import data.Unit;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * A class that tests writing and reading from file. It uses some basic units to check if the files in resources are right.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class ArmyFileManagerTest {

    Army testArmy;

    /**
     * Some code that will run before every test. This is a basic setup for an army for testing.
     */
    @BeforeEach
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

    /**
     * Testing creation of file. If the file already exist, the file manager will connect to the file for this army.
     *
     * test will <code>PASS</code> if the file manager successfully connect or create a file for the army
     *
     * test will <code>FAIL</code> if the file manager can't create a file with the army name
     */
    @Test
    public void testFileCreation(){
        ArmyFileManager fileManager = new ArmyFileManager(testArmy.getName());
    }


    /**
     * Checking for writing potency for the file manager class. Writing the testArmy to the given file.
     *
     * test will <code>PASS</code> if the file manager is connected to a file, and successfully write to the file, and the reading was complete
     *
     * test will <code>FAIL</code> if the file manager is not connected, or an error occurred during writing to the file or reading
     */
    @Test
    public void testWritingAndReading(){
        ArmyFileManager fileManager = new ArmyFileManager(testArmy.getName());
        try{
            fileManager.writeToFile(testArmy);
        }catch (IOException ioException){
            System.out.println("Something went wrong");
            System.out.println(ioException.getMessage());
        }

        /**
         * Testing reading in the same method to ensure complete writing before the reading.
         */
        Army army = null;
        try {
            army = fileManager.readFromFile();
            assertEquals(6,army.getAllUnits().size());
            assertEquals(2,army.getInfatryUnits().size());
            assertEquals(2,army.getCavalryUnits().size());
            assertEquals(2,army.getRangedUnits().size());

        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }

    }


}