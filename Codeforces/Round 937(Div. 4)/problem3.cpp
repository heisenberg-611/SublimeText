#include<iostream>
#include<climits>
#include<algorithm>
#include<vector>
#include<map>
#include<unordered_map>
#include<set>
#include<unordered_set>
#include<stack>
#include<queue>
#include<math.h>
#include<stdlib.h>
#include<string.h>
#include<stdio.h>
#include<string>
#include<assert.h>
#include<utility>
#include<iomanip>
using namespace std;
#define len(x) int((x).size())
#define ll long long
#define ld long double
#define pi pair<int,int>
#define nl '\n';
#define vi vector<int>
int main()
{
    int t;
    cin>>t;
    while(t--){
    int n;
    cin>>n;
    for(int i=0; i<n;i++){
        int t = 2;
        char first='#';
        char second = '.';
        if(i%2==1){
            first='.';
            second='#';
        }
        while(t--){
            for(int j=0;j<n;j++){
                int p=2;
                while(p--){
                    if(j%2==0){
                        cout<<first;
                    }
                    else{
                        cout<<second;
                    }
                }
            }
            cout<<"\n";
        }
    }
    }
}
