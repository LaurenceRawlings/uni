public class Second {
    public static void main(String[] args){
        Car car1 = new Car(12000, 1.1, 20, 125000, 100, 100000);
        Car car2 = new Car(18000, 1.4, 35, 250000, 200, 100000);

        System.out.println("Car 1 cost: £" + car1.Calculate());
        System.out.println("Car 2 cost: £" + car2.Calculate());
    }
}

