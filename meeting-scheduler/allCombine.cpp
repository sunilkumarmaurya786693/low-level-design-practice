#include<bits/stdc++.h>
using namespace std;

class Meeting;
typedef vector<Meeting>Calendar;

class Room {
    string name;
    Calendar calendar;

    public:
    Room(string);
    string GetName();
    Calendar GetCalendar();
    bool book(int, int);
};


class Meeting{
    private:
        int start;
        int end;
        Room room;
    public:
        int GetStart();
        int GetEnd();
        Meeting(int,int,Room);
};

class Scheduler{
    vector<Room>rooms;
    public:
        Scheduler(vector<Room>);
        string book(int,int);
};
bool Room:: book(int start, int end){
    for(Meeting m: calendar){
        int startTime = m.GetStart();
        int endTime = m.GetEnd();
        if((end>startTime && endTime>start) || (startTime>end && endTime<start)){
            //this mean two meeting time are collapse time interwal
            return false;
        }
    }
    Meeting meeting(start,end,*this);
    calendar.push_back(meeting);
    return true;
}
string Room:: GetName() {
return name;
}
Calendar Room:: GetCalendar() {
return calendar;
}
Room:: Room(string name){
    this->name=name;
}
Meeting:: Meeting(int start,int end,Room room1):room(room) //member list intialisation use here to intialise room class constructor
{ 
    this->start=start;
    this->end=end;

}
int Meeting:: GetStart() {
return start;
}
int Meeting:: GetEnd()  {
return end;
}

Scheduler:: Scheduler(vector<Room>room){
    this->rooms=room;
}
string Scheduler:: book(int start,int end){
    for(Room &room:rooms){   //if we do not use & here then it uses local copy and book a room but it does not change in actual rooms array
        bool flag = room.book(start,end);
        if(flag==true)
            return room.GetName();
    }
    return "No Room Available";
}
void test(){
    Room room1("Atlas");
    Room room2("Nexus");
    Room room3("Holycow");

    vector<Room>allRooms;
    allRooms.push_back(room1);
    allRooms.push_back(room2);
    allRooms.push_back(room3);

    Scheduler scheduler(allRooms);

    cout<<scheduler.book(2,5)<<"\n";
    cout<<scheduler.book(2,5)<<"\n";
    cout<<scheduler.book(2,5)<<"\n";
    cout<<scheduler.book(2,5)<<"\n";
    cout<<scheduler.book(1,2)<<"\n";
    cout<<scheduler.book(6,24)<<"\n";
    cout<<scheduler.book(1,25)<<"\n";

}
int main(){
    test();
    return 0;
}


