package RiderSharing;

import java.util.UUID;

public class Ride {
    private final static int AMOUNT_PER_KM=20;
    private String id;
    private int origin;
    private int destination;
    private int noOfPeopele;
    private RideStatus status;
    private int Charge;
    private Driver driver;


    public Ride(int origin, int destination, int noOfPeopele) {
        this.id = UUID.randomUUID().toString();
        this.origin = origin;
        this.destination = destination;
        this.noOfPeopele = noOfPeopele;
        this.status=RideStatus.IDLE;
        this.Charge=0;
    }

    public String getId() {
        return id;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }

    public int getNoOfPeopele() {
        return noOfPeopele;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public int getCharge() {
        return Charge;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int calculateFair(Ride ride, Rider rider){
        int distance = Math.abs(ride.destination-ride.origin);
        double discount = 1;
        if(rider.isPrefferedRider()){
            discount = ride.noOfPeopele >=2 ? 0.5 :0.75;
        }else{
            discount = ride.noOfPeopele >=2 ? 0.75:1;
        }
        int totalCharge = distance*AMOUNT_PER_KM;
        ride.Charge=totalCharge;
        ride.status=RideStatus.COMPLETED;
        ride.driver.setDriverStatus(DriverStatus.FREE);
        return totalCharge;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setNoOfPeopele(int noOfPeopele) {
        this.noOfPeopele = noOfPeopele;
    }

}
