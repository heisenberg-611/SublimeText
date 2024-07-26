#include<iostream>
#define nl endl;
using namespace std;

int main(){
    int count=0;
    string a;
    cin >> a;
    for(int i = 0; i<a.length();i++){
        if(a[i]=='1'){
            count++;
        }
    }
    cout<<count<<nl;
}