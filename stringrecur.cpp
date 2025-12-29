#include <iostream>
#include <string>
#include <sstream>
using namespace std; 

string reverseString(string str){
    if(str.length() <= 1){
        return str;
    }
    return reverseString(str.substr(1)) + str[0];
}

int main() {
    string str;
    cout << "Enter string: ";
    getline(cin, str);
    cout << "Reversed: " << reverseString(str) << endl;

    // Pause before exit
    cout << "\nPress Enter to exit...";
    cin.get();

    return 0;
}