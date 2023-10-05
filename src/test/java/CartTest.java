import org.example.Cart;
import org.example.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CartTest {

    private Cart cart;
    private Product product;

    @Before
    public void setUp() {

        product = mock(Product.class);


        cart = new Cart();
    }

    @Test
    public void testAddProductToCart() {

        when(product.getPrice()).thenReturn(10.0);


        cart.addProduct(product);


        assertEquals(1, cart.getProducts().size());
    }


}
