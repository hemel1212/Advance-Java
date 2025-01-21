package Fruit_Inn;

import java.util.ArrayList;

public class ChangeName extends ReadFromDatabase{
    StringBuilder output = new StringBuilder();
    public ArrayList<String> changeName() {
        ArrayList<String> newData = new ArrayList<>();

        for (String productData : super.readFromDatabase()) {
            String[] newProductItem = productData.split(",");

            switch (newProductItem[1]) {
                case "apple" -> newProductItem[1] = "Apple";
                case "orange" -> newProductItem[1] = "Orange";
                case "banana" -> newProductItem[1] = "Banana";
                case "mango" -> newProductItem[1] = "Mango";
            }
            newData.add(newProductItem[0] + "," + newProductItem[1] + "," + newProductItem[2] + "," + newProductItem[3] + "," + newProductItem[4] + "," + newProductItem[5] + "," + newProductItem[6]);
        }

        output.append(String.format("%-3s %-10s %-10s %-10s %-6s %-15s %-15s\n", "id", "name", "buyer", "seller", "price", "buy_date", "sell_date"));
        output.append(String.format("-------------------------------------\n"));
        for (String items : newData) {
            String[] item = items.split(",");
            output.append(String.format("%-3s %-10s %-10s %-10s %-6s %-15s %-15s\n", item[0], item[1], item[2], item[3], item[4], item[5], item[6]));
        }

        return newData;
    }

    public void changeNameInDataFromDatabasePrint() {
        System.out.println(output);
    }

}
