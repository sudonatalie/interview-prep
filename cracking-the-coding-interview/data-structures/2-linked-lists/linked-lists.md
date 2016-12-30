#Linked Lists

## Implementation
```
class Node {
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
```

### Delete
```
Node deleteNode(Node head, int d) {
	Node n = head;
	
	if (n.data == d) {
		return head.next; // move head
	}
	
	while (n.next != null) {
		if (n.next.data == d) {
			n.next = n.next.next; // delete node
			// if C/C++ we would also deallocate
			return head;
		}
		n = n.next;
	}
	return head;
}
```

## "Runner" Technique
Many problems can be solved by maintaining 2 pointers, one that is ahead of the other.

"fast" pointer may hop multiple nodes for each node that "slow" pointer iterates over.

*Example*: If `p1` moves 2 elements for every 1 move that `p2` makes, then when `p1` hits the end, `p2` will be at the midpoint.