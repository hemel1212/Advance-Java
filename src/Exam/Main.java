package Exam;

public class Main {
    public static void main(String[] args) {

        String insert1 = "insert into product(product_id, product_name, product_qty, product_brand) values(1, 'Laptop', 5, 'Dell')";
        String insert2 = "insert into product(product_id, product_name, product_qty, product_brand) values(2, 'Headphones', 5, 'Sony')";
        String insert3 = "insert into product(product_id, product_name, product_qty, product_brand) values(3, 'Tablet', 5, 'Apple')";

        String fetchData = "select * from product";

        String update = "update product set product_brand = 'Samsung' where product_id = 3";

        String delete = "delete from product where product_id = 2";


        Crudo_Peration crudOperation = new Crudo_Peration();
        //crudOperation.insertProduct(insert3);
        //crudOperation.fetchProduct(fetchData);
        crudOperation.updateProduct(update);
        //crudOperation.deleteProduct(delete);
    }
}