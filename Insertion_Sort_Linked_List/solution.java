public class LinkedListIS{
    node head;
    node sorted;

    class node{
        int val;
        node next;

        public node(int val){
            this.val = val;
        }
    }

    void push(int val){
        // we need to create a new node for the node
        node newnode = new node(val);
        // link the old list off the new node
        newnode.next = head;
        // move the head to point to the new node
        head = newnode;
    }

    // this sorts a singly linked list using insertion sort
    void insertionSort(node headref){
        // we need to initialize the sorted linked list
        sorted = null;
        node current = headref;

        // we then traverse the given linked list and insert every node to 'sorted'
        while(current != null){
            // store next for the next iteration of the loop
            node next = current.next;
            // we then insert the current in teh sorted linked list
            sortedInsert(current);
            // Then we advance within the given list
            current = next;
        }
        head = sorted;
    }

    // This is the function where insert the nodes into sorted order
    void sortedInsert(node newnode){
        // case for the head end
        if(sorted == null || sorted.val >= newnode.val){
            newnode.next = sorted;
            sorted = newnode;
        } else {
            node current = sorted;
            // here we find the lace where the node belongs within the sorted
            while (current.next != null && current.next.val < newnode.val){
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    void printlist(node head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}