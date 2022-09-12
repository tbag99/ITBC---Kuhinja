public interface Priceable {
    default double getPrice(){
        return 0.0;
    }
}
