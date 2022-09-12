public class WeightedIngredient extends Ingredient {
    private double weight;
    private double pricePerUnit;

    WeightedIngredient() {

    }


    public WeightedIngredient(String ingredientName, double weight, double pricePerUnit) {
        super(ingredientName);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
      Database.addIngredient(this);
    }

    public double getWeight() {
        return this.weight;
    }

    public double setWeight(double weight) {

//        if(this.weight < 0){
//            this.weight = 0;}
       return this.weight  = weight;

    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public WeightedIngredient subtractWeight(double x)
    {
        weight -= x;
        return this;
    }

    @Override
    public double getPrice() {
        return getWeight() * getPricePerUnit();

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAmount " + this.weight;
    }
}
