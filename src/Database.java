import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {


    private static final HashMap<String, WeightedIngredient> allIngredients = new HashMap<>();
    private static final HashMap<String, Recipe> allRecipe = new HashMap<>();

    static void addIngredient(WeightedIngredient ingredient) {
        allIngredients.put(ingredient.getIngredientName(),ingredient);
    }

    static void addRecipe(Recipe recipe) {
        allRecipe.put(recipe.getRecipeName(),recipe);
    }



    public static void ingredientsBase() {
        allIngredients.put("jaja", new WeightedIngredient("jaja", 20,10));
       allIngredients.put("meso", new WeightedIngredient("meso", 500,300));
        allIngredients.put("kupus", new WeightedIngredient("kupus", 500,40));
        allIngredients.put("pirinac", new WeightedIngredient("pirinac", 1000,10));
       allIngredients.put("brasno", new WeightedIngredient("brasno", 130,4));
       allIngredients.put("krem", new WeightedIngredient("krem", 60,12));
       allIngredients.put("secer", new WeightedIngredient("secer", 300,70));
        allIngredients.put("kore", new WeightedIngredient("kore", 700,23));
        allIngredients.put("mleko", new WeightedIngredient("mleko", 200,65));
        allIngredients.put("paprika", new WeightedIngredient("paprika", 700,80));
        allIngredients.put("testenina", new WeightedIngredient("testenina", 500,80));
        allIngredients.put("sir", new WeightedIngredient("sir", 500,150));
        allIngredients.put("paradajiz", new WeightedIngredient("paradajiz", 400,50));
        allIngredients.put("krastavac", new WeightedIngredient("krastavac", 400,40));




    }

    public  static void recipeBase(){
        Recipe r1 = new Recipe("kajgana", Recipe.RecipeLevel.EASY);
        r1.addIngredient(new WeightedIngredient("jaje",6,10));
        allRecipe.put("kajgana",r1);


        Recipe r2 = new Recipe("sarma", Recipe.RecipeLevel.PRO);
        r2.addIngredient(new WeightedIngredient("kupus",400,60));
        r2.addIngredient(new WeightedIngredient("meso",200,300));
        r2.addIngredient(new WeightedIngredient("pirinac",300,80));
      allRecipe.put("sarma",r2);


      Recipe r3 = new Recipe("palacinka", Recipe.RecipeLevel.MEDIUM);
      r3.addIngredient(new WeightedIngredient("jaja",5,10));
        r3.addIngredient(new WeightedIngredient("brasno",50,120));
        r3.addIngredient(new WeightedIngredient("krem",100,150));
        r3.addIngredient(new WeightedIngredient("secer",100,60));
        allRecipe.put("palacinka",r3);

        Recipe r4 = new Recipe("burek meso", Recipe.RecipeLevel.HARD);
        r4.addIngredient(new WeightedIngredient("meso",200,100));
        r4.addIngredient(new WeightedIngredient("kore",500,10));
        r4.addIngredient(new WeightedIngredient("jaja",5,10));
        allRecipe.put("burek meso",r4);

        Recipe r5 = new Recipe("kolac", Recipe.RecipeLevel.MEDIUM);
        r5.addIngredient(new WeightedIngredient("mleko",200,100));
        r5.addIngredient(new WeightedIngredient("brasno",500,10));
        r5.addIngredient(new WeightedIngredient("jaja",10,10));
        r5.addIngredient(new WeightedIngredient("secer",100,50));
        allRecipe.put("kolac",r5);



        Recipe r6 = new Recipe("punjena paprika", Recipe.RecipeLevel.HARD);
        r4.addIngredient(new WeightedIngredient("meso",200,100));
        r4.addIngredient(new WeightedIngredient("paprika",100,30));
        r4.addIngredient(new WeightedIngredient("pirinac",300,10));
        allRecipe.put("punjena paprika",r6);




        Recipe r7 = new Recipe("spagete", Recipe.RecipeLevel.EASY);
        r7.addIngredient(new WeightedIngredient("meso",200,100));
        r7.addIngredient(new WeightedIngredient("testenina",500,10));
        r7.addIngredient(new WeightedIngredient("sir",5,10));
        r7.addIngredient(new WeightedIngredient("paradajiz",5,10));
        allRecipe.put("spagete",r7);




        Recipe r8 = new Recipe("salata", Recipe.RecipeLevel.BEGINNER);
        r8.addIngredient(new WeightedIngredient("paprika",4,50));
        r8.addIngredient(new WeightedIngredient("sir",100,10));
        r8.addIngredient(new WeightedIngredient("paradajiz",4,60));
        r8.addIngredient(new WeightedIngredient("krastavac",4,40));
        allRecipe.put("salata",r8);


    }


//    public static boolean hasIngredient(String name) {
//        return allIngredients.containsKey(name);
//    }

    public static WeightedIngredient getIngredient(String name) {
        return allIngredients.get(name);
    }

//    public static boolean hasRecipe(String name) {
//        return allRecipe.containsKey(name);
//    }

    public static Recipe getRecipe(String name) {
        return allRecipe.get(name);
    }




    public static String writeRecipe() {
        StringBuilder recipe = new StringBuilder();
        for (String name : Database.allRecipe.keySet()) {
            recipe.append(name).append("---->").append(Database.getRecipe(name).getPrice()).append(" din.\n").append(" ").append(Database.getRecipe(name).toString()).append("\n\n");
        }
        return recipe.toString();
    }










    private static final List<Recipe> favorites = new ArrayList<>();


    public static Recipe getFavoriteRecipe(String name) {
        for (var r : favorites) {
            if (name.equalsIgnoreCase(r.getRecipeName()))
                return r;
        }
        return null;
    }


    public static void addFavoriteRecipe(Recipe r) {
        if (!favorites.contains(r)) {
            favorites.add(r);
        }
    }
    public static void removeFavoriteRecipe(Recipe r ){
        if(!favorites.contains(r)){
            favorites.remove(r);
        }
    }


    public static List<Recipe> allFavoriteRecipes() {
        return new ArrayList<>(favorites);
    }

    public static List<WeightedIngredient> getAllIngredients() {
        return new ArrayList<>(allIngredients.values());
    }

    public static List<Recipe> getAllRecipes() {
        return new ArrayList<>(allRecipe.values());
    }
















//    public static WeightedIngredient getIngredient(String nameIng) {
//        for (var ing : allIngredients) {
//            if (ing.getIngredientName().equalsIgnoreCase(nameIng))
//                return ing;
//        }
//        return null;
//    }
//
//

//
//    public static Recipe getRecipe(String nameRecipe) {
//        for (var r : allRecipes) {
//            if (nameRecipe.equals(r.getRecipeName()))
//                return r;
//        }
//        return null;
//    }
//
//

//
//
//    public static void deleteIngr(WeightedIngredient x) {
//        if (!allIngredients.contains(x)) {
//            allIngredients.remove(x);
//        } else {
//            for (var ing : allIngredients) {
//                if (x.getIngredientName().equalsIgnoreCase(ing.getIngredientName())) {
//                    ing.setWeight(ing.getWeight() - x.getWeight());
//                }
//            }
//        }
//    }
//
//
//    public static void deleteRecipe(String nameRecipe) {
//        for (var r : allRecipes) {
//            if (nameRecipe.equalsIgnoreCase(r.getRecipeName())) {
//                allRecipes.remove(r);
//            }
//        }
//    }
//
//    public static void addIngrs(WeightedIngredient x) {
//        if (!allIngredients.contains(x)) {
//            allIngredients.add(x);
//        } else {
//            for (var ing : allIngredients) {
//                if (x.getIngredientName().equalsIgnoreCase(ing.getIngredientName())) {
//                    ing.setWeight(ing.getWeight() + x.getWeight());
//                }
//            }
//        }
//    }
//
//    public static void addRecipe(Recipe r) {
//        if (!allRecipes.contains(r)) {
//            allRecipes.add(r);
//        }
//    }
//
//
//    public static void setAllIngredients() {
//        WeightedIngredient i1 = new WeightedIngredient("sir", 0.3, 150);
//        WeightedIngredient i2 = new WeightedIngredient("brasno", 0.2, 100);
//        WeightedIngredient i3 = new WeightedIngredient("mleko", 0.05, 180);
//        WeightedIngredient i4 = new WeightedIngredient("jaja", 3, 10);
//        WeightedIngredient i5 = new WeightedIngredient("", 0.3, 150);
//        WeightedIngredient i6 = new WeightedIngredient("brasno", 0.2, 100);
//        WeightedIngredient i7 = new WeightedIngredient("zejtin", 0.05, 180);
//        WeightedIngredient i8 = new WeightedIngredient("jaja", 3, 10);
//        WeightedIngredient i9 = new WeightedIngredient("jogurt", 0.3, 150);
//        WeightedIngredient i10 = new WeightedIngredient("brasno", 0.2, 100);
//
//        allIngredients.add(i1);
//        allIngredients.add(i2);
//        allIngredients.add(i3);
//        allIngredients.add(i4);
//        allIngredients.add(i5);
//        allIngredients.add(i6);
//        allIngredients.add(i7);
//        allIngredients.add(i8);
//    }

}


