#include <iostream>
#define target 42
using namespace std;

int main() {
    int n;
    cin >> n;

    int count=0;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (x==target) count++;
    }

    cout << count << endl;

    return EXIT_SUCCESS;
}