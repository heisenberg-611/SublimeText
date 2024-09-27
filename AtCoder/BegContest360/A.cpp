#include <iostream>
using namespace std;
int main() {
    string S;
    cin >> S;  
    bool a = false;
    for (int i = 0; i < 3; i++) {
        if (S[i] == 'R' && S[i+2] == 'M') {
            a = true;
        } else if(S[i+1] == 'R' && S[i+2] == 'M') {
            a = true;
        } else if(S[i] == 'R' && S[i+1] == 'M') {
            a = true;
        }
    }
    if(a==true){
        cout<<"Yes"<<endl;
    } else {
        cout<<"No"<<endl;
    }
}