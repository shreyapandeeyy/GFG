//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends






class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='('||c=='{'||c=='[')
                stk.push(c);
            else
            {
                if(!stk.isEmpty())
                {
                    if(c==')')
                    {
                        if(stk.peek()=='(')
                            stk.pop();
                        else
                            return false;
                    }
                    
                    else if(c=='}')
                    {
                        if(stk.peek()=='{')
                            stk.pop();
                        else
                            return false;
                    }
                    else if(c==']')
                    {
                        if(stk.peek()=='[')
                            stk.pop();
                        else
                            return false;
                    }
                    
                }
                else
                    return false;
            }
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}