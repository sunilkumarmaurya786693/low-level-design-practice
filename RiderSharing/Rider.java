package RiderSharing;

import java.util.LinkedList;
import java.util.List;

public class Rider extends Person{
    private List<Ride> AllRide;
    private Ride currentRide;
    private boolean isPrefferedRider;

    public Rider(String name) {
        super(name);
        this.AllRide = new LinkedList<>();
        this.isPrefferedRider = true;
    }

    public List<Ride> getAllRide() {
        return AllRide;
    }

    public void setAllRide(List<Ride> allRide) {
        AllRide = allRide;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public boolean isPrefferedRider() {
        return isPrefferedRider;
    }

    public void setPrefferedRider(boolean prefferedRider) {
        isPrefferedRider = prefferedRider;
    }

    public void createRide(int origin, int destination, int noOfPeople){
        //add in all ride
        Ride r = new Ride(origin,destination,noOfPeople);
        currentRide=r;
        AllRide.add(r);
    }

    public void updateRide(int origin, int destination, int noOfPeople){
        if(currentRide.getStatus()==RideStatus.COMPLETED || currentRide.getStatus()==RideStatus.WITHDRAW){
            System.out.println("Can not Update Ride because Ride is already close or withdraw");
            return ;
        }
        currentRide.setOrigin(origin);
        currentRide.setDestination(destination);
        currentRide.setNoOfPeopele(noOfPeople);

    }
    public int closePride(){
        if(currentRide.getStatus()==RideStatus.COMPLETED || currentRide.getStatus()==RideStatus.WITHDRAW || currentRide.getStatus()==RideStatus.NOACCEPTEDBYDRIVER){
            System.out.println("There is some problem in this Ride "+currentRide.getStatus());
            return 0;
        }
        int cost= currentRide.calculateFair(currentRide, this);
        System.out.println("Total cost of ride "+cost);
        return cost;
    }

    public void withdrawRide(){
        if(currentRide.getStatus()==RideStatus.COMPLETED || currentRide.getStatus()==RideStatus.WITHDRAW){
            System.out.println("Ride is already completed/Withdraw");
        }
        currentRide.setStatus(RideStatus.WITHDRAW);
        currentRide.getDriver().setDriverStatus(DriverStatus.FREE);

    }

}
