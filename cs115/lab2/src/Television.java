public class Television {

    private int channel, volume, serial;
    private boolean power;
    private static int currentSerial = 0;

    public Television(){
        channel = 0;
        volume = 50;
        power = false;
        serial = currentSerial++;
    }

    public int getChannel(){
        if(hasPower()){
            return channel;
        }
        System.out.println("The TV is off.");
        return 0;
    }

    public int getVolume(){
        if(hasPower()){
            return volume;
        }
        System.out.println("The TV is off.");
        return 0;

    }




    public int getSerial(){
        return serial;
    }

    public boolean hasPower(){
        return power;
    }


    public void setChannel(int channel){
        if(hasPower()){
            this.channel = channel;
        }else{
            System.out.println("The TV is off.");
        }
    }


    public void togglePower(){
        power = !power;
    }

    public void volumeUp(){
        if(hasPower()){
            if(volume <= 95){
                volume += 5;
            }
        }else{
            System.out.println("The TV is off.");
        }

    }

    public void volumeDown(){
        if(hasPower()){
            if(volume >= 5){
                volume -= 5;
            }
        }else{
            System.out.println("The TV is off.");
        }

    }

    public void channelUp(){
        if(hasPower()){
            channel++;
        }else{
            System.out.println("The TV is off.");
        }

    }

    public void channelDown(){
        if(hasPower()){
            channel--;
        }else{
            System.out.println("The TV is off.");
        }

    }

}
