#include<bits/stdc++.h>
#include<iostream>
using namespace std;

// Short forms
#define int                 long long
#define ll                  long long
#define lld                 long double
#define ull                 unsigned long long
#define endl                '\n'
#define ff                  first
#define ss                  second
#define all(x)              x.begin(), x.end()
#define sz(x)               (int)(x).size()
#define pb                  push_back
#define mp                  make_pair

// STLs
#define pii                 pair<int, int>
#define vi                  vector<int>
#define vll                 vector<ll>
#define vvi                 vector<vector<int>>
#define vvl                 vector<vector<ll>>

// Outputs
#define yes                 cout<<"YES"<<nl
#define no                  cout<<"NO"<<nl

// Constants
#define PI                  3.141592653589793238
#define INF                 LONG_LONG_MAX
#define MOD                 1e9+7

// Faster Input Output
#define FAST_IO             (ios_base:: sync_with_stdio(false),cin.tie(NULL));


void solve()
{
    int n;
    cin>>n;
    vi v;
    for(int i=0; i<n; ++i)
    {
        int x;
        cin>>x;
        if(x<0)
            x=x*-1;
        v.pb(x);
    }
    sort(all(v));
    cout<<v[0]<<endl;
}

int32_t main()
{
    FAST_IO;
    int TC = 1;
    //cin >> TC;
    while (TC--) solve();
}