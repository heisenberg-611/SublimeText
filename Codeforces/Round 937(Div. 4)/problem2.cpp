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
#include<iomanip>
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
    	string s; // Input time in 24-hour format (hh:mm)
        cin >> s;

        int hour = stoi(s.substr(0, 2));
        int minute = stoi(s.substr(3, 2));

        string period; // AM or PM

        if (hour >= 12) {
            period = "PM";
            if (hour > 12) {
                hour -= 12;
            }
        } else {
            period = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }

        cout << setw(2) << setfill('0') << hour << ":" << setw(2) << setfill('0') << minute << " " << period << endl;
    }
}