import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("white bun", 200);

    @Test
    public void testGetName() {
        String name = bun.getName();
        assertEquals("white bun", name);
    }

    @Test
    public void testGetPrice() {
        float price = bun.getPrice();
        assertEquals(200, price, 0.01);
    }
}
