package Function;

import java.io.File;
import java.io.IOException;

public class CsvLogger {

    public CsvLogger(Army army){
        try {
            File armyFile = new File(army.getName() + ".txt");
            if(armyFile.createNewFile()){
                System.out.println("File created: "+ armyFile.getName());
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }
}
