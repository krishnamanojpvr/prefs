/*
You are given a list of Product objects with fields name, category, and price. 
Write a Given a list of Product objects with the following fields:
	- name (String)
	- category (String)
	- price (double)
	- quantityInStock (int)
	
Write a program to filter products where the stock is more than 5 units.
Then group the products by their category, then find the total value of stock 
(price × quantity) for each category and finally find the category with the 
highest total stock value.

Input Format:
-------------
Line-1: AN integer N, number of products.
Next N lines: 3 space separated strings, first is name, 
              second is category and thrid is price and
			  last one is quantity.

Output Format:
--------------
A string, name of the category with highest stock value.


Sample Input:
-------------
5
Laptop Electronics 1000.0 10
Phone Electronics 500.0 5
Shoes Clothing 50.0 20
Jacket Clothing 100.0 10
Blender Home_Appliances 150.0 3

Sample Output:
--------------
Electronics
	
*/

import java.util.*;
import java.util.stream.*;

class Appliances {
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Appliances(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getStock() {
        return price * quantity;
    }
}

public class getHighestStock{
    public static String getHighestCategory(List<Appliances> list){
        return list.stream()
        .filter(appliance -> appliance.getQuantity() > 5)
        .collect(Collectors.groupingBy(Appliances::getCategory,
                Collectors.summingDouble(Appliances::getStock)))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Appliances> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String[] inp = sc.nextLine().split(" ");
            list.add(new Appliances(inp[0],inp[1],Double.parseDouble(inp[2]),Integer.parseInt(inp[3])));
        }
        System.out.println(getHighestCategory(list));
        sc.close();
    }
}