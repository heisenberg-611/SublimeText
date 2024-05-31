#include<iostream>
using namespace std;

int binary_search(int A[], int n, int x){
    int left, right, mid;
    left = 0;
    right = n-1;

    while(left <= right){
        mid = (left+right) / 2;
        if(A[mid] == x) {
            return mid;
        }
        if(A[mid] < x){
            left = mid + 1;
        } else{
            right = mid - 1;
        }
    }
    return -1;
}

int main(){
    int A[]= {1,2,3,4,5,6,7,8,9,0};
    int b,x;
    cin>>b>>x;
    int k = binary_search(A, b, x);
    cout<<k<<endl;
}

