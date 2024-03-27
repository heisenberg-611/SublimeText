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
#include<bits/stdc++.h>
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
    	int n, m;
        cin>>n>>m;
        
        string x;
        cin>>x;
        
        string s;
        cin>>s;
        
        bool found = false;
        
        for(int i = 0; i<=5; i++){
            if(x.find(s) != string::npos){
                cout<<i<<nl;
                found = true;
                break;
            }
            x.append(x);
        }
        
        if(!found)cout<<-1<<nl;
    }
}
