package RiderSharing;

import java.util.LinkedList;
import java.util.List;

public class RiderService {
    private List<Driver>allDrivers;
    private Rider rider;
    private boolean isRideAccepted;

    public RiderService(String name) {
        allDrivers = new LinkedList<>();
        rider = new Rider(name);
        isRideAccepted= false;
    }

    public void addDriver(String name){
        Driver d = new Driver(name);
        allDrivers.add(d);
    }

    public void createRide(int origin, int destination, int noOfPeople){
        rider.createRide(origin,destination,noOfPeople);
        for(int i=0;i<allDrivers.size();i++){
            Driver d = allDrivers.get(i);
//            if(d.IsAcceptRide(rider.getCurrentRide())){
                System.out.println(d.getName()+" has accepted ride");
                rider.getCurrentRide().setDriver(d);
                rider.getCurrentRide().setStatus(RideStatus.ACCEPTEDBYDRIVER);
                isRideAccepted=true;
//                break;
//            }
        }
        if(isRideAccepted==false){
            rider.getCurrentRide().setStatus(RideStatus.NOACCEPTEDBYDRIVER);
        }
    }
    public void updateRide(int origin, int destination, int noofPeople){
        rider.updateRide(origin,destination,noofPeople);
    }
    public void withDrawRide(){
        rider.withdrawRide();
    }
    public void closeRide(){
        rider.closePride();
    }
}
