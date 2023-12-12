package com.inventory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    enum CartType {
        PHYSICAL, VIRTUAL
    }
    //Unique cart id for each cart
    private static int lastId = 1;
    private int id;
    private LocalDate cartDate;
    private CartType type;
    //String is product sku, and the Integer is the quantity ordered.
    //products - all the products in the cart
    //We want to use a data structure for products, which is easy to insert and delete as this is in the cart,
    //We are using hashmap.
    private Map<String, Integer> products;

    public Cart(CartType type, int days) {
        this.type = type;
        id = lastId++;
        //using minusDays bcs we are just testing data, and creating carts today, so all of the carts will
        //have same date, so to differentiate just doing minusdays for different date for each cart.
        cartDate = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }

    public Cart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }

    public void addItem(InventoryItem item, int qty) {
        //if the item is in the map, then add the quantity to existing item quantity

        products.merge(item.getProduct().sku(), qty, Integer::sum);
        if (!item.reserveItem(qty)) {
            System.out.println("ouch something went wrong while adding to cart, could not add item");
        }
    }

    public void removeItem(InventoryItem item, int qty) {
        int current = products.get(item.getProduct().sku());
        if (current <= qty) {
            qty = current;
            products.remove(item.getProduct().sku());
            System.out.printf("Item [%s] removed from basket%n", item.getProduct().name());
        } else {
            products.merge(item.getProduct().sku(), qty, (oldVal, newVal) -> oldVal - newVal);
            System.out.printf(" %d quantity, Item [%s] removed from basket%n", qty, item.getProduct().name());
        }
        item.releaseItem(qty);
    }

    //total cart item price
    public void printSalesSlip(Map<String,InventoryItem> inventory){
       double total=0;
        System.out.println("-----------------");
        System.out.println("Thank you for your sale: ");
        for(var cartItem: products.entrySet()){
            //item contains all the information about that product
            var item=inventory.get(cartItem.getKey());
            int qty=cartItem.getValue();
            double itemizedPrice=(item.getPrice()*qty);
            total+=itemizedPrice;
            System.out.println(cartItem.getKey()+" "+item.getProduct().name()+" "+qty+" "+item.getPrice()+" "+ itemizedPrice);

        }
        System.out.println("Total Sale: "+total);
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", cartDate=" + cartDate +
                ", products=" + products ;
    }
}
