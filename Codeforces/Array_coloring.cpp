#include<bits/stdc++.h>
using namespace std;
#define len(x) int((x).size())
#define ll long long
#define ld long double
#define pi pair<int,int>
#define nl '\n';
#define vi vector<int>
void solve() {
	int n;
    cin>>n;
    
    vi arr(n);
    for(int i = 0; i<n; i++){
        cin>>arr[i];
    }
    
    int odd_count = 0;
    
    for(int i=0; i<n; i++){
    	if(arr[i]%2 == 1){
    		odd_count++;
    	}
    }
    
    if(odd_count % 2 == 0){
    	cout<<"Yes"<<nl;
    }
    else{
    	cout<<"No"<<nl;
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}