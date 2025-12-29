#include <iostream>
using namespace std;

int factorialHelper(int n, int acc) {
    if (n == 0) {
        return acc;
    }
    return factorialHelper(n - 1, n * acc);
}

int factorial(int n) {
    return factorialHelper(n, 1);
}

int main() {
    int num;

    cout << "Enter a number: ";
    cin >> num;

    if (num < 0) {
        cout << "Factorial can't be negative." << endl;
    } else {
        cout << "Factorial of " << num << " is " << factorial(num) << endl;
    }

    return 0;
}
