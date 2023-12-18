import org.example.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {

        product = mock(Product.class);
    }

    @Test
    public void testGetPrice() {

        when(product.getPrice()).thenReturn(10.0);


        assertEquals(10.0, product.getPrice(), 0.01);
    }
}
