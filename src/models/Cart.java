package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int subTotal = 0, noOfItems;
    Map<String, CartItem> cartItemMap = new HashMap<>();
    Map<String, Integer> totalCartItems = new HashMap<>();

    public void addVariantBasedProductToCart(Product product, Variant variant) {
        String key = product.name + " " + variant.name;
        if (cartItemMap.containsKey(key)) {
            cartItemMap.get(key).qty++;
        } else {
            cartItemMap.put(key, new CartItem(variant.name, variant.price));
        }
        noOfItems++;
        subTotal += variant.price;
        System.out.println(subTotal);
        if (totalCartItems.containsKey(product.name)) {
            int qty = totalCartItems.get(product.name) + 1;
            totalCartItems.put(product.name, qty);
        } else {
            totalCartItems.put(product.name, 1);
        }
    }

    public void removeVariantBasedProductFromCart(Product product, Variant variant) {
        String key = product.name + " " + variant.name;
        //Condition to check that the product is in cart or not
        if (cartItemMap.containsKey(key)) {
            noOfItems--;
            subTotal -= variant.price;
            cartItemMap.get(key).qty--;
            if (cartItemMap.get(key).qty == 0) {
                cartItemMap.remove(key);
            }

            int qty = totalCartItems.get(product.name) - 1;
            totalCartItems.put(product.name, qty);
            if (qty == 0) {
                totalCartItems.remove(product.name);
            }
        }
    }

    public void updateWBProductInCart(Product product, float quantity) {
        int newPrice = (int) (product.pricePerKg * quantity);
        if (cartItemMap.containsKey(product.name)) {
            subTotal -= cartItemMap.get(product.name).price;
            cartItemMap.put(product.name, new CartItem(product.name, newPrice, quantity));
            subTotal += newPrice;
        } else {
            noOfItems++;
            cartItemMap.put(product.name, new CartItem(product.name, newPrice, quantity));
            subTotal += newPrice;
        }

    }

    public void removeWBProductInCart(Product product) {
        if (cartItemMap.containsKey(product.name)) {
            noOfItems--;
            subTotal -= cartItemMap.get(product.name).price;
            cartItemMap.remove(product.name);
        }
    }

    public void removeAllVariants(Product product) {
        for (Variant variant : product.variants) {
            String key = product.name + " " + variant.name;
            if (cartItemMap.containsKey(key)) {
                subTotal -= cartItemMap.get(key).price;
                System.out.println(subTotal);
                noOfItems -= cartItemMap.get(key).qty;
                cartItemMap.remove(key);
            }
        }
        totalCartItems.remove(product.name);


    }


    @Override
    public String toString() {
        return "models.Cart{" +
                "subTotal=" + subTotal +
                ", noOfItems=" + noOfItems +
                ", cartItemMap=" + cartItemMap +
                ", totalCartItems=" + totalCartItems +
                '}';
    }
}
