package org.bd.core.content.database;


// Should be able to push, pop,  peek , check empty, check full for content BdFileDirSingleVm 
 

import java.util.*;
 
/*  Class arrayStack  */
class arrayStack
{
    protected BdFileDirSingleVm arr[];
    protected int top, size, len;
    /*  Constructor for arrayStack */
    public arrayStack(int n)
    {
        size = n;
        len = 0;
        arr = new BdFileDirSingleVm[size];
        top = -1;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /*  Function to check if stack is full */
    public boolean isFull()
    {
        return top == size -1 ;        
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /*  Function to check the top element of the stack */
    public BdFileDirSingleVm peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return arr[top];
    }
    /*  Function to add an element to the stack */
    public void push(BdFileDirSingleVm i)
    {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }
    /*  Function to delete an element from the stack */
    public BdFileDirSingleVm pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return arr[top--]; 
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }    
}
 

