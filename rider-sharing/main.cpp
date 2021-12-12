#include<bits/stdc++.h>
using namespace std;

enum RideStatus {
    IDLE,
    CREATED,
    WITHDRAWN,
    COMPLETED
};

class Ride{
    private:
        int id;
        int origin;
        int destination;
        int noOfSeat;
        RideStatus rideStatus;


    public:
        static const int AMOUNT_PER_KM=20;
        Ride();
        int calculateFare(bool);

        int getId()
        {
            return this->id;
        }

        void setId(int id)
        {
            this->id = id;
        }

        int getorigin()
        {
            return this->origin;
        }

        void setorigin(int origin)
        {
            this->origin = origin;
        }


        int getDestination()
        {
            return this->destination;
        }

        void setDestination(int destination)
        {
            this->destination = destination;
        }

        int getNoOfSeat()
        {
            return this->noOfSeat;
        }

        void setNoOfSeat(int noOfSeat)
        {
            this->noOfSeat = noOfSeat;
        }

        RideStatus getRideStatus()
        {
            return this->rideStatus;
        }

        void setRideStatus(RideStatus rideStatus)
        {
            this->rideStatus = rideStatus;
        }

};



Ride :: Ride()
{
    id = 0;
    origin = 0;
    destination = 0;
    noOfSeat = 0;
    rideStatus = IDLE;
}

int Ride:: calculateFare(bool isPriorityRider)
{
    int distance = destination- origin;
    double payscale = 1;
    if(isPriorityRider)
        payscale = noOfSeat>1 ? 0.5 : 0.75; 
    else
        payscale = noOfSeat>1?0.75:1;

    int amount = (int)(distance*noOfSeat*AMOUNT_PER_KM*payscale);
    return amount;
}
class Person {
    public:
       string name;
};

class Rider :private Person{
    private:
        vector<Ride>completedRides;
        Ride currentRide;
    public:
        Rider(string);
        void createRide(int,int,int,int);
        void updateRide(int,int,int,int);
        void withDrawRide(int);
        int closeRide();
        
};
Rider::Rider(string name){
    this->name=name;
}
void Rider::createRide(int id,int origin,int dest,int noOfSeats){
    if(origin>=dest){
        cout<<"wrong value origin should be less than dest\n";
        return ;
    }
    currentRide.setId(id);
    currentRide.setorigin(origin);
    currentRide.setDestination(dest);
    currentRide.setNoOfSeat(noOfSeats);
    currentRide.setRideStatus(RideStatus:: CREATED);
}

void Rider:: updateRide(int id,int origin, int dest, int seats) {
    if(currentRide.getRideStatus() == RideStatus::    WITHDRAWN){
        cout<<"Can not update Ride because ride is already withdrawn\n";
        return;
    }
    if(currentRide.getRideStatus() == RideStatus:: COMPLETED){
        cout<<"can not update ride because ride is already completed\n";
        return;
    }

    createRide(id,origin,dest,seats);
}

void Rider:: withDrawRide(int id){
    if(currentRide.getId()!=id){
        cout<<"wrong ride Id as input. Can'not withdraw ride\n";
        return;
    }
    if(currentRide.getRideStatus()!=RideStatus::CREATED){
        cout<<"Ride was not in progress. Can not withraw ride\n";
        return;
    }

    currentRide.setRideStatus(RideStatus::WITHDRAWN);
}
int Rider::closeRide(){
    if(currentRide.getRideStatus()!=RideStatus::CREATED){
        cout<<"Ride is not in progress, so can not close ride\n";
        return 0;
    }
    currentRide.setRideStatus(RideStatus::COMPLETED);
    completedRides.push_back(currentRide);
    return currentRide.calculateFare(completedRides.size()>=10);
}

class Driver: private Person{
    public:
        Driver(string);
};

Driver::Driver(string name){
    this->name = name;
}

int main(){
    Rider rider("Sunil");
    Driver driver("Akash");

    rider.createRide(1,50,60,1);
    cout<<rider.closeRide()<<endl;
    rider.updateRide(1,50,60,2);
    cout<<rider.closeRide()<<endl;

    cout<<"************************************************************************\n";

    rider.createRide(1,50,60,1);
    rider.withDrawRide(1);
    rider.updateRide(1,50,60,2);
    cout<<rider.closeRide()<<endl;

    cout<<"************************************************************************\n";

    rider.createRide(1,50,60,1);
    rider.updateRide(1,50,60,2);
    cout<<rider.closeRide()<<endl;

    return 0;
}


