import models.Cart;
import models.Product;
import models.Variant;

public class Main {
    public static void main(String[] args) {
        //VariantBased in cart
        Product product = new Product("bread");
        Variant variant = new Variant("big", 14);
        Variant variant1 = new Variant("small", 7);
        Variant variant2 = new Variant("medium", 11);
        Cart cart = new Cart();
        cart.addVariantBasedProductToCart(product, variant);
        cart.addVariantBasedProductToCart(product, variant1);
        cart.addVariantBasedProductToCart(product, variant1);
        cart.addVariantBasedProductToCart(product, variant1);
        cart.addVariantBasedProductToCart(product, variant2);
        cart.removeVariantBasedProductFromCart(product, variant);
        cart.removeVariantBasedProductFromCart(product, variant1);
        System.out.println("Cart items only variants based\n");
        System.out.println(cart);

        //WeightBasedProduct in cart
        Product apple = new Product("apple", 14);
        Product potatoes = new Product("Potatoes", 10);

        cart.updateWBProductInCart(apple, 4);
        cart.updateWBProductInCart(potatoes, 9);
        System.out.println("Cart items after changing weightBased products \n");
        System.out.println(cart);
        cart.removeWBProductInCart(apple);
        cart.removeWBProductInCart(potatoes);
        System.out.println("Cart items after removing\n");
        System.out.println(cart);
    }
}
