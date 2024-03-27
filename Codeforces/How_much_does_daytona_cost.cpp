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
    	int n,k;
    	cin>>n>>k;
    	vi arr(n);
    	for(int i = 0; i<n; i++){
            cin>>arr[i];
        }
        
        if(find(arr.begin(), arr.end(), k) != arr.end()){
        	cout<<"Yes"<<nl;
        }
        else{
        	cout<<"No"<<nl;
        }
    }
}