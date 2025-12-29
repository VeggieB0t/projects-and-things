#include <iostream>
using namespace std;

void ReverseIt(char* o, char* r) {
    // Find end of string
    char* end = o;
    while (*end != '\0') {
        end++;
    }

    // Move back to start of last word
    char* lastWordStart = end;
    while (lastWordStart > o && *(lastWordStart - 1) != ' ') {
        lastWordStart--;
    }

    // Copy last word
    char* p = lastWordStart;
    while (*p != '\0') {
        *r++ = *p++;
    }

    // Add comma + space
    *r++ = ',';
    *r++ = ' ';

    // Copy everything from start up to just before last word
    p = o;
    while (p < lastWordStart - 1) { // leave out trailing space
        *r++ = *p++;
    }

    *r = '\0'; // terminate
}

int main() {
    char original[] = "Conan The Barbarian";
    char reversed[100];

    ReverseIt(original, reversed);

    cout << original << " reversed is " << reversed << endl;
    return 0;
}
