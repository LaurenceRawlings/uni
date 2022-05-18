public class Main {

    public static void main(String[] args) {
        Television[] tvs = new Television[4];

        tvs[1] = new Television();
        tvs[0] = new Television();
        tvs[3] = new Television();

        tvs[2] = tvs[1];

        for(Television tv: tvs){
            if(!tv.hasPower()){
                tv.togglePower();
            }

            tv.setChannel(1);
        }

        tvs[1].channelUp();
        System.out.println(tvs[2].getChannel());
        //Tv at index 2 channel also incremented because it is a reference to the tv object at index 1
    }
}
