# include <iostream>
# include <cmath>

using namespace std;

int main() {

    string operation;
    double number1, number2;

    cout << "Enter First Number: ";
    cin >> number1;
    cout << "Enter operation (+, -, *, /): ";
    cin >> operation;
    cout << "Enter Second Number: ";
    cin >> number2;

    if (operation == "+") {
        cout << number1 + number2;
    } else if (operation == "-") {
        cout << number1 - number2;
    }
    else if (operation == "*") {
        cout << number1 * number2;
    }
    else if (operation == "/") {
        cout << number1 / number2;
    }
    else {
        cout << "Not a recognized operation!";
    }

    return 0;
}