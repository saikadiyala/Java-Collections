package com.inventory;
//inventory Management system
public class InventoryItem {
    private Product product;
    private double price;
    //total quantity of product available
    private int qtyTotal;
    //quantity in carts, but not yet sold , reserved,
    private int qtyReserved;

    //reorder amt is what you'd use to order more product
    private int qtyReorder;

    //low quantity is the trigger or threshold to order more product
    //when low quantity is reached, system should order more product
    private int qtyLow;

    public InventoryItem(Product product, double price, int qtyTotal,int qtyLow) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow=qtyLow;
        this.qtyReorder=qtyTotal;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    //this is called, before product is added into cart
    //qty is the number of quantity of product is added into cart
    public boolean reserveItem(int qty){

        //checking the total quantity available and reserved quantity difference is greater than requested quantity
        if((qtyTotal-qtyReserved)>=qty){
            qtyReserved+=qty;
            return true;
        }
        return false;
    }


    //After product is removed from cart, this is called to reduce quantity reserved.
   //This can be called when the carts are needed to be freed up automatically
    public void releaseItem(int qty){
        qtyReserved-=qty;
    }

    //called in the checkout process
    public boolean sellItem(int qty){
        if(qtyTotal>=qty){
            qtyTotal-=qty;
            qtyReserved-=qty;
            if(qtyTotal<=qtyLow){
                //if less than threshold , then placing an order
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }

    private void placeInventoryOrder(){
        System.out.printf("Ordering quantity %d : %s%n",qtyReorder,product);
    }

    @Override
    public String toString() {
        return "product=" + product +
                ", price=" + price +
                ", qtyTotal=" + qtyTotal +
                ", qtyReserved=" + qtyReserved ;
    }
}
