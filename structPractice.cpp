#include <iostream>
using namespace std;

struct player{
    int age;
    string name;
    float height;
    int weight;
    int jersey_number;
    bool is_injured;
    string position;
    int goals;
    int assists;
};

int main(){
    struct player p1;
    struct player p2;
    p1.age = 25;
    p2.age = 26;
    cout<<p1.age<<endl;
    cout<<p2.age<<endl;
}