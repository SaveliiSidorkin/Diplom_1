import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient mockIngredient2 = new Ingredient(FILLING, "dinosaur", 200);
        burger.ingredients.addAll(Arrays.asList(mockIngredient, mockIngredient2));

        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetReceipt() {

        Database database = new Database();
        List<Bun> availableBuns = database.availableBuns();
        List<Ingredient> availableIngredients = database.availableIngredients();

        Burger burger = new Burger();
        burger.setBuns(availableBuns.get(2));
        burger.addIngredient(availableIngredients.get(2));

        String expectedReceipt = String.format("(==== %s ====)%n", availableBuns.get(2).getName()) +
                String.format("= %s %s =%n", availableIngredients.get(2).getType().toString().toLowerCase(),
                        availableIngredients.get(2).getName()) +
                String.format("(==== %s ====)%n", availableBuns.get(2).getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}