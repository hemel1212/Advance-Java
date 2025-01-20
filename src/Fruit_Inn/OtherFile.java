package Fruit_Inn;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class OtherFile {

    public static void main(String[] args) throws FileNotFoundException {
        //crating objects:
        ReadCSV_File readCsvFile = new ReadCSV_File();
        InsertDatabase insert = new InsertDatabase();
        ReadFromDatabase readData = new ReadFromDatabase();
        ChangeName change = new ChangeName();
        UpdateData updatedData = new UpdateData();
        System.out.println();

        //read csv file:
        System.out.println("Reading data from CSV file...");
        System.out.println(Arrays.deepToString(readCsvFile.readCsvFile()));
        System.out.println();

        //insert data into database:
        System.out.println("Inserting data into database...");
        insert.insertDatabase(readCsvFile.readCsvFile());
        System.out.println();

        //read data from database:
        System.out.println("Reading data from database...");
        readData.readFromDatabase();
        readData.readDataFromDatabasePrint();
        System.out.println();

        //change name:
        System.out.println("Changing name from database data...");
        change.changeName();
        change.changeNameInDataFromDatabasePrint();
        System.out.println();

        //write new file with updated data:
        System.out.println("Writing a new file with updated data...");
        updatedData.writingNewFileWithUpdatedData();
        System.out.println();

    }
}
