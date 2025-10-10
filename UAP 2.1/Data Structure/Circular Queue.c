#include <stdio.h>

int main()
{
    int N, option, value;
    printf("Enter the size: ");
    scanf("%d", &N); // Take Queue size from the user as input

    int Queue[N]; // Declare the Queue of that specified size
    int rear = -1;
    int front = -1;

    while (1)
    {
        printf("\nType..\n1 to push\n2 to pop\n3 to check if the Queue is Empty\n4 to check if the Queue is Full\n0 to exit\n");
        scanf("%d", &option);

        if (option == 1)
        {
            if ((rear + 1) % N == front)
            {
                printf("Overflow\n");
            }
            else
            {
                printf("Enter the value: ");
                scanf("%d", &value);
                rear = (rear + 1) % N;
                Queue[rear] = value;
                if (front == -1)
                    front = 0; // Adjust front if it's -1
                printf("Value %d enqueued successfully.\n", value);
            }

        }
        else if (option == 2)
        {
            if (front == -1)
            {
                printf("Underflow\n");
            }
            else
            {
                printf("Dequeued element: %d\n", Queue[front]);
                if (front == rear)
                    front = rear = -1; // Reset front and rear if last element
                else
                    front = (front + 1) % N; // Move front circularly
            }

        }
        else if (option == 3)
        {
            if (front == -1)
                printf("Queue is empty\n");
            else
                printf("Queue is not empty\n");

        }
        else if (option == 4)
        {
            if ((rear + 1) % N == front)
                printf("Queue is full\n");
            else
                printf("Queue is not full\n");

        }
        else if (option == 0)
        {
            return 0;

        }
        else
        {
            printf("Invalid input.\n");
        }
    }
    return 0;
}
