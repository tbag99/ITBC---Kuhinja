public abstract class Ingredient implements Priceable {
    private int id;
    private static int nextId = 0;
    private String ingredientName;

    Ingredient() {

    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
        this.id = nextId++;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        " \n ingredientName='" + ingredientName;
    }
}
