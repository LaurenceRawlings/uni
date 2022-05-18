public class Car {

    double cost, fuelCost, mpg, serviceCost, interval,  mileage;

    public Car(double cost, double fuelCost, double mpg, double interval, double serviceCost, double mileage){
        this.cost = cost;
        this.fuelCost = fuelCost;
        this.mpg = mpg;
        this.interval = interval;
        this.serviceCost = serviceCost;
        this.mileage = mileage;
    }

    public double Calculate(){
        return cost + (mileage / interval) * serviceCost + (mileage / mpg);
    }
}
