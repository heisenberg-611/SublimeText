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
    	int a,b,c;
    	cin>>a>>b>>c;
    	if(a<b && b<c){
    		cout<<"STAIR"<<nl;
    	}
    	else if(a<b && c<b){
    		cout<<"PEAK"<<nl;
    	}
    	else{
    		cout<<"NONE"<<nl;
    	}
    }
}









