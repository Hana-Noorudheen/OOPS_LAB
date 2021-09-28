repeat
{
    read the next char from the infix string;

    if(operand )
     write it to the postfix string;

     if(parantheses '(')
      push it to the stack;

      if(parantheses ')')
      {
          while(!emptyStack)
          {
              pop the item;
              if (item == '(')
              break;
              else
              write it to the output string;
          }
      }

      if operator(opThis)
      {
          if(emptyStack)
          push opThis;
          else
          {
              while(!emptyStack)
              {
                  pop the item ; // item = 
                  if(item=='(')
                  push it;
                  else
                  {
                      if(opTop<opThis)
                      push opTop;

                       if(opTop>=opThis)
                      write opTop to the out put;

                  }

                  if (opTop<opThis or if item == '(')
                  break;
              }
              push opThis;
          }
      }
}until all character are empty

while(!emptystack)
{
    pop item;
    write it to the output string;
}