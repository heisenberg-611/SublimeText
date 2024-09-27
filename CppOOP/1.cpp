#include <iostream>
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
