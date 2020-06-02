Question:

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	The linked list will have at least two elements.
	All of the nodes' values will be unique.
	The given node will not be the tail and it will always be a valid node of the linked list.
	Do not return anything from your function.

Approach:
	Copied value and next pointer of the node next to the one being deleted to the node being deleted.
	JVM garbage collector will handle the dereferenced pointer.
