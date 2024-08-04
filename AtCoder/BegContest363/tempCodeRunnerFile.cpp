#include <bits/stdc++.h>
#include <iostream>
using namespace std;
#define nl endl;
int main()
{
    int count = 0;
    int n;
    int add;
    cin >> n;
    if (n >= 1 && n <= 299)
    {
        if (n >= 1 && n <= 99)
        {
            count = 1;
        }
        if (n >= 100 && n <= 199)
        {
            count = 2;
        }
        if (n >= 200 && n <= 299)
        {
            count = 3;
        }
        if (n >= 300 && n <= 399)
        {
            count = 4;
        }
        if (count == 1)
        {
            add = 99 - n;
            cout << add << nl;
        }
        else if (count == 2)
        {
            add = 200 - n;
            cout << add << nl;
        }
        else if (count == 3)
        {
            add = 300 - n;
            cout << add << nl;
        }
    }
    return 0;
}
