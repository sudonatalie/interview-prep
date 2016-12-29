#Arrays and Strings

##Hash Tables
Data structure used to implement an associative array, maps keys to values.

Uses a hash function to compute an index into an array of slots where desired value can be found

Array would need to be as large as all possible keys to avoid *collisions*, so we may instead store objects in a linked list at index `hash(key) % array_length`.

May also implement hash table with binary search tree:
- guarantee $$O(log n)$$ lookup time (by keeping tree balanced)
- use less space since large array no longer allocated in beginning

##ArrayList
Dynamically resizing array, while still providing $$O(1)$$ access.

Doubles in size when full, which takes $$O(n)$$, but happens so rarely that amortized time is still $$O(1)$$

##Strings
A `String` is immutable, i.e. when it's created, it can never change.

A `StringBuffer` is used when you need to construct a string piece by piece without the performance overhead of constructing lots of little Strings along the way.