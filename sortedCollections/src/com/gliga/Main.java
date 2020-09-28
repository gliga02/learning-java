package com.gliga;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 10);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.5, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket myBasket = new Basket("Djordje");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        if ( sellItem(myBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock.");
        }

        sellItem(myBasket, "spanner", 5);
        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 12);
        sellItem(myBasket, "bread", 1);

        Basket customerBasket = new Basket("Customer");
        sellItem(customerBasket,"cup", 100);
        sellItem(customerBasket, "juice", 5);
        removeItem(customerBasket, "cup", 1);
        System.out.println(customerBasket);

        removeItem(myBasket, "car", 1);
        removeItem(myBasket, "cup", 9);
        removeItem(myBasket, "car", 1);
        System.out.println("Cars removed: " + removeItem(myBasket, "car", 1));
        System.out.println(myBasket);
        removeItem(myBasket, "bread", 1);
        removeItem(myBasket, "cup", 3);
        removeItem(myBasket, "juice", 4);
        removeItem(myBasket, "cup", 3);

        System.out.println(myBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(customerBasket);
        System.out.println(stockList);
        checkOut(customerBasket);
        System.out.println(customerBasket);
        System.out.println(stockList);


        StockItem car = stockList.Items().get("car");
        if (car != null) {
            car.adjustStock(2000);
        }

        if (car != null) {
            stockList.get("car").adjustStock(-1000);
        }

        System.out.println(stockList);

        checkOut(myBasket);
        System.out.println(myBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }

        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }

        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }

        basket.clearBasket();
    }
}
