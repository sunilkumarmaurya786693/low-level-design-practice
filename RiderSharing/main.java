package RiderSharing;

public class main {
    public static void main(String args[]){
        RiderService r = new RiderService("sunil");
        r.addDriver("Mahesh");
        r.addDriver("Suresh");
        r.addDriver("Alok");

        r.createRide(50,60,1);
        r.closeRide();
        r.updateRide(50,70,2);
        r.closeRide();

        System.out.println("***************************************************************");
        r.createRide(50,60,1);
        r.withDrawRide();
        r.updateRide(50,60,2);
        r.closeRide();

        System.out.println("***************************************************************");
        r.createRide(50,60,1);
        r.updateRide(50,60,2);
        r.closeRide();

    }
}
