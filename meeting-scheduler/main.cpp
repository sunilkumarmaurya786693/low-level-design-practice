#include<bits/stdc++.h>
#include "Room.h"
#include "Meeting.h"
#include "Scheduler.h"
using namespace std;

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


