#include <stdio.h>
int main ()
{

    int N,option,value;
    printf("Enter the size: ");
    scanf("%d",&N);//take Queue size from the user as input

    int Queue[N];//declare the Queue of that specified size
    int rear = -1;
    int front = -1;
    int x=0;//declare a variable named as top, initially the value of top will be -1
    while(1)
    {
        printf("\nType..\n1 to push\n2 to pop\n3 to check if the Queue is Empty\n4 to check the Queue is Full\n0 to exit\n");
        scanf("%d", &option);

        if(option==1)
        {
            if(rear==N-1)
            {
                printf("Over Flow");
            }
            else
            {
                printf("Enter the value: ");
                scanf("%d", &value);
                rear++;
                Queue[rear] = value;
                for(int i=0; i<=rear; i++)
                    printf("the Value of %d elemrnt is %d\n",i, Queue[i]);
            }
            //If Top = maximum size of the Queue then Print: Overflow and Return.
            //else ask user what value to push, name it as “push”
            //insert the specified number in the “top”-th index of the Queue
            //increment the value of top by 1
            //print the Queue
        }
        else if(option==2)
        {
            if(front==rear)
            {
                printf("No element");
            }
            else
            {
                x++;
                front++;
                Queue[front]= '\0';
                for(int i=x; i<=rear; i++)
                    printf("the Value of %d elemrnt is %d\n",i, Queue[i]);
            }

            //If top = -1 then Print: Underflow and Return.
            //else decrement the value of top by 1
            //insert a null in the “top”-th index
            //print the Queue
        }
        else if(option==3)
        {
            if(rear==-1)
                printf("Queue is empty");
            else
                printf("Queue is not empty");
            //return true(1) if Queue is empty, false(0) otherwise
        }
        else if(option==4)
        {

            if(rear==N-1)
                printf("Queue is full");
            else
                printf("Queue is not full");
            //return true(1) if Queue is Full, false(0) otherwise
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
