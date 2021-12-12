#include<bits/stdc++.h>
// #include "Meeting.h"
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
