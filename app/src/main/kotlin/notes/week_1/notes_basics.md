
Classes :

1. Final 
- Koltin classes are by default final, which means they cant be overridden.
2. Open
- They are allowed to me made independently and also can be overridden.
3. Abstract
- They can only be implemented and cant be independently created.

Companion Object :

-An object shared across all the objects of a particular class.
-Should be used to share common data across all the objects of a class, for example a counter of all objects.

init{} block :
- this is the first block of code which runs when an object is created
- this should be used to do operations just after an object creation, for example updating some counter in the companion object.


## Collection interfaces hierarchy

### Iterable
- This is the base interface which is inherited by all collections except map.
- This basically contains a single operator function iterator : Iterator<T>
###
### MutableIterable
-This implements iterable , so overrides the operator functions iterator which returns a MutableIterator which is a type of Iterator.
###
### Collection
-This implements Iterable and contains variables like size and functions like contains and isEmpty,
-So every collection has these functions. and of course and operator function iterator.
###
### MutableCollection
- This implements collection and also contains its own functions like add, remove, addAll, removeAll
- So every mutable collection will have these functions as well.

#### List , Set implement Collection
#### MutableList, MutableSet implement MutableCollection and List, Set respectively

### Map is not a collection by inheritance it is completely separate, but is a part of kotlin collections.
### MutableMap implements nothing but Map, specifically its type is a LinkedHashMap, which also preserves the order of insertions.

## ArrayDeque :  Its a double-ended queue, uses resizable array internally, fills both the role of a stack and a queue in kotlin.