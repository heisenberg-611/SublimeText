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
    	int board[10][10] = {
    		
    		
    		{1,1,1,1,1,1,1,1,1,1},
    		{1,2,2,2,2,2,2,2,2,1},
    		{1,2,3,3,3,3,3,3,2,1},
    		{1,2,3,4,4,4,4,3,2,1},
    		{1,2,3,4,5,5,4,3,2,1},
    		{1,2,3,4,5,5,4,3,2,1},
    		{1,2,3,4,4,4,4,3,2,1},
    		{1,2,3,3,3,3,3,3,2,1},
    		{1,2,2,2,2,2,2,2,2,1},
    		{1,1,1,1,1,1,1,1,1,1}
    		
    	};
    	int total = 0;
    	
    	for(int r=0; r<10; r++){
    		for(int c=0; c<10; c++){
    			char ch;
    			cin>>ch;
    			
    			if(ch!='.'){
    			    total += board[r][c];
    			}
    		}
    	}
    	cout<<total<<nl;
    }
}

























