#include <iostream>
using namespace std;

int main(){

    int x = 10;
    int y=15;
    int z = 20;

     int* ptr;

    
    ptr = &y;
     cout << "Value of x: " << x << endl;
    cout << "Address of x: " << &x << endl;
    cout << "Pointer stores: " << ptr << endl;
    cout << "Value at pointer: " << *ptr << endl; // dereference

    return 0;
}