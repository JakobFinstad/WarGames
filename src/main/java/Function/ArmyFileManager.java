package Function;

import Data.InfantryUnit;
import Data.Unit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArmyFileManager {
    private File armyFile;

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

    public ArmyFileManager(File file){
        try {
            this.armyFile = file;
        }catch(NullPointerException nu){
            System.out.println("Cannot find file");
            System.out.println(nu.getMessage());
        }catch (Exception e){
            // Skriv inn Throw til senere håndtering
            // Eks. throw new "NoeGikkGaltException";
            System.out.println("Someting went wrong");
            System.out.println(e.getMessage());
        }
    }

    /*public ArmyFileManager(Army army){
        this.army = army;
        try {
            armyFile = new File("src\\main\\resources\\"+ army.getName() + ".txt");
            if(armyFile.createNewFile()){
                System.out.println("File created: "+ armyFile.getName());
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }*/

    public void writeToFile(Army army) throws IOException {
        FileWriter writer = new FileWriter(armyFile);
        writer.write(army.getName() + "\n");

        for(Unit u: army.getAllUnits()){
            writer.write(u.getClass().getSimpleName() + "," + u.getName() + "," + u.getHealth() + "\n");
        }


        writer.close();
    }


   public Army readFromFile() throws FileNotFoundException {
        Army readArmy = null;
        UnitFactory factory = new UnitFactory();

        Scanner scanner = new Scanner(armyFile);
        readArmy = new Army(scanner.nextLine());
        while(scanner.hasNextLine()){
            String[] scannerline = scanner.nextLine().split(",");
            readArmy.add(factory.createUnit(scannerline[0],scannerline[1],Integer.valueOf(scannerline[2])));
        }

        return readArmy;
    }



}
