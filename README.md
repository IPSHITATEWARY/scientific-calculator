# scientific-calculator
1. The CalculatorUI Class (User Interface)
This handles user input and displays results.

Usage: Uses javax.swing.JFrame and JButtons for numbers, operators (+, -, *, /), scientific functions (sin, cos), and the equals button (=).

Function: Captures the full expression string entered by the user.

2. The ExpressionParser Class (The Core Engine)
This class contains the logic to convert the infix expression into postfix notation.

Concept: Uses two stacks: one for operands (numbers) and one for operators.

Usage:

Read the infix expression token by token.

If the token is a number, output it (start the postfix string).

If the token is an operator or function:

Pop operators from the operator stack onto the output until a lower precedence operator is found.

Push the current operator onto the stack.

Handles parentheses to enforce grouping.

3. The Evaluator Class (Result Calculation)
This class takes the generated Postfix expression and calculates the final result.

Concept: Uses a single Value Stack.

Usage:

Read the Postfix expression token by token.

If the token is a number, push it onto the Value Stack.

If the token is an operator (e.g., *):

Pop the required number of operands (usually two for binary operators, one for functions) from the stack.

Perform the calculation.

Push the result back onto the stack.

The final value remaining on the stack is the result.
https://github.com/IPSHITATEWARY/scientific-calculator/blob/main/Screenshot%202025-10-24%20075543.png
