# Trees and Graphs

## Clarifications

- binary tree vs binary search (sorted) tree
- balanced vs unbalanced
- full and complete trees - all leaves are at the bottom and all non-leaf nodes have exactly 2 children

## Binary Tree Traversal
### in-order
left subtree, then current node, then right

### post-order

### pre-order

## Tree Balacing
### Red-Black Trees

### AVL Trees

### How to balance a tree

### Runtimes

## Tries
Characters stored at each node

## Graph Traversal

### Depth First Search

Visit a node `r` then iterate through each of `r`'s adjacent nodes. When visiting node `n` adjacent to `r`, visit all of `n`'s adjacent nodes before going on to `r`'s other adjacent nodes, but first check if already been visited.

```
void search(Node root) {
	if (root == null) return;
	visit(root);
	root.visited = true;
	foreach (Node n in root.adjacent) {
		if (n.visited == false) {
			search(n);
		}
	}
}
```

### Breadth First Search

Visit each of a node `r`'s adjacent nodes before searching any of `r`'s "grandchildren".

```
void search(Node root) {
	Queue queue = new Queue();
	root.visited = true;
	visit(root);
	queue.enqueue(root);
	
	while (!queue.isEmpty()) {
		Node r = queue.dequeue();
		foreach (Node n in r.adjacent) {
			if (!n.visited) {
				visit(n);
				n.visited = true;
				queue.enqueue(n);
			}
		}
	}
}
```