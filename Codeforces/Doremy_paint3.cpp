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
    cin >> t;
    while (t--)
    {
        int n;
        cin>>n;
        
        
        vi arr(n);
        for(int i = 0; i<n; i++){
            cin>>arr[i];
        }
        
        unordered_map<int,int>mp;
        bool yes = true;
        for(int i = 0; i<n; i++){
            mp[arr[i]]++;
            
            if(mp.size()>2){
                yes = false;
                break;
            }   
        }
        
        if(mp.size()==2){
            int f1 = begin(mp)-> second;
            
            if(f1 != n/2 && f1 != (n+1)/2){
                yes = false;
            }
        }
        
        if(yes){
            cout<<"Yes"<<nl;
        }
        else{
            cout<<"No"<<nl;
        }
    }
}