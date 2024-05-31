#include <stdio.h>
#include <iostream>

using namespace std;
#define nl endl;

int main()
{
    int x = 10;
    int *p1, *p2;
    p1 = &x;
    p2 = p1;
    printf(" %p", p2); /* print the address of x, not x's value! */
    printf(" %d", *p2); /* print the value of x */
    cout<<" "<<*p2<<nl;
    cout<<" "<<*p1<<nl;
    cout<<" "<<p2<<nl;;
    cout<<" "<<p1<<nl;
    return 0;
}