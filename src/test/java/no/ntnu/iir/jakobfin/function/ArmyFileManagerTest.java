package no.ntnu.iir.jakobfin.function;

import no.ntnu.iir.jakobfin.data.Unit;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        UnitFactory factory = new UnitFactory();

        List<Unit> factoryList = new ArrayList<>();

        factoryList.addAll(factory.createMultipleUnits("RangedUnit","Test",10,2));
        factoryList.addAll(factory.createMultipleUnits("CavalryUnit","Test",10,2));
        factoryList.addAll(factory.createMultipleUnits("InfantryUnit","Test",10,2));


        testArmy.addAll(factoryList);
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