#include <iostream>
<<<<<<< HEAD
#include <iomanip>
#include <string>

using namespace std;

class love{
    public:
        int price;
        string name;
    love(){
        price = 0;
        name = "hello";
    }
};
class hate{
	public:
		string haua;
	hate(){
		haua = "MP";
	}	
};
int main(){
    love love1;
	hate hate1;
	cout<<hate1.haua<<endl;
    cout<<love1.name<<endl;
}
=======
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
>>>>>>> 454da1d691d6e0426107909704ad5376254a73b6
