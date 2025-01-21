package Fruit_Inn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSV_File {
    public String[][] readCsvFile() throws FileNotFoundException {
        String databaseFile = "src/Fruit_Inn/fruitDtails.csv";
        Scanner read = new Scanner(new File(databaseFile));

        int rowCount = 0;
        int columnCount = 0;
        while (read.hasNext()) {
            rowCount++;
            String singleProduct = read.nextLine();
            String[] productInfo = singleProduct.split(",");
            columnCount = productInfo.length;
        }
        String[][] productLists = new String[rowCount][columnCount];

        read.close();
        read = new Scanner(new File(databaseFile));

        int currentRow = 0;
        while (read.hasNext()) {
            String singleProduct = read.nextLine();
            String[] productInfo = singleProduct.split(",");
            for (int j = 0; j < productInfo.length; j++) {
                productLists[currentRow][j] = productInfo[j];
            }
            currentRow++;
        }
        read.close();

        return productLists;
    }
}
