import java.util.HashMap;
import java.util.Map;

public class Fridge {
    private static  Map<String,WeightedIngredient> ingredient;

    public Fridge() {
        ingredient = new HashMap<>();
    }

    public static  void addIngredient(WeightedIngredient x){

ingredient.put(x.getIngredientName(), x);}


    public static boolean canUMake(Recipe r)
    {
        for (var ing : r.getIng())
        {
            if(!ingredient.containsKey(ing.getIngredientName())) {
                return false; }
            if(ingredient.get(ing.getIngredientName()).getWeight()  <  ing.getWeight())
            {
                return false;
            }
        }

        return true;
    }
    public boolean makeFood(Recipe r)
    {
        if(!canUMake(r))
            return false;
        for (var ing : r.getIng())
        {
           ingredient.get(ing.getIngredientName()).subtractWeight(ing.getWeight());
        }
        return true;
    }

    public HashMap<String, WeightedIngredient> getIngredients() {
        return (HashMap<String, WeightedIngredient>) ingredient;
    }
    public void removeIngredient(WeightedIngredient x)
    {
        ingredient.remove(x.getIngredientName());
    }



    public void lowerWeightOfIngredient(double x,String name)
    {
        if(ingredient.containsKey(name))
        {
           ingredient.get(name).subtractWeight(x);
        }
        if(ingredient.get(name).getWeight() == 0)
        {
           ingredient.remove(name);
        }
    }

    @Override
    public String toString() {
        return "Fridge{}" + getIngredients().values().toString();
    }
}


