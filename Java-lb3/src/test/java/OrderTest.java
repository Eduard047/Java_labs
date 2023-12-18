import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderTest {
    @Mock
    private Cart cart;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPrice() {
        when(cart.getProducts()).thenReturn(Arrays.asList(
                new Product(1, "Product 1", 10.0),
                new Product(2, "Product 2", 20.0)
        ));

        Order order = new Order(1, cart);

        assertEquals(30.0, order.getTotalPrice(), 0.01);
    }

    @Test
    public void testPlaceOrderAndGetStatus() {
        Order order = new Order(1, cart);

        order.placeOrder();

        assertEquals("Виконано", order.getStatus());

        verify(cart, times(1)).placeOrder();
    }
}
