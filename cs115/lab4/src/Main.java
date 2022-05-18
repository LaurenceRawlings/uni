import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //  Task 4.2
        DVD myDVD = new DVD (11.17 , 9 , 102 ,
                " Your Name " , " Makoto Shinkai " );
        Playable myPlayable = myDVD ;


        System.out.println(String.format("%s, %.2f, %.2f", myPlayable.getTitle(), myPlayable.getRuntime(), myPlayable.rentalCost()));

        DVD myDVD2 = (DVD)myPlayable;

        System.out.println(String.format("%s", myDVD2.getDirector()));


        /* Challenge
        ArrayList<Playable> playables = new ArrayList<>();

        playables.add(new DVD(4, 10, 2.3, "UP!", "Heft"));
        playables.add(new DVD(6, 8, 2.2, "Hugo", "Erna"));
        playables.add(new DVD(2, 1, 1.9, "Chonk", "Big"));

        playables.add(new CD(9, 20, 4.8, "NOW", "Various"));
        playables.add(new CD(12, 23, 5.8, "DnB", "Various"));
        playables.add(new CD(5, 11, 2.8, "Good Musik", "Cess"));

        for(Playable item:playables){
            System.out.println(String.format("%s, %.2f, %.2f", item.getTitle(), item.getRuntime(), item.rentalCost()));
        }
        */

    }
}
