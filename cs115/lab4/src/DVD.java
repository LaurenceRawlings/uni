public class DVD extends Playable {

    protected String director;

    /**
     * Create a new playable product.
     *
     * @param price    The price of the product in pounds.
     * @param numStock The amount of the product in stock.
     * @param runtime
     * @param title    The title of the product.
     */
    public DVD(double price, int numStock, double runtime, String title, String director) {
        super(price, numStock, runtime, title);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public double rentalCost(){
        return 1.20;
    }
}
