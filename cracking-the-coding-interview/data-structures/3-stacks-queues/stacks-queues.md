# Stacks and Queues

## Stack
LIFO

Can be implemented as linked list, but usually prevent peeking below top node

### Implementation
```
class Stack {
	Node top;
	
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek() {
		return top.data;
	}
}
```

## Queue
FIFO

### Implementation
```
class Queue {
	Node first, last;
	
	void enqueue(Object item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		}
		else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	
	Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			if (first == null) last = null; // empty queue
			return item;
		}
		return null;
	}
}
```