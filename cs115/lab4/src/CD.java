public class CD extends  Playable {
    protected String artist;

    /**
     * Create a new playable product.
     *
     * @param price    The price of the product in pounds.
     * @param numStock The amount of the product in stock.
     * @param runtime
     * @param title    The title of the product.
     */
    public CD(double price, int numStock, double runtime, String title, String artist) {
        super(price, numStock, runtime, title);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
