#include<stack>
#include<iostream>
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
#define nl '\n'
#define vi vector<int>
void solve() {
    int count = 1;
    int N;
    string S;
    cin >> N >> S;
    for(int i = 0; i < N; i++){
        if(S[i] == 'A' && S[i+1] != 'B' && S[i+2] == 'A'){
            count++;
        }
        else if(S[i] == 'B' && S[i+1]=='A' &&S[i+2] == 'B'){
            count++;
        }
    }
    cout << count % 1000000007 << endl;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    solve();
    return 0;
}