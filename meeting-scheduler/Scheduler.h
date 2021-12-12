#include<bits/stdc++.h>
#include "Room.h"
using namespace std;

class Scheduler{
    vector<Room>rooms;
    public:
        Scheduler(vector<Room>);
        string book(int,int);
};

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