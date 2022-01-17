package Java_Collections;

import java.util.*;

class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");

        if (obj == this) return true;
        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem st) {
        System.out.println("Entering stockItem.compareTo");

        if (this == st) return 0;
        if (st != null) return this.name.compareTo(st.getName());

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price;
    }
}

class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);

            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value: " + totalCost;
    }
}

class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item: list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total Cost: " + totalCost;
    }
}

public class Sorted_Collection_04 {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("car",120.20,2);
        stockList.addStock(temp);

        temp = new StockItem("bike",50.15,35);
        stockList.addStock(temp);

        temp = new StockItem("chair",12.35,2);
        stockList.addStock(temp);

        temp = new StockItem("cup",5.74,17);
        stockList.addStock(temp);

        temp = new StockItem("cup",15.4,170);
        stockList.addStock(temp);

        temp = new StockItem("mat",20.5,20);
        stockList.addStock(temp);

        temp = new StockItem("fan",40.28,50);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket myBasket = new Basket("MyBas");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        sellItem(myBasket,"snapper", 5);
        System.out.println(myBasket);

        sellItem(myBasket, "cup", 10);
        sellItem(myBasket, "bike", 5);
        sellItem(myBasket, "mat", 17);
        System.out.println(myBasket);

        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

        stockList.Items().get("car").adjustStock(2000);
        stockList.Items().get("car").adjustStock(-1000);
        System.out.println(stockList);

        for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);

        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
