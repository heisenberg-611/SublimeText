#include <iostream>
#include <bitset>

using namespace std;

int main() {
  int t;
  cin >> t;

  while (t--) {
    int n;
    string s;
    cin >> n >> s;
    
    bool possible = false;

    if(s.find('0') == string::npos || s.find('1')==string::npos){
    	possible = true;
    }
    else{
    	for(int i = 0; i<n; i++){
    		if(s[i] == '0' && s[(i+1)%n]!='1'){
    			possible = true;
    			break;
        }
        else if(s[i] == '1' && s[(i+1)%n]!='0'){
        	possible = true;
        	break;
        }
    }
	}
	if(possible){
		cout<<"YES"<<endl;
	}
	else{
		cout<<"NO"<<endl;
	}
}
}
    	

