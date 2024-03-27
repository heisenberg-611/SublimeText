#include<iostream>
#include<climits>
#include<algorithm>
#include<vector>
using namespace std;
#define len(x) int((x).size())
#define ll long long
#define ld long double
#define pi pair<int,int>
#define nl '\n';
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
    	int n;
    	cin >> n;
    	
    	if(n % 3 == 0){
    		cout<<"Second"<<nl;	 
    	}
    	else
    		cout<<"First"<<nl;
    }
}