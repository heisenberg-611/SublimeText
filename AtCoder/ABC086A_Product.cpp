#include<iostream>
#define nl endl;
using namespace std;

int main(){
    int a, b;
    int prod;
    cin >> a >> b;
    prod = a * b;
    if(prod % 2 == 0){
        cout<<"Even"<< nl;
    } else {
        cout << "Odd"<<nl;
    }
}