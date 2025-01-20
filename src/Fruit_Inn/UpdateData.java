package Fruit_Inn;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UpdateData extends ChangeName {
    public void writingNewFileWithUpdatedData() throws FileNotFoundException {
        String modifiedFile = "src\\JDBC\\FIleJdbcFullOperation\\products-data-modified.txt";
        StringBuilder updateContent = new StringBuilder();

        for (String newProduct : super.changeName()) {
            String[] newProductItem = newProduct.split(",");
            updateContent.append(
                    "ID: " + newProductItem[0] + "\n" +
                            "Name: " + newProductItem[1] + "\n" +
                            "Buyer: " + newProductItem[2] + "\n" +
                            "Seller: " + newProductItem[3] + "\n" +
                            "Price: " + newProductItem[4] + "\n" +
                            "Buying Date: " + newProductItem[5] + "\n" +
                            "Selling Date: " + newProductItem[6] + "\n\n"
            );
        }

        PrintWriter printWriter = new PrintWriter(modifiedFile);
        printWriter.print(updateContent);
        System.out.println("Modified data saved into a new file!");
        printWriter.close();
    }
}