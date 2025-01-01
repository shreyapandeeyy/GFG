//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/



/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // Your code here
        
        if( head == null || head.next == null || k == 0 )
            return head;

        Node start = head;
        Node end = head;
        List<Node> arr = new ArrayList<>();
    
        while( start != null && end != null ) {
    
            for( int i = 0; i < k-1; i++ ) {
                
                if( end.next != null )
                    end = end.next;
                else
                    break;
            }
    
            arr.add(end);
            arr.add(start);
            Node x = end.next;
            reverseFromStartToEnd(start, end);
    
            start = x;
            end = x;
        }
    
        
        for( int j = 1; j < arr.size() - 1; j+=2 ) {
    
           arr.get(j).next = arr.get(j+1);
        }
    
        return arr.get(0);
    }
    
    static void reverseFromStartToEnd( Node start, Node end ) {

        if ( start == null || end == null || start == end )
            return;
        
        Node prev = null;
        Node curr = start;
    
        while( curr != end ) {
    
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        curr.next = prev;
    }
}
