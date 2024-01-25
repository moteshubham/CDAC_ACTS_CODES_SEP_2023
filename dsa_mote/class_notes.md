Module Name: Algorithms & Data Structure
---------------------------------------------------------------------------------------------
+ what is data structure?
	- it is a way to store data into the memory in an orgnanized manner so that operations
	(addition, deletion, searching, sorting etc....) can be performed efficiently.
+ why data structure?
	1. efficiency
	2. abstraction
	3. reusability
	
+ there are two types of data structures:
	1. linear data structure/basic data structure
		- array
		- structure
		- union
		- linked list
		- stack
		- queue
		
	2. non-linear data structure/advanced data structure:
		- tree (heirachical data structure)
		- graph
		- hash table (associative data structures)
		- binary heap
	
-----------------------------------------------------------------------------------------------
+ array: it is a collection/list of logically related similar type of elements which gets
stored into the memory at contiguos memory locations.

+ structure: it is a collection of logically related similar and dissimilar type of
elements which gets stored into the memory collectively (i.e. at contiguos memory
 locations).
----------------------------------------------------------------------------------------------
+ what is an algorithm?
	- it is a finite set of instructions, if followed, acomplishes, a given task.
	- it is a well defined procedure to get solution for given problem.
	- it is a finite set of instructions written in human understandable language (i.e.
	in english) with programming constraints to get a solution for a given problem.
	- an algorithm is nothing but a "pseudocode".
	- an algorithm is a "solution".
	
	```
	Algorithm Sum(A,n)//A-array of "n" no. of elements
	{
		sum = 0;
		for( int index = 1 ; index <= n ; ++index )
		{
			sum += A[index];
		}
		return sum;
	}

	Algorithm RSum(A,n,index)
	{
		if( index == SIZE )
			return 0;
			
		return ( A[index] + RSum(A,n,index+1) );
	}
	```


	- there are two ways/approaches to write an algorithm
	1. iterative approach
	2. recursive approach
	
	- recursion -- it is a process in which we can give call to function from the same
	function itself OR function calls itself within itself.
	
	- there are two types of recursive functions:
	1. tail-recursive: recursive function in which recursive function call is the last
	executable statement is called as tail recursive.
	e.g. quick_sort()
		
	2. non-tail recursive: recursive function in which recursive function call is the 
	not the last executable statement is called as non-tail recursive.
	e.g. merge_sort()
	-------------------------------------------------------------------------------

	- one problem may has many solutions/algorithms
	- e.g. sorting -- to arrange elements in a collection/list (i.e. array or linked list)
	 of elements either in an ascending order or in a descending order.
	 	A1 -- selection sort
	 	A2 -- bubble sort
	 	A3 -- insertion sort
	 	A4 -- quick sort
	 	A5 -- merge sort
	 	A6 -- heap sort
	 	A7 -- radix sort
	 	A8 -- shell sort
	 	etc....

	 - when one problem has many solutions/algorithms one need to select an efficient
	 solution/algorithm out of them.
	 - to decide an efficiency of an algorithms we need to do their analysis.
	 - analysis of an algorithm: it is a work of determining how much "computer time" and
	 "memory/space" an algorithms needs to completes its execution.
	 - there are two measures of an analysis of an algo:
    	 1. time complexity: time complexity of an algorithm is the amount computer time it
    	 needs to run to completion.
    	 
    	 2. space complexity: space complexity of an algorithm is the amount computer memory/
    	 space it needs to run to completion.
	 
	 * space complexity (space required for any function/program/algorithm)
	 = code space ( i.e. instructions resides in a main memory )
    	 + data space (i.e. space required for simple variables, constants and instance
    	  variables)
    	 + stack space ( applicable only for recursive algorithms).
    	 it contains space required for formal parameters, local variables, return addr etc..
    	 
    	+ space complexity has two components:
        	1. fixed component: code space + data space (space required for simple variables and
        	constants).
        	
        	2. variable component: instance characteristics i.e. input size + stack space.
	
	
	* time complexity: 
	time complexity = compilation time + execution time
    	- compilation time is a fixed component, whereas execution time is a variable component
    	- execution time is depends on instance characteristics i.e. input size
    	- as execution time is not only depends on instance chars, it also depends on some
    	external factors/environment like type of machine, no. of processes running in the
    	system, time complexity cannot be calculated exactly by using this approach, and hence
    	another method can be used for calculating time and space complexities reffered as
    	"asymptotic analysis".
	
	+ asymptotic analysis: it is a "mathematical" way to calculate time complexity and
	space complexity of an algorithm without implementing it in any programming language.
	- to do asymptotic analysis "basic operation" in an algo can be focused.
	e.g. in searching and sorting algo's comparison is the basic operation, and hence
	analysis of such algo's can be done on the basis of no. of comparisons in it.
	
	
	+ **best case time complexity**: when an algo takes minimum amount of time to complete
	its execution then it is reffered as best case time complexity.
	
	+ **worst case time complexity**: when an algo takes maximum amount of time to complete
	its execution then it is reffered as worst case time complexity.
	
	+ **average case time complexity**: when an algo takes neither minimum nor maximim amount
	of time to complete its execution then it is reffered as an average case time
	complexity.

	+ asymptotic notations:
    	1. Big Oh (O) -- asymptotic upper bound -- worst case
    	2. Big Omega ( ) -- asymptotic lower bound -- best case
    	3. Big Theta ( ) -- asymptotic tihght bound -- average case
	
+ assumptions in an aymtotic analysis:

	- if running time an algorithm/function contains any constant, then it can be neglected
	 i.e. O(n+3) or O(2.n) => O(n).
	 
	- if running time of an algorithm/function has any multiplicative or divisive constant then
	it can be neglected, i.e. O(2.n^2) or O(n^2/2)	=> O(n^2).

		
	+ O(1):
    	- if any function/algo do not contains loop or call to any non-constant function or recursive
    	function calls then time complexity of that function/algo can be considered as O(1).
    	e.g. swap() function
		```
    	void swap(int *ptr1, int *ptr2)
    	{
    		int temp = *ptr1;
    		*ptr1 = *ptr2;
    		*ptr2 = temp;
    	}
		```
    	OR
    	- if loop in a function/algo executes fixed number of times then time complexity can be
    	considered as O(1).
    	e.g.
		```
    	for( int i = 0 ; i < c ; i++ )//where c is integer constant
    	{
    		//O(1) statements
    	}
		```
	
	+ O(n):
    	- if a loop variable either incremets or decrements by a constant value, then time complexity
    	can be considered as O(n).
    	e.g.
		```
    	for( int i = 0 ; i < n ; i += c )//where c is integer constant
    	{
    		//O(1) statements
    	}
    	OR
    	for( int i = 0 ; i < n ; i -= c )//where c is integer constant
    	{
    		//O(1) statements
    	}
		```

	+ O(log n):
    	- if a loop variable in an algo/function/program is gets either divided or multiplied then
    	 we will get time complexity in terms of log.
    	e.g.
		```
    	for( int i = 0 ; i < n ; i *= c )//where c is integer constant
    	{
    		//O(1) statements
    	}
    	OR
    	for( int i = 0 ; i < n ; i /= c )//where c is integer constant
    	{
    		//O(1) statements
    	}
		```

	+ O(n^c): for nested loops: if "c" no. of nested loops (i.e. loop inside loop)
    	- in this case time complexity of an algo/function is the time taken by the statement/s
    	 inside the innermost loop.
    	
    	```
		for( int i = 0 ; i < n ; i++ ) //--> O(n+1) times
    	{
    		for( int j = 0 ; j < n ; j++ )//O( n(n+1)) times
    		{
    			//statements //-> n*n => n^2
    		}
    	}
		```
		
	+  if any function/algo contains two consecutive loops:
	
		```		
		for( int i = 0 ; i < n ; i ++ )
		{
			//O(1) statement/s
		}
			
		for( int i = 0 ; i < m ; i ++ )
		{
			//O(1) statement/s
		}
			
		then O(n) + O(m) => for m == n => O(2n) => O(n)
		```
	
----------------------------------------------------------------------------------------
## array:
- "searching": to search a key ele in a given collection/list of elements.
1. linear search:
	```
	Algorithm LinearSearch(A, n, key)
	{
	for( int index = 1 ; index < SIZE ; index++ )
	{
		if( A[ index ] == key )
			return true;
	}
	return false;
	}
	```

* best case -- when key is found at first pos then algo does only one comparison,
time complexity of an algo in this case = O(1).
Big Omega(1)

* worst case -- when either key is exists at last position or key does not exists
algo does max "n" no. of comparisons whereas "n" size of an array, in this case
time complexity of an algo = O(n).

* average case -- if key is exists at in between position the algo takes neither
minimum nor max time to complete its execution, in this case time complexity of
an algo = O(n/2)

# searching algorithms:
## 1. linear search:
- also called as "sequential search".
- it sequentially checks each element of the list until the match is found or the whole list
has been searched.
- best case -- occurs when key ele is found at first position, in this case algo takes O(1)
time.
- worst case -- occurs when either key ele is found at last position or key ele does not
exists, in this case algo takes O(n) time whereas n is the no. of ele's in the list/
collection.
- average case -- occures when key ele is exists in the list at in between position, in this
case algo takes O(n/2) => O(n) time.

## 2. binary search:
- also called as "logarithmic search" or "half interval search"
- this algo follows "divide-and-conquer" stratergy.
- to apply binary search prerequisite is list of elements must be in a sorted manner.
- in the first iteration -- mid position gets calculated and key ele gets compared with ele
at mid position, if key ele is found then it will be the best case, otherwise array gets
divided logically into two sub array's left subarray and right sub array.
- if key ele is smaller than mid position ele then key ele gets searched into the left sub
array only by skipping the whole right sub array checking or if key ele is greater than
mid position ele then key ele gets searched into the right sub array only by skipping whole
left sub array
- the logic repeats either till key ele is not found or till size of an array is less than
one.
- if key ele is found at mid position in the very first iteration then no. of comparisons
are "1" and it is considered as a best case, in this algo takes O(1) time, otherwise it takes
O(log n) time.

- as in every iteration this algo does 1 comparison and divides array into sub arrays and key
ele gets serached either one of the subarray, i.e. after every iteration it divides 

	```
	=> T(n) = T(n/2) + 1
	for n = 1
	T(n) = T(1) + 1
	i.e. running time of an algo is O(1). --- trivial case

	for n > 1
	T(n) = T(n/2)+ 1 ..... (I)
	to get the value of T(n/2) put  n = n/2 in eq-I we get,
	=> T(n/2) = T( n/2 / 2 ) + 1
	=> T(n/2) = T(n/4) + 1 .....(II)

	substitute the value of T(n/2) in eq-I we get,
	=> T(n) = [ T(n/4) + 1 ] + 1
	=> T(n) = T(n/4) + 2 .....(III)


	to get the value of T(n/2) put n = n/2 in eq-II we get,
	=> T( (n/2) / 2 ) = T( (n/4) / 2 ) + 1
	=> T(n/4) = T(n/8) + 1 .... (IV)

	substitute the value of T(n/4) in eq-III we get,
	=> T(n/4) = [ T(n/8) + 1 ] + 2
	=> T(n/4) = T(n/8) + 3 ......(V)

	.
	.
	after k iterations:

	T(n) = T(n/2^k) + k

	for n = 2^k
	log n = log 2^k .... by taking log on both side
	log n = k log 2
	therefore, k = log n
	=> T(n) = T(2^k/2^k) + log n
	=> T(n) = T(1) + log n
	=> T(n) = log n

	and hence, T(n) = O(log n).
	```
### difference between linear search and binary search:
- in linear search after every iteration search space is reduced by 1 i.e. (n-1) and in
binary search search space is reduced by half of elements i.e. by (n/2).
- worst case time complexity of linear search is O(n) and of binary search is O(log n)
hence binary search is efficient than linear search.
- binary search cannot applied on linked list

---
# DAY-02:	

## 1. selection sort: 

- inplace comparison sort
- this algo divides the list logically into two sublists, first list contains all elements
and another list is empty.
- in the first iteration -- first element from the first list is selected and gets
compared with remaining all ele's in that list, and the smallest ele can be added into the
another list, so after first iteration second list contains the smallest ele in it.
- in the second iteration -- second element from the first list is selected and gets 
compared with remaining all ele's in that list and the smallest amongst them can be added
into the another list at next position, so in second iteration the second smallest element
gets added into the another list next to the smallest one, and so on.....
- so after max (n-1) no. of iterations all elements from first list gets added into the
another list (which was initially empty) in a sorted manner and we will get all elements 
in a collection/list in a sorted manner.
- in every iteration one element gets selected and gets compared with remaining 
- best case, worst case and average case time complexity of selection sort algo is O(n^2).
- advantages:
1. simple to implement
2. inplace
- disadvantages:
- not efficient for larger input size collection of ele's array/list.
- not adaptive i.e. not efficient for already sorted input sequence.
	
---
## 2. bubble sort:

- sometimes reffered to as "sinking sort".
- this algo divides the list logically into two sublists, initially first list contains all
elements and another list is empty.
- in the first iteration -- the largest element from first list can be selected and gets
added into the another list at last position.
- in the second iteration -- largest element from the ele's left in a first list is selected
and gets added into the second list at second last position and so on....
- so after max (n-1) no. of iterations all elements from first list gets added into the
another list (which was initially empty) in a sorted manner from last position to first
position and we will get all elements in a collection/list in a sorted manner.
OR
- ele's at consecutive locations gets compared with each other of they are not in order
then they gets swapped otherwise their position remains same.

- best case -- if array ele's are already sorted then this algo takes O(n) time
- worst case and average case time complexity of bubble sort algo is O(n^2).

- advantages:
- simple to implement
- inplace - do not takes extra space for sorting ele's
- can be implement as an adaptive
- highly stable 
- disadvantages:
- not efficient for larger input size collection of ele's array/list.
- not adaptive in nature but can be implement as an adaptive
---
## 2. heap sort:

- Heapsort is the in-place sorting algorithm
- Array implementation of almost complete binary tree is called Heap
---
	+ insertion sort --
---
# DAY-03:

### limitations of an array:
- array is static i.e. size of an array cannot be grow or shrinked during runtime.
- addition and deletion operations are not efficient as well as convenient.
	
## linked list: 
it is a collection/list of logically related similar type of elements in
which each element is linked with its next (as well as prev) element.
- in a linked list element is also called as "node".
- it is a collection/list of logically related similar type of elements in which
	- addr of first element can be store into one pointer variable reffered as "head"
	- each element has two/three parts:
		1. data part: contains actual data may be of any primitive or non-primitive type
		2. next part(pointer part): contains addr of next its element/node
		3. prev part(pointer part): contains addr of its prev element/node

- there are four types of linked list:
  1. singly linear linked list
  2. singly circular linked list
  3. doubly linear linked list
  4. duobly  circular linked list

-----------------------------------------------------------------------------------------

1. singly linear linked list: it is a linked list in which
	- head always contains addr of first element/node if list is not empty
	- each node/element has two parts:
		1. data part: contains actual data of any primitive or non-primitive type
		2. next part (pointer part): addr of its next node/element
	- next part of last node points to NULL.
		```
		class node
		{
			private:
				int data;//data part
				node *next;//pointer part --> self refferential pointer
				
		};
		#define NULL (void *)0
		```
	
	- operations on singly linear linked list:
	1. addition:
		- add node into the list at last position
		- add node into the list at first position
		- add node into the list at specific position
	2. deletion:
		- delete node at first position
		- delete node at last position
		- delete node at specific position
		
	
2. singly circular linked list: it is a linked list in which
	- head always contains addr of first element/node if list is not empty
	- each node/element has two parts:
		1. data part: contains actual data of any primitive or non-primitive type
		2. next part (pointer part): addr of its next node/element
	- next part of last node points to first node.
	
3. doubly linear linked list: it is a list in which
	- head always contains addr of first element/node if list is not empty
	- each node/element has three parts:
		1. data part: contains actual data of any primitive or non-primitive type
		2. next part (pointer part): addr of its next node/element
		3. prev part (pointer part): addr of its prevoius node/element
	- prev part of first node and next part of last node points to NULL.
	
4. doubly circular linked list: it is a linked list in which
	- head always contains addr of first element/node if list is not empty
	- each node/element has three parts:
		1. data part: contains actual data of any primitive or non-primitive type
		2. next part (pointer part): addr of its next node/element
		3. prev part (pointer part): addr of its prevoius node/element
	- prev part of first node points to last node and next part of last node pints to
	 first node.
	
 + **applications of linked list**:
 	- linked list can be used to implement basic data structures like stack, queue,
 	priority queue, double ended queue.
 	- it can also be used to implement advanced data structures like tree, graph and hash
 	table.
 	- linked list can be used to implement advanced data structure algorithms.
	- linked list can be used in implementation of OS/Kernel data structures like ready
	 queue, job queue, waiting queue, message queue etc....
	- linked list can be used to implement OS algorithms like FIFO cpu scheduling algo,
	priority cpu scheduling algo, **page replacement algo's, disk scheduling algo** etc....
	- applications in which collection/list of elements is dynamic in nature we can go for
	linked list.
	e.g. image veiwer, next and prev pages in a web browser, music player
	
 + **difference between array and linked list**:
 	- array is "static" i.e. size of an array cannot grow or shriked during runtime,
 	whereas linked list is "dynamic" i.e. we can grow or shrinked size of a linked list
 	during runtime (we can add as well delete elements in a linked list during runtime).
 	- array elements can be accessed by using "random access" method which is faster than
 	"sequential access" method used for accessing linked list elements.
	- array elements gets stored into the main memory at "contiguos memory locations",
	 whereas linked list elements gets stored into the memory at "random locations" and
	 need to maintained link between them.
	- for storing array elements it takes less space in comparison with space required to
	store linked list elements -- as in an array link between array ele's maintained by
	the compiler whereas programmer need to take care about maintaining link between
	linked list ele's and for maintaining link extra space is required.
	- addition and deletion ele operations in array takes O(n) time which is not an
	 efficient one as well these operations are not convenient, whereas addition and
	 deletion ele operations in a linked list takes O(1) time which is an efficient
	 operations and convenient as well.
	- array elements gets stored into the main memory at "stack section", whereas linked
	 list elements gets stored into the main memory at "heap section".
---------------------------------------------------------------------------------------
## **queue**: 
- it is a collection/list (i.e.  array or linked list) of logically related similar
type of elements into which element can be added from one end reffered as "rear" end,
and ele can be deleted from another end reffered as "front" end.
- in this list element which was added first can be deleted first, so this list works
in "first in first out" manner, and hence it is also called as "FIFO" list.
OR "LILO" -- last in last out.
- we can perform two operation on queue:
1. enqueue -- to insert/add/push element into the queue
2. dequeue -- to remove/delete/pop element from the queue

- there are different types of queue:
  	1. linear queue
  	2. circular queue
  	3. priority queue:
  		- it is a queue in which element can be added from rear end randomly and element
  		having highest priority can only be deleted first.
  		- priority queue can be implemented by using linked list
  		- it can be implemented efficiently by using "binary heap".
		
	1. double ended queue i.e. "dequeuq"
		- it is a queue in which element can be added as well as deleted from both the ends
		- we can perform four operations on deque:
			1. push_front() -- insert/push/add ele from front end
			2. push_back() -- insert/push/add ele from back end
			3. pop_front() -- remove/delete/pop ele from front end
			4. pop_back() -- remove/delete/pop ele from back/rear end
		- dequeue can be implemented by using doubly circular linked list.
		
+ implementation linear queue:	using an array -- "static queue"
	```
	int arr[SIZE];
	int front;
	int rear;
	
		queue_full:
			rear == SIZE-1
			
		queue_empty:
			rear == -1 || front > rear
	
		1. enqueue -- to insert/add/push element into the queue:
			- check queue is not full
			- increment the value of rear by 1
			- insert ele into the queue at rear position
			- if ( front == -1 )
				front = 0
			
		
		2. dequeue -- to remove/delete/pop element from the queue
			- check queue is not empty
			- increment the value of front by 1 -- i.e. delete ele from the queue which
			is at front end.


	front++ => front = front + 1 => 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5
	rear++ => rear = rear + 1

	```
+ implementation circular queue:
	```
	int arr[SIZE];
	int front;
	int rear;
	
		queue_full:
			( front == (rear + 1 ) % SIZE )
			
		queue_empty:
			( rear == -1 && front == rear )
	
		1. enqueue -- to insert/add/push element into the queue:
			- check queue is not full
			- increment the value of rear by 1 (rear = (rear + 1 ) % SIZE)
			- insert ele into the queue at rear position
			- if ( front == -1 )
				front = 0
			
		
		2. dequeue -- to remove/delete/pop element from the queue
			- check queue is not empty
			if( front == rear )
				front = rear = -1
			else
				- increment the value of front by 1 -- i.e. delete ele from the queue which
				is at front end. (front = (front + 1 ) % SIZE)

	

	front = (front + 1 ) % SIZE
	for front = 0 => (0+1)%5 => 1 % 5 => 1	
	for front = 1 => (1+1)%5 => 2 % 5 => 2
	for front = 2 => (2+1)%5 => 3 % 5 => 3
	for front = 3 => (3+1)%5 => 4 % 5 => 4
	for front = 4 => (4+1)%5 => 5 % 5 => 0


	*	front == (rear + 1 ) % SIZE
		
		for front = 0, rear = 4
		front == (rear + 1 ) % SIZE
		=> 0 == (4 + 1 ) % 5 => 5 % 5 => 0

		for front = 1, rear = 0
		front == (rear + 1 ) % SIZE
		=> 1 == (0 + 1 ) % 5 => 1 % 5 => 1

	```	
+ queue implementation by using linked list:
	enqueue -- add_last()
	dequeue -- delete_first()
	OR
	enqueue -- add_first()
	dequeue -- delete_last()	

+ "applications of queue":
	- queue can be used to implement advanced data algo's like "bfs" breadth first search
	in tree and graph.
	- queue can be used to implement os algorithms like cpu shed algos's - priority sched
	 algo, FCFS etc..., page replacement algo's -- FIFO, disk sched algo's
	 - queue can be used to implement kernel/os data structures like job queue, ready queue
	 waiting queue etc....
	 - queue can be used in an application where the requirement is in a collection/list 
	 of ele's list works in "first in first out".
	 
------------------------------------------------------------------------------------
## **stack**:
  - it is a collection/list (i.e. array or linked list) of logically related similar type of
  elements into which element can be added as well deleted from only one end reffered as "top"
  end.
  - in this list the element which was added last can only be removed first, so this list
  works in "last in first out" manner, and hence it is also called as "LIFO" list.
  OR "FILO" list.
  - we perform three operations on stack:
  1. push -- insert/add element into the stack from top end
  2. pop -- delete/remove element from the stack which is at top end
  3. peek -- to get element which is at top position
	
+ implementation: using an array -- static stack
	```
	int arr[SIZE];
	int top;

	stack full : top == SIZE-1
	stack empty : top == -1

	1. push -- insert/add element into the stack from top end
		- check stack is not full
		- increment the value of top by 1
		- insert ele into the stack at top position
		
	2. pop -- delete/remove element from the stack which is at top end
		- check stack is not empty
		- decrement the value of top by 1 i.e. to pop ele from the stack
		
	3. peek -- to get element which is at top position
		- check stack is not empty
		- return the element which is at top position (without incrementing/decrementing
		value of top)

	```
+ implementation of stack -- dynamically by using linked list
	```
	push -- add_last()
	pop -- delete_last()
	OR
	push -- add_first()
	pop -- delete_first()
	```
+ "applications of stack":
	- stack is used by an os to control flow of an execution of a programs
	- stack can be used internally by an os in the process of recursion
	- undo and redo functionalities of an os uses stack
	- stack can be used to implement advanced data structure algo's like "dfs" depth
	first search in tree and graph.
	- stack can be used in any applications where in a collection/list of elements works
	in last in first out manner.
	- stack can be used to implement algo's like:
		- conversion of infix expression into its eq postfix and prefix
		- evalution of postfix expression
----------------------------------------------------------------------------------
	- expression -- combination of operands and operators
	- there are three types of expressions:
		1. infix  : a + b
		2. prefix : +ab
		3. posfix : ab+
		
		
		infix 	=> [ a+b/c*d+e*f-g*h ] -- without parenthesis
		prefix	=> [ -++a*/bcd*ef*gh ]
		postfix	=> [ abc/d*+ef*+gh*- ]
		
		infix	=> [ (a+b)*(c-d)+e*f+g-h ] -- with parenthesis
		
postfix expression: abc/d*+ef*+gh*-
		


		"12" 
		"*" 
		"25" 
		"+" 
		"125" 
		"-"
		"100"

--------------------------------------------------------------------------------------
## **Tree**:
**Applications**:
  - Storing naturally hierarchical data: Trees are used to store the data in the hierarchical structure. For example, the file system. The file system stored on the disc drive, the file and folder are in the form of the naturally hierarchical data and stored in the form of trees
  - Organize data: It is used to organize data for efficient insertion, deletion and searching. For example, a binary tree has a logN time for searching an element
  - Trie: It is a special kind of tree that is used to store the dictionary. It is a fast and efficient way for dynamic spell checking
  - Heap: It is also a tree data structure implemented using arrays. It is used to implement priority queues.
  - B-Tree and B+Tree: B-Tree and B+Tree are the tree data structures used to implement indexing in databases
  - Routing table: The tree data structure is also used to store the data in routing tables in the routers.
### Types of trees

#### General Tree:
- no restrictions

#### Binary Tree:
- utmost 2 childs
- 0, 1, 2 childs
- Binary tree has degree 2 - hence called 2-Tree

#### Full Binary Tree:
- 0 or 2 children
- binary tree in which all the nodes have two children except the leaf nodes.
- binary tree with full its capacity for given height
- adding one more tree will increase height of tree
- it is always complete as well as strict binary tree
- no of elements= 2^(h+1) - 1

#### Complete Binary Tree:
- All levels except the last level are completely filled.
- The last level is filled from left to right.
- All leaf nodes are at the same depth.

#### Almost Complete Binary Tree:
- binary tree which follows two condition :
  - All leaf nodes are at level h or h-1
  - All leaf nodes at last level(h), are aligned left as much possible

#### Strictly Binary Tree:
- Binary tree in which all leaf nodes are at same level

#### Binary Search Tree:
- Every node in the left subtree must contain a value less than the value of the root node, and the value of each node in the right subtree must be bigger than the value of the root node.
- left child is always smaller and right child is always greater or equal to parent
- searching is faster Time compl: `O(h) --> h` is height of tree

#### AVL Tree:
- variant of the binary search tree
- AVL tree satisfies the property of the binary tree as well as of the binary search tree.
- self-balancing binary search tree that was invented by Adelson Velsky Lindas
- The balancing factor =  height of the left subtree - height of the right subtree
- each node in the AVL tree should have the value of the balancing factor either as 0, -1, or 1.

#### The total number of spanning trees with n vertices that can be created from a complete graph is equal to n^(n-2).

---
### Hash Table
Applications
- Databases: Hashing can be used to index data in a database, which makes it faster to search for and retrieve data.
- Cryptography: Hashing can be used to create digital signatures and other cryptographic primitives.
- Caching: Hashing can be used to implement caches, which are data structures that store frequently accessed data in memory for faster access.
- Bloom filters: Hashing can be used to implement Bloom filters, which are a space-efficient probabilistic data structure used to test whether an element is a member of a set.
- In a web browser, a hash table can be used to cache frequently accessed web pages
- In a compiler, a hash table can be used to store the symbols in the program.
- In a programming language, a hash table can be used to implement a dictionary or associative array
---
## Graph 
It is a non-linear advanced data structure, which is a collection of logically
related elements contains:
- finite set of elements called as "vertices" also reffered as "nodes", and
- finite set of ordered/unordered pairs of vertices called as "edges" also reffered as
"arcs", which may has value/weight/cost (cost may be -ve or +ve).

	e.g. G(V,E)   
		V = {0,1,2,3,4}	   
		E = {(0,1), (0,2), (0,3), (1,2), (1,4), (2,3), (3,4) };

- unordered pair of vertices 	=> (u,v) = (v,u) --> undirected edge
- ordered pair of vertices 		=> (u,v) != (v,u) --> directed edge

- if there exists a direct edge between two vertices then such vertices are called as
"adjacent" vertices otherwise they are called as "non-adjacent" vertices.

- "connected vertices" -- if path (either direct/indirect) exists between two vertices
then those vertices are called as "connected" vertices.
- if there exists an edge from any vertex to that vertex itself then such a edge is
called as "loop".
- if in a graph all vertices are adjacent to remaining all other vertices, then such
a graph	is called as "complete graph".

- "isolated vertex" -- vertex which is not connected to any other vertex in a graph.
- if any graph contains isolated vertex then such a graph is called as "not connected
graph"	or "disconnected graph".
- if in a graph all vertices are connected to remaining all vertices then such a graph
is called as "connected graph".
- if edges in a graph contains weight/cost/value then such a graph is called a
"weighted" graph otherwise it is called as "unweighted" graph.

- there are two ways by which we can implement/represent graph:
  1. adjacency matrix representation -- 2-d array
  2. adjacency list representation -- array of linked lists ( i.e. vector of lists )

+ "spanning tree" is a subgraph of a graph can be formed by removing one or more edges
in a such a manner so that graph remains connected and do not contains a cycle.

+ weight of the graph -- it is the sum of weights of all its edges.
+ one graph may has more than one spanning tree
+ minimum spanning tree -- spanning tree having minimum weight called as minimum
spanning tree i.e. MST.

+ dfs traversal method: using stack
	- step1 - push the start vertex into the stack and mark it
	- step2 - pop the vertex from the stack and visit it
	- step3 - push all its (popped vertex) adjacent but unmarked vertices into the stack and mark them
	- step4 - repeat step2 and step3 till stack is not empty

+ bfs traversal method: using queue
	- step1 - push the start vertex into the queue and mark it
	- step2 - pop the vertex from the queue and visit it
	- step3 - push all its (popped vertex) adjacent but unmarked vertices into the queue and mark them
	- step4 - repeat step2 and step3 till queue is not empty





+ kruskals: to find MST by maintaining set of MST edges:








------------------------------
6 7 1 *
5 6 2 *
2 8 2 *
0 1 4 *
2 5 4 *
6 8 6 x
2 3 7 *
7 8 7 x
0 7 8 *
1 2 8 x
3 4 9 *
4 5 10 x
1 7 11 x
3 5 14 x
	 



edges are: 
0->1 : 4
0->7 : 8
1->2 : 8
1->7 : 11
2->3 : 7
2->5 : 4
2->8 : 2
3->4 : 9
3->5 : 14
4->5 : 10
5->6 : 2
6->7 : 1
6->8 : 6
7->8 : 7
edges after sorting: 
6->7 : 1 *
5->6 : 2 *
2->8 : 2 *
2->5 : 4 *
0->1 : 4 * 
6->8 : 6 x
2->3 : 7 *
7->8 : 7 x
1->2 : 8 *
0->7 : 8 x
3->4 : 9 *
4->5 : 10 x
1->7 : 11 x
3->5 : 14
MST SET EDGES IS: 
6 -> 7 : 1
5 -> 6 : 2
2 -> 8 : 2
2 -> 5 : 4
0 -> 1 : 4
2 -> 3 : 7
1 -> 2 : 8
3 -> 4 : 9






	














