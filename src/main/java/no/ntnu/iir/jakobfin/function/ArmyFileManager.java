package no.ntnu.iir.jakobfin.function;

import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.exceptions.CorruptLineInFileException;
import no.ntnu.iir.jakobfin.exceptions.WrongFileFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class to create file and read and write armies to this file.
 *
 * @author 10007
 * @version 04.05.2022
 */
public class ArmyFileManager {
    private File armyFile;

    /**
     * Constructor for the file manager. Create new file if a file with the given filename don't exist.
     *
     * @param fileName the name of the file that shall be created
     */
    public ArmyFileManager(String fileName){
        try {
            armyFile = new File("src\\main\\resources\\"+ fileName + ".csv");
            if(armyFile.createNewFile()){
                System.out.println("File created: "+ fileName);
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Constructor that connect the file manager to a file that already exists.
     *
     * @param file the file to connect the manager to
     * @throws WrongFileFormatException throws if the file is in the wrong format, doesn't end with csv
     */
    public ArmyFileManager(File file) throws WrongFileFormatException {
            String armyFileName = file.getPath().substring(file.getPath().length()-3);
            if(!armyFileName.equals("csv")) {
                throw new WrongFileFormatException(file.getPath());
            }else {
                this.armyFile = file;
            }

    }


    /**
     * Write an army to the file. Overwrite the old file if the file already contains text.
     *
     * @param army the army that shall be saved to the file
     * @throws IOException get thrown if the writer fails to write to the file
     */
    public void writeToFile(Army army) throws IOException {
        FileWriter writer = new FileWriter(armyFile);
        writer.write(army.getName() + "\n");

        for(Unit u: army.getAllUnits()){
            writer.write(u.getClass().getSimpleName() + "," + u.getName() + "," + u.getHealth() + "\n");
        }


        writer.close();
    }


    /**
     * Create an army by the given file. Read a file and create units from the file.
     *
     * @return list with units created in the reading process
     * @throws FileNotFoundException gets thrown if the file cannot be found, or the path for the file is wrong
     * @throws CorruptLineInFileException thrown if there was a problem of the format of the read line
     */
   public Army readFromFile() throws FileNotFoundException, CorruptLineInFileException {
        Army readArmy = null;
        UnitFactory factory = new UnitFactory();

        Scanner scanner = new Scanner(armyFile);
        readArmy = new Army(scanner.nextLine());
            while (scanner.hasNextLine()) {
                String[] scannerline = scanner.nextLine().split(",");
                try {
                    readArmy.add(factory.createUnit(scannerline[0], scannerline[1], Integer.valueOf(scannerline[2])));
                }catch (IllegalArgumentException ile){
                    int number = readArmy.getAllUnits().size()+2;
                    throw new CorruptLineInFileException(String.valueOf(number));
                }
            }


        return readArmy;
    }



}
