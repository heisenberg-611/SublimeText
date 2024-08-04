#include <iostream>
#include <stdio.h>
using namespace std;

class Book{
    public:
    int help;

    Book(){
        help=100;
    }
};
int main() {
    Book book;
    cout << book.help << endl;
    return 0;
}