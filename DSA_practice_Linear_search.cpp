#include <iostream>
using namespace std;

int linear_search(int A[], int n, int x){
    int i;
    for(i=0; i<n; i++){
        if(A[i] == x) {
            return i;
        }
    }
    i = -1;
    return i;
}

int main(){
    int n,x;
    cin>>n>>x;
    int A[]={1,2,3,4,4,6,6,66,7};
    int y = linear_search(A, n, x);
    cout<<y<<endl;
}