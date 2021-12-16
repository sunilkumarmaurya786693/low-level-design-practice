package RiderSharing;

import java.util.Random;

public class Driver extends Person{
    private DriverStatus driverStatus;

    public Driver(String name) {
        super(name);
        this.driverStatus = DriverStatus.FREE;
    }

    public boolean IsAcceptRide(Ride ride){
        boolean isAccept = new Random().nextBoolean();
        System.out.println("isAccepted"+isAccept);
        if(isAccept && driverStatus==DriverStatus.FREE){
            driverStatus=DriverStatus.BUSY;
            return true;
        }
        return false;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }
}
