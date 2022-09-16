
import java.util.ArrayList;
import java.util.Scanner;

public class Aplication {


    public static void main(String[] args) {
        Database.recipeBase();
        Database.ingredientsBase();
        Scanner sc = new Scanner(System.in);
        int option = 1;
        Fridge fridge = new Fridge();
        while (option != 0) {


            System.out.print("1: Dodajte namirnicu u frizider \n");
            System.out.print("2: Smanjite kolicinu namirnice u frizideru \n");
            System.out.print("3: Izbrisite namirnicu iz frizidera \n");
          //  System.out.print("4: Koja sve jela mogu da se naprave sa namirnicama iz frizidera \n");
          //  System.out.print("5: Koja sve jela mogu da se naprave(Skalirana za 50%) \n");
            System.out.print("6: Napravi sva moguca jela \n");
            System.out.print("7: Napravi sva moguca jela skalirana za 50% \n");
            System.out.print("8: Koja sve jela mogu da se naprave za X dinara \n");
            System.out.print("9: Provera koja su sve jela X tezine \n");
          System.out.print("10: Kombinacija uslova 8 i 9 \n");
            System.out.print("11: Sortiraj recepte po tezini \n");
            System.out.print("12: Sortiraj recepte po ceni \n");

            System.out.print("13: Omiljeni recepti  \n");

            System.out.print("0: Kraj app \n");


            option = sc.nextInt();
            if (option == 1) {
                System.out.println("Unesite ime namirnice");

                var ingredient = Database.getIngredient(sc.next());
                fridge.addIngredient(ingredient);
                System.out.println(fridge);

            }


            if (option == 2) {
                System.out.println("Unesite ime namirnice cije kolicinu zelite da smanjite");
                var ingredient = Database.getIngredient(sc.next());
                System.out.println("Unesite kolicinu za koliko zelite da smanjite ");
                double x = sc.nextDouble();
                fridge.lowerWeightOfIngredient(x,ingredient.getIngredientName());
                System.out.println(fridge);
            }

            if (option == 3) {
                System.out.println("Unesite ime namirnice koju zelite da uklonite");
                var ingredient = Database.getIngredient(sc.next());
                fridge.removeIngredient(ingredient);
                System.out.println(fridge);


            }


            if (option == 6) {
                ArrayList<Recipe> madeMeals = new ArrayList<>();
                var recipes = Database.getAllRecipes();
                for (Recipe r : recipes) {
                    if (fridge.makeFood(r)) {
                        madeMeals.add(r);
                    }
                }
                if (madeMeals.size() > 0) {
                    System.out.println("Napravljena jela su: ");
                    for (Recipe r : madeMeals) {
                        System.out.println(r.toString());
                    }
                }
            }
            if (option == 7) {
                ArrayList<Recipe> madeMeals = new ArrayList<>();
                ArrayList<Recipe> scaledRecipes = new ArrayList<>();
                var recipes = Database.getAllRecipes();
                for (Recipe recipe : recipes) {
                    scaledRecipes.add(recipe.scaledRecipe(50));
                }
                for (Recipe recipe : scaledRecipes) {
                    if (fridge.makeFood(recipe)) {
                        madeMeals.add(recipe);
                    }
                }
                if (madeMeals.size() > 0) {
                    System.out.println("Napravljena jela: ");
                    for (Recipe recipe : madeMeals) {
                        System.out.println(Database.writeRecipe());
                    }
                }
            }
            if (option == 8) {
                System.out.println("Unesite cenu dinara izdvojeno za jela: ");
                double price = sc.nextDouble();
                var recipes = Database.getAllRecipes();
                System.out.println("moguca jela za cenu od " + price + " din");
                for (Recipe recipe : recipes) {
                    if (recipe.getPrice() < price) {
                        System.out.println(recipe);
                    }
                }
            }
            if (option == 9) {
                System.out.println("Unesite tezinu jela : Beginner(0)  Easy(1)  Medium(2) Hard(3) Pro(4) ");
                int diff = sc.nextInt();
                var recipes = Database.getAllRecipes();
                System.out.println("jela sa datom tezinom su ");
                for (Recipe recipe : recipes) {
                    if (recipe.getRecipeLevel().val == diff) {
                        System.out.println(recipe);
                    }
                }
            }


            if(option == 10) {
                System.out.println("Unesite zeljenu tezinu Beginner(0)  Easy(1)  Medium(2) Hard(3) Pro(4) ");
                int diff = sc.nextInt();
                System.out.println("Unesite zeljenu cenu");
                double price = sc.nextDouble();
                var recipes = Database.getAllRecipes();
                System.out.println("jela sa datom tezinom i  cenom su  ");
                for (Recipe recipe : recipes) {
                    if (recipe.getRecipeLevel().val == diff && recipe.getPrice() < price) {
                        System.out.println(recipe);
                    }
                }
            }
            if(option == 11){
                Database.sortedByDiff();
            }

            if(option == 12){
                Database.sortedByPrice();
            }


            if (option == 13) {
                System.out.print("14: Dodajte recept u omiljeni recept \n");
                System.out.print("15: Sklonite recept iz omiljenih recept \n");
                option = sc.nextInt();
                if (option == 14) {
                    System.out.println(Database.getAllRecipes());
                    System.out.println("Izaberite ime recepta koji zelite da dodate");
                    String s = sc.next();
                    var allRecepies = Database.getAllRecipes();

                    for (var r : allRecepies) {
                        if (r.getRecipeName().equalsIgnoreCase(s)) {
                            Database.addFavoriteRecipe(r);
                            for (var recipe : Database.allFavoriteRecipes()) {
                                System.out.println(recipe);
                            }
                        }
                    }
                }
                if (option == 15) {
                    var allRecepies = Database.getAllRecipes();
                    System.out.println(Database.getAllRecipes());
                    System.out.println("Izaberite ime recepta koji zelite da uklonite");
                    String s = sc.next();
                    for (var r : allRecepies) {
                        if (r.getRecipeName().equalsIgnoreCase(s)) {
                            Database.removeFavoriteRecipe(r);
                            for (var recipe : Database.allFavoriteRecipes()) {
                                System.out.println(recipe);
                            }
                        }
                    }


                }



                }
                if (option == 0) {
                    break;
                }
            }
        }
    }











