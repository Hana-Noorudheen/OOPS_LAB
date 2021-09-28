repeat

read the next char from postfix string;

if(operand)
push it to the stack;

if (operator)
pop the top two operands from the stack;

Apply the operator to them;
push the result;
until the end of string;
pop the final answer




boolean bool1 = Character.isLetterOrDigit(c1); 