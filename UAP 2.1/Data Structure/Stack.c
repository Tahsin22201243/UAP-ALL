#include <stdio.h>
int main ()
{

    int N,option,value;
    printf("Enter the size: ");
    scanf("%d",&N);//take stack size from the user as input

    int stack[N];//declare the stack of that specified size
    int top = -1;//declare a variable named as top, initially the value of top will be -1
    while(1)
    {
        printf("\nType..\n1 to push\n2 to pop\n3 to check if the stack is Empty\n4 to check the stack is Full\n0 to exit\n");
        scanf("%d", &option);

        if(option==1)
        {
            if(top==N-1)
            {
                printf("Over Flow");
            }
            else
            {
                printf("Enter the value: ");
                scanf("%d", &value);
                top++;
                stack[top] = value;
                for(int i=0; i<=top; i++)
                    printf("the Value of %d elemrnt is %d\n",i, stack[i]);
            }
            //If Top = maximum size of the stack then Print: Overflow and Return.
            //else ask user what value to push, name it as “push”
            //insert the specified number in the “top”-th index of the stack
            //increment the value of top by 1
            //print the stack
        }
        else if(option==2)
        {
            if(top==-1)
            {
                printf("Underflow");
            }
            else
            {
                stack[top]= '\0';
                top--;
                for(int i=0; i<=top; i++)
                    printf("the Value of %d elemrnt is %d\n",i, stack[i]);
            }

            //If top = -1 then Print: Underflow and Return.
            //else decrement the value of top by 1
            //insert a null in the “top”-th index
            //print the stack
        }
        else if(option==3)
        {
            if(top==-1)
                printf("stack is empty");
            else
                printf("stack is not empty");
            //return true(1) if stack is empty, false(0) otherwise
        }
        else if(option==4)
        {
            if(top==N-1)
                printf("stack is full");
            else
                printf("stack is not full");
            //return true(1) if stack is Full, false(0) otherwise
        }
        else if(option==0)
        {
            return ;
        }

        else
            printf("Invalid input.\n");
    }
    return 0;
}
