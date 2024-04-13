import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerTestParam {

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    public BurgerTestParam(Bun bun, List<Ingredient> ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Database database = new Database();
        List<Bun> availableBuns = database.availableBuns();
        List<Ingredient> availableIngredients = database.availableIngredients();

        return Arrays.asList(new Object[][]{
                {availableBuns.get(0), Collections.singletonList(availableIngredients.get(0)), 300},
                {availableBuns.get(1), Arrays.asList(availableIngredients.get(1), availableIngredients.get(2)), 900},
                {availableBuns.get(2), Arrays.asList(availableIngredients.get(2), availableIngredients.get(3)), 1000}
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.addAll(ingredients);

        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }
}