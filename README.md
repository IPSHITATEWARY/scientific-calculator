🧮 Scientific Calculator (Java Swing)

A GUI-based Scientific Calculator built using Java Swing.
This project supports basic arithmetic operations as well as scientific functions such as sin, cos, etc., and demonstrates how mathematical expressions can be parsed and evaluated using stack-based algorithms.

🚀 Project Overview

This calculator allows users to enter mathematical expressions through a graphical interface.
The system internally converts the infix expression (human-readable) into postfix notation (machine-friendly) and then evaluates the result using stack operations.

The architecture is divided into three main components:

🎨 CalculatorUI – User Interface

🧠 ExpressionParser – Expression conversion engine

⚙️ Evaluator – Result calculation engine

🧩 Project Architecture
🎨 1. CalculatorUI Class (User Interface)

Handles user interaction and display.

Features

Built with javax.swing

Uses JFrame, JButton, and display fields

Buttons for:

Numbers 0–9

Operators + - * /

Scientific functions sin, cos

Parentheses

Equals =

Role

Captures the full expression string entered by the user.

Sends the expression to the ExpressionParser for processing.

Example user input:

sin(30) + 5 * 2
🧠 2. ExpressionParser Class (Core Engine)

Responsible for converting infix expressions to postfix notation.

The parser uses two stacks:

Stack	Purpose
Operator Stack	Stores operators and functions
Output Queue	Builds the postfix expression
⚙️ How the Parser Works

1️⃣ Read the infix expression token by token

2️⃣ If the token is a number

Add it to the postfix output

3️⃣ If the token is an operator or function

Pop operators from the stack
until a lower precedence operator appears

4️⃣ Push the current operator onto the stack

5️⃣ Handle parentheses to maintain grouping

Example conversion:

Infix:   5 + 3 * 2
Postfix: 5 3 2 * +

⚙️ 3. Evaluator Class (Result Calculation)

This class evaluates the generated Postfix expression.

It uses a single Value Stack.

🧮 Evaluation Process

1️⃣ Read the postfix expression token by token

2️⃣ If the token is a number

Push it onto the Value Stack

3️⃣ If the token is an operator

Pop required operands
Perform calculation
Push result back to stack

Example:

Postfix: 5 3 2 * +

Step 1 → Push 5  
Step 2 → Push 3  
Step 3 → Push 2  
Step 4 → 3 * 2 = 6  
Step 5 → 5 + 6 = 11

Final result → 11


🛠 Tech Stack
Technology	Purpose
Java (Core)	Main programming language
Java Swing	GUI development
Stack Data Structure	Expression parsing and evaluation
Infix → Postfix Algorithm	Expression conversion
▶️ How to Run

Clone the repository

git clone https://github.com/IPSHITATEWARY/scientific-calculator.git

Navigate to the project folder

cd scientific-calculator

Compile the program

javac CalculatorUI.java

Run the application

java CalculatorUI
🎯 Learning Concepts

This project demonstrates:

GUI development with Java Swing

Stack data structure

Infix to Postfix conversion

Expression parsing algorithms

Scientific function handling

👩‍💻 Author

Ipshita Tewary

GitHub
👉 https://github.com/IPSHITATEWARY
The final value remaining on the stack is the result. https://github.com/IPSHITATEWARY/scientific-calculator/blob/main/Screenshot%202025-10-24%20075543.pn
