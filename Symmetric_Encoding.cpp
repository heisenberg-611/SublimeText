#include<iostream>
#include<cstdio>
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
void solve() {
    int len;
    cin>>len;
    string s, r;
    cin >> s;
    unordered_set<char> seen;

    for (char c : s) {
        if (seen.find(c) == seen.end()) {
            r += c;
            seen.insert(c);
        }
    }
    sort(r.begin(), r.end());
    
    string a;
    for (char c : s) {
        a += r[r.size() - 1 - r.find(c)];
    }
    
    cout<<a<<nl;
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