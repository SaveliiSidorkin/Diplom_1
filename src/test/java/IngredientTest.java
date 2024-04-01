import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);

    @Test
    public void testGetPrice() {
        float price = ingredient.getPrice();
        assertEquals(300, price, 0.01);
    }

    @Test
    public void testGetName() {
        String name = ingredient.getName();
        assertEquals("chili sauce", name);
    }

    @Test
    public void testGetType() {
        Enum type = ingredient.getType();
        assertEquals(SAUCE, type);
    }
}
