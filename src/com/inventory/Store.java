package com.inventory;

import java.util.*;

//inventory Management system
public class Store {

    //all fields are collections

    //collection of inventory items

    private static Random random=new Random();
    //product sku and its inventory
    private Map<String,InventoryItem> inventory;


    private NavigableSet<Cart> carts=new TreeSet<>(
            Comparator.comparing(Cart::getId)
    );

    //items by category
    private Map<Category,Map<String,InventoryItem>> aisleInventory;


    public static void main(String[] args) {

        Store s=new Store();
        s.stockStore();
        s.listInventory();

        s.stockAisles();
        s.listProductsByCategory();

    }

    private void manageStoreCarts(){

    }
    private boolean checkOutCart(Cart cart){

            return false;
    }

    //abandon physical and virtual carts, if the date associated with the cart, is different than the current date.
    private void abandonCarts(){

    }
    private void listProductsByCategory(){
            aisleInventory.keySet().forEach(k->{
                System.out.println("------\n"+k+"\n--------");
                aisleInventory.get(k).keySet().forEach(System.out::println);
            });
    }

    //initial stocking of store with some products
    private void stockStore(){
            inventory=new HashMap<>();
            //creating a list of products
            List<Product> products=new ArrayList<>(List.of(
                    new Product("A100","apple","local",Category.PRODUCE),
                    new Product("B100","banana","local",Category.PRODUCE),
                    new Product("P100","pear","local",Category.PRODUCE),
                    new Product("L103","lemon","local",Category.PRODUCE),
                    new Product("M201","milk","farm",Category.DAIRY),
                    new Product("Y001","yogurt","farm",Category.DAIRY),
                    new Product("C333","cheese","farm",Category.DAIRY),
                    new Product("R777","rice chex","Nabisco",Category.CEREAL),
                    new Product("G111","granola","Nat Valley",Category.CEREAL),
                    new Product("BB11","ground beef","butcher",Category.MEAT),
                    new Product("CC11","chicken","butcher",Category.MEAT),
                    new Product("BC11","bacon","butcher",Category.MEAT),
                    new Product("BC77","coke","coca cola",Category.BEVERAGE),
                    new Product("BC88","coffee","value",Category.BEVERAGE),
                    new Product("BC99","tea","herbal",Category.BEVERAGE)
            )
            );

        //adding each product to inventory
            products.forEach(p->inventory.put(p.sku(),new InventoryItem(p, random.nextDouble(0,1.25),1000,5)));

    }

    //stock Aisles

    private void stockAisles(){
        aisleInventory=new EnumMap<>(Category.class);
        for(InventoryItem item: inventory.values()){
            Category aisle=item.getProduct().category();
            Map<String,InventoryItem> productMap=aisleInventory.get(aisle);
            if(productMap==null){
                productMap=new TreeMap<>();
            }
            productMap.put(item.getProduct().name(),item);
            aisleInventory.putIfAbsent(aisle,productMap);
        }
    }

    private void listInventory(){
        System.out.println("---------------------");
        inventory.values().forEach(System.out::println);
    }
}
