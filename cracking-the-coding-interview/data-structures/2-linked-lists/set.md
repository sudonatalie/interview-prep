# Set

- duplicate free collection of elements

## HashSet

- constant time add, remove, contains
- iteration performance varies

## TreeSet

- *O(log n)* for add, remove, contains
- elements will be sorted (asc/desc can be specified with constructor)
- handy methods like `first()`, `last()`, `headSet(toElement)`, `tailSet(fromElement)`
- generally faster to add elements to `HashSet` then convert to `TreeSet` for duplicate-free sorted traversal