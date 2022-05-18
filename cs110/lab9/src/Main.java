public class Main {

    public static void main(String[] args) {
        Country newCountry = new Country("England", new HighPoint("Scafell Pike", 978));
        System.out.println(newCountry.toString());
    }
}
