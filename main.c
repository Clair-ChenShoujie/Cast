#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// Function prototypes
int evaluate_expression(char* expression);
void convert_to_radix(int value, int radix);

int main() {
    char expression[81];
    int radix, value;

    // Prompt user to enter an arithmetic expression
    printf("Enter an expression: ");
    fflush(stdout);
    fgets(expression, 81, stdin);

    // Evaluate the expression
    value = evaluate_expression(expression);
    printf("Value = %d\n", value);
    fflush(stdout);

    // Prompt user to enter a radix and convert the value to the equivalent radix
    printf("Enter radix: ");
    fflush(stdout);
    scanf_s("%d", &radix);
    printf("Answer = ");
    fflush(stdout);
    convert_to_radix(value, radix);

    return 0;
}

// Evaluates an arithmetic expression and returns the result
int evaluate_expression(char* expression) {
    int result = 0, num = 0, prev_op = '+';
    size_t len = strlen(expression);

    for (int i = 0; i < len; i++) {
        char c = expression[i];

        if (isdigit(c)) {
            num = num * 10 + (c - '0');
        }
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            // Apply previous operator to result and reset num
            switch (prev_op) {
            case '+': result += num; break;
            case '-': result -= num; break;
            case '*': result *= num; break;
            case '/': result /= num; break;
            }
            num = 0;
            prev_op = c;
        }
    }

    // Apply last operator to result
    switch (prev_op) {
    case '+': result += num; break;
    case '-': result -= num; break;
    case '*': result *= num; break;
    case '/': result /= num; break;
    }

    return result;
}

// Converts a decimal value to the specified radix and prints the result
void convert_to_radix(int value, int radix) {
    char digits[] = "0123456789ABCDEF";
    int digit, negative = 0;

    if (value < 0) {
        negative = 1;
        value = -value;
    }

    // Convert to radix r by repeatedly dividing by r and printing the remainders
    if (value == 0) {
        printf("0");
    }
    else {
        while (value > 0) {
            digit = value % radix;
            value /= radix;
            printf("%c", digits[digit]);
        }
    }

    if (negative) {
        printf("-");
    }

    printf("\n");
}
