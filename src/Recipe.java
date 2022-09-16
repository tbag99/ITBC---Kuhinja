import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Recipe implements Priceable {

    enum RecipeLevel {
        BEGINNER(0), EASY(1), MEDIUM(2), HARD(3), PRO(4) ;
        final int val;
        RecipeLevel(int val) { this.val = val; }
        }



    private String recipeName;
    //  private int recipeID;
    private RecipeLevel recipeLevel;
    private List<WeightedIngredient> recipeIngredients;
    Recipe(){

    }

    public Recipe(String recipeName, RecipeLevel recipeLevel) {
        this.recipeName = recipeName;
        this.recipeLevel = recipeLevel;
        this.recipeIngredients = new ArrayList<>();
        Database.addRecipe(this);

    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeLevel getRecipeLevel() {
        return recipeLevel;
    }

    public void setRecipeLevel(RecipeLevel recipeLevel) {
        this.recipeLevel = recipeLevel;
    }

    public void addIngredient(WeightedIngredient x) {
        if(!recipeIngredients.contains(x))
        {
           recipeIngredients.add(x);
        }
    }


    void removeIngredient(WeightedIngredient x){
        this.recipeIngredients.remove(x);


    }



    public Recipe scaledRecipe(double i) {
        Recipe r = new Recipe();
        r.setRecipeLevel(this.recipeLevel);
        r.setRecipeName(this.recipeName);
        if (i == 50.0) {
            for (var ing : recipeIngredients) {
                ing.setWeight(ing.getWeight()/2);
                r.addIngredient(ing);



            }
        } else if (i == 33.33) {
            for (var ing : recipeIngredients) {
                ing.setWeight(ing.getWeight() / 3);
                r.addIngredient(ing);
            }


        }
        return r;
    }


    public List<WeightedIngredient> getIng() {
       return recipeIngredients;
    }

    public  double getAmount() {
        for (var ing : recipeIngredients) {


            return ing.getWeight();
        }
        return 0;

    }

    @Override
    public double getPrice() {
        double sum = 0;

        for (var el : recipeIngredients) {

            sum += el.getPricePerUnit() * el.getWeight();
        }
        return sum;
    }





    @Override
    public String toString() {
        return
                "recipeName='" + getRecipeName() + '\'' +
                        " \n recipeLevel=" + getRecipeLevel() +
                        "\nIngredients " + recipeIngredients+
                        "\nPrice " + getPrice();
    }
}
