#include<bits/stdc++.h>
#include "Room.h"
using namespace std;

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
