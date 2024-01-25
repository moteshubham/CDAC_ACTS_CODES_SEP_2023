# Day2
```c#

FIELDS AND PROPERTIES

    //auto generated property
    //no validations
    //compiler generates te code for get and set.
    //also generates the private variable
    public string Prop5 { get; set; }


     //readonly property
     private string prop3;
     public string Prop3
     {
         get { return prop3; }
     }

//DONT EVER WRITE A SETTER AND A GETTER
o.Prop1 = 1000;  //assign a value -  set
Console.WriteLine(o.Prop1);  //read a value – get




STATIC

        //only a single copy for the entire class (shared data)
        public static int s_i;
  //static methods can be called directly from the class without creating an object of the class

     public static void s_Display()
     {
         Console.WriteLine("static dis");
         //from a static member you can only access static members directly.
         //to access a non static member you need to have an object reference
         //Console.WriteLine(i);  //error
         Console.WriteLine(s_i);
     }


//why static variable? - single copy
//why property? - validations

//why static property? -  single copy with validations

//why constructor? - to initialise values
//why static constructor? -  to initialise static values
//when is the static constructor called? - when class is loaded
//when is the class loaded? - 1st object created OR static member accessed for the 1st time

//TO DO
//static class
//can only static members
//cannot be instantiated
//cannot be a base class


//implicitly private
//parameterless
//cannot be overloaded
static Class1()
{
    Console.WriteLine("static cons");
    s_i = 100;
}

FUNCTION

//local function
//local function can access local variables defined in the outer function
//local function -cannot have an access specifier
//implicitly private 
//only available in outer function
void DoSomething2()
{
    i++;
    Console.WriteLine(i);
}

//static local function
//local function cannot access local variables defined in the outer function

static void DoSomething3()
{
    //i++;
    //Console.WriteLine(i);
}



CTOR

  //object initializer
  //Class1 o2 = new Class1() { i = 10, j = 20, k = 30 };
  Class1 o2 = new Class1 { i = 10, j = 20, k = 30 };
  //Class1 o2 = new Class1 ( 10, 20, 30 );




INHERITANCE EXAMPLE

public class BaseClass //:Object
{
    public int a;
}
public class DerivedClass : BaseClass
{    public int b;
}

 ////default access specifier is internal for members of a namespace
 class Program
 {
     static void Main2()
     {
         //BaseClass o = new BaseClass();
         //o.
         TestAccessSpecifiers.BaseClass o2 = new TestAccessSpecifiers.BaseClass();
         //o2.
     }
 }

   public class BaseClass
  {
      int a;  //default access specifier is private for members of a class

      //public - available everywhere
      //private - same class
      //protected - same class,  derived class
      //internal - same class, same assembly(same project)
      //protected internal - same class,  derived class, same assembly(same project)
      //private protected - same class,  derived class that is in the same assembly
      public int PUBLIC;
      private int PRIVATE;
      protected int PROTECTED;
      internal int INTERNAL;
      protected internal int PROTECTED_INTERNAL;
      private protected int PRIVATE_PROTECTED;
  }

   public DerivedClass(int i, int j) : base(i)  // this line to call base class 1 arg ctor else def ctor of base will be callled
 {
     Console.WriteLine("derived class int,int cons");
     //this.i = i;
     this.j = j;
 }
       

HIDING OVERRIDING OVERLOADING
/*

Employee
 - EmpNo,Name, Basic, DeptNo
 CalcNetSalary(){}

Manager : Employee
 CalcNetSalary(){}

---------------------------
1. OVERLOADING
Derived  class can overload the base class method
 CalcNetSalary(.......){}
same func name, diff parameters

Manager m = new Manager();
m.CalcNetSalary();         BASE
m.CalcNetSalary(.....);    Derived
---------------------------------------

2. HIDING
1. Derived  class can hide the base class method
 CalcNetSalary(){}
same func name, same parameters

Manager m = new Manager();
m.CalcNetSalary();         Derived

---------------------------------------

3. OVERRIDING
1. Derived  class can override the base class method
 CalcNetSalary(){}
same func name, same parameters

Manager m = new Manager();
m.CalcNetSalary();         Derived


-----------------------------
1. ANY method can be hidden
2. Only a virtual method can be overridden

*/

/*
                            Can Instantiate     Can be used as a base class
Abstract Class              NO                  YES

Sealed Class                YES                 NO

*/



```



# Day3

```c#
INTERFACE

static void Main1()
{
    Class1 o = new Class1();
    o.Display();
    o.Insert();

    //method 2
    IDbFunctions oIDb;
    oIDb = o;
    oIDb.Insert();

    //method 3
    ((IDbFunctions)o).Insert();


    //method 4
    (o as IDbFunctions).Insert();
}

//by def interafce methods are public

static void InsertMethod(IDbFunctions oIDb) //can receive an object of any class that implements IDbFunctions
{
    oIDb.Insert();
}

//advantages of interfaces

//contract - class MUST implement all the interface methods
//similar code in entire project for all developers
//polymorphic code
//design patterns 





static void Main()
{
    Class1 o = new Class1();
    o.Insert();

    //2. write a public method in class1 and it calls code from class1
    //o.Select();

    //1. without writing any code for Select in Class1 - it calls def imp code from interface
    (o as IDbFunctions).Select();
}

public interface IDbFunctions
{        
    void Select()
    {
        Console.WriteLine("def imp of select");
    }
}

public class Class1 : IDbFunctions
{
    
    //public void Select()
    //{
    //    Console.WriteLine("idb.select from class1");
    //}

    //if you are getting multiple copies of Select from different interfaces
    //then insted of public method, use explicit implentation
    void IDbFunctions.Select()
    {
        Console.WriteLine("idb.select from class1 - explicit implementation");
    }
}



DATATYPES

 static void DataTypes()
 {
     byte by; //Byte 
     sbyte by2; //SByte 

     short sh; //Int16 - 2
     ushort ush; //UInt16

     int i; //Int32  - 4
     uint ui;  //UInt32 - 4

     long l; //Int64 - 8
     ulong ul; //UInt64 - 8

     float f;   //Single - 4
     double d;  //Double - 8
     decimal c; //Decimal - 16

     char ch; //Char
     bool b; //Boolean

     object o; //Object        
 }


1) All classes and their variants are refernced types
Interface, delegates, Arrays, Object class & String

2) Value types are stored on the stack, all structs and enums are examples of value types

all enums are internally ints, and all ints are structs & enum is also struct

struct does not suppport inheritace 




Ref In Out
   //out is similar to ref - changes made in func reflect back in calling code
   //the initial value is discarded
   //out variables MUST be initialized in the function
   static void Init(out int a, out int b)
   {
       //Console.WriteLine(a);  //error
       a = 1000;
       b = 2000;
   }
   static void Print(in int x)
   {
       //x is a readonly value
       //x = 100; //error
       Console.WriteLine(x);
   }


   static void DoSomething1(Class1 obj)
   {
       //changes made in func (changing value of properties) is reflected in calling code o
       obj.i = 200;
   }
   static void DoSomething2(Class1 obj)
   {
       //changes made in func (obj pointing to some other block) is NOT reflected in calling code o

       obj = new Class1();
       obj.i = 200;
   }
   static void DoSomething3(ref Class1 obj)
   {
       //changes made in func (obj pointing to some other block) is reflected in calling code o

       obj = new Class1();
       obj.i = 200;
   }
   static void DoSomething4(out Class1 obj)
   {
       //obj MUST be initialized
       //changes made in func (obj pointing to some other block) is reflected in calling code o

       obj = new Class1();
       obj.i = 200;
   }
   static void DoSomething5(in Class1 obj)//obj = o
   {
       //obj CANNOT be initialized
       //obj = new Class1();

       //changes made in func (changing value of properties) is reflected in calling code o
       obj.i = 200;
   }


NULLABLE TYPES

 static void Main()
 {
     int? i;
     i = 10;
     //i = null;

     int j;
     if(i != null) 
         j = (int)i;
     else
         j = 0;

     if (i.HasValue)
         j = i.Value;
     else
         j = 0;

     j = i.GetValueOrDefault();
     j = i.GetValueOrDefault(10);

     j = i ?? 0; //null coalescing operator


     Console.WriteLine(j);
 }


ARRAY


int[] arr = new int[5];
//0...4
//arr[0] ... arr[4]
for (int i = 0; i < arr.Length; i++)
{
    //Console.Write("Enter value for arr[" + i + "]");  //string concatenation
    //Console.Write("Enter value for arr[{0}]", i);  //placeholder
    Console.Write($"Enter value for arr[{i}]");  //string interpolation
    //arr[i] = int.Parse(Console.ReadLine());  //to accepts from cmd
    arr[i] = Convert.ToInt32(Console.ReadLine());
}
Console.WriteLine();
for (int i = 0;i < arr.Length;i++)
{
    Console.WriteLine($"The value of arr[{i}] is {arr[i]}");   //noiceeee
}



    int pos = Array.IndexOf(arr, 20);
    //if(pos == -1) //not found
    pos = Array.LastIndexOf(arr, 20);
    pos = Array.BinarySearch(arr, 20);
    //if(pos < 0) //not found

    Array.Clear(arr);   //clears the content of array
    Array.Copy(arr, arr2, arr.Length);  //if error whie copying then some are copied
    Array.ConstrainedCopy(arr, 0, arr2, 0, arr.Length); // all or nothing will be copied if error
    //Array.Reverse(arr);
    //Array.Sort(arr);


//Console.WriteLine(arr.Length);
//Console.WriteLine(arr.Rank);  //no of dimensions
//Console.WriteLine(arr.GetLength(0));  //length of 1st dimension
//Console.WriteLine(arr.GetLength(1));  //length of 2nd dimension
//Console.WriteLine(arr.GetUpperBound(0));  //upper bound of 1st dimension //if 5cha array then 0-4
//Console.WriteLine(arr.GetLowerBound(0));  //upper bound of 1st dimension

for (int i = 0; i < arr.GetLength(0); i++)
{
    for (int j = 0; j < arr.GetLength(1); j++)
    {
        Console.Write($"Enter value for arr[{i},{j}]");  //string interpolation
        arr[i,j] = Convert.ToInt32(Console.ReadLine()); //2d array declaring style
    }
}

JAGGED ARRAY

//jagged
    int[][] arr = new int[4][]; //arr is an array of an int array

    //for (int i = 0; i < arr.Length; i++)
    //{
    //    arr[i] = new int[x]
    //}

    arr[0] = new int[3]; // arr[0][0] arr[0][1] arr[0][2]
    arr[1] = new int[4]; // arr[1][0] arr[1][1] arr[1][2] arr[1][3]
    arr[2] = new int[2];//  arr[2][0] - arr [2][1]
    arr[3] = new int[3];//  arr[3][0] arr[3][1] arr[3][2]


static void Main()
{
    Employee[] arrEmps = new Employee[5]; //here new  means only size of Array, not creating object here

    //arrEmps[0] = new Employee();
    //arrEmps[1] = new Employee();
    //arrEmps[2] = new Employee();
    //arrEmps[3] = new Employee();
    //arrEmps[4] = new Employee();

    for (int i = 0; i < arrEmps.Length; i++)
    {
        arrEmps[i] = new Employee();
        //arrEmps[i].Name
        //arrEmps[i].EmpNo
    }
    foreach (Employee item in arrEmps)
    {
        //item = new Employee();  //error - will not work -- item is readonly
        //item.EmpNo = 10;  //will work
    }
}



```








# Day4


## ImplicitVariables

```c#

 static void Main(string[] args)
 {
     // var can only be used for local variables, not for class level variables,
     //not for func parameters or return values
     //int i = 100;
     var i = 100;  //implicit variable

     //var j;  //error  - must be initialized

     var s = 1243;
     //s = ""; //error  - cant convert string i= to int
     s = 100;

 }

```


## Params

```c#
 static void Main()
 {
     Console.WriteLine(Add(1, 2, 3));
     Console.WriteLine(Add(1, 2, 3,4, 5));
     Console.WriteLine(Add(1, 2, 3, 4 ,5,6,7));

 }
 static int Add(params int[] ints)  //params syntax
 {
     int res = 0;
     foreach (int i in ints)
     {
         res += i;
     }
     return res;
 }
```

---

## Index

```c#
    internal class Program
    {
        static void Main1()
        {
            string[] names = { "A", "B", "C", "D", "E", "F" };

        }
    }
    public class IndexExamples
    {
        //var taakes data type according to RHS
        public static string GetFirst(string[] names)
        {
            Index index = new Index(0);     //takes index to  process as an argument
            return names[index];  //A

            var index = new Index(0,true);  //get last  //F
           //var index = new Index(2, true);  //get second last     //E
           // var index = new Index(3, true);  //get third last     //D
            return names[index];

            return names[^1];   //^ this operator denotes in reverse order  //F

            return names[^2];   // second from last   //E
        }
    }
```

## Range

```c#
public class RangeExamples
{
    public static string[] GetAll(string[] arr)
    {
        return arr[..];  //all

        var start = new Index(0);
        var end = new Index(2);
        var range = new Range(start, end);  //inclusive of start but exclusive of end
        return arr[range];

            return arr[..3];    //GetFirstThreeElements

            return arr[^3..];   //GetLastThreeElements

            return arr[3..6];   //GetThreeElementsFromMiddle
    }
```

## Array sorting

```c#
arr[2] = new Emp { EmpNo = 2, Name = "Harsh", Basic = 22335, DeptNo = 20 };

Array.Sort(arr); //error
```

```c#
 static void Main()
 {
     Employee1[] arr = new Employee1[5];
     arr[0] = new Employee1 { EmpNo = 5, Name = "Junaid", Basic = 12335, DeptNo = 10 };
     arr[1] = new Employee1 { EmpNo = 2, Name = "Abhi", Basic = 22335, DeptNo = 20 };

     Array.Sort(arr, new Employee1()); //IComparer   //sort the elements in arr using specified IComparer generic interface\

      Array.Sort<Employee2>(arr);  //IComparable
 }

  public class Emp
 {
     public int EmpNo { get; set; }
    .
    .
 }
// IF IComparer THEN MUST
 public class Employee1 : IComparer<Employee1> //IComparer
 {
     public int EmpNo { get; set; }.........
     public int Compare(Employee1? x, Employee1? y)  //takes 2
    {
        if (x.EmpNo > y.EmpNo)
            return 1;   // 1 for true
        else if (x.EmpNo < y.EmpNo)
            return -1;
        else
            return 0;
    }
 }

// IF IComparable THEN MUST
    public class Employee2 : IComparable<Employee2>  //IComparable
    {
        public int EmpNo { get; set; }.......
         public int CompareTo(Employee2? other)
        {
            //return string.Compare(this.Name, other.Name);
            if (this.Basic > other.Basic)
                return 1;
            else if (this.Basic < other.Basic)
                return -1;
            else
        }
    }
```

## Tuple

```c#
 /*
 Dont use Tuples, use ValueTuple
  If you want to pass many arguments to pass then Tuple is used
   Tuple class is that is a reference-type with memory allocation on the heap.
   Due to allocations and garbage collection pressure,
    using it can lead to CPU-intensive operations and major performance issues in our system.

  The ValueTuple on the other hand is a lightweight value type object
      and has its memory stored on the stack.

  ValueTuple is a mutable struct and exposes its elements as fields. .
 In terms of performance, flexibility, and reusability the ValueTuple is better.

  */
 static void Main()
 {
     //Tuple<int, string> t1 = new Tuple<int, string>(1, "Vikram");  //this is longer way to declare tuple
     var t1 = new Tuple<int, string>(1, "Vikram");  //shorter way to declare tuple
     Console.WriteLine(t1.Item1);    //1
     Console.WriteLine(t1.Item2);    //Vikram

     var t2 = Tuple.Create(1, "Vikram");    //another way to create tuple

     var t3 = Tuple.Create(1, 2, 3, 4, 5, 6, 7);  //max 7
     //var t3a = Tuple.Create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12); //ERROR - max 7

     var nestedTuple = Tuple.Create(1, 2, 3, 4, 5, 6, 7, Tuple.Create(8, 9, 10, 11, 12));
     Console.WriteLine(nestedTuple.Item7);
     Console.WriteLine(nestedTuple.Rest.Item1.Item1);  //8
     Console.WriteLine(nestedTuple.Rest.Item1.Item5);  //12
 }
    //to pass tuple to a function do as below
 static void F1(Tuple<int, string> t1)
 {
     Console.WriteLine(t1.Item1);
     Console.WriteLine(t1.Item2);
 }
 static void F2(Tuple<int, int, int, int, int, int, int, Tuple<int, int, int, int, int>> nestedTuple)
 {
     Console.WriteLine(nestedTuple.Item7);
     var t = nestedTuple.Rest;

     Console.WriteLine(t.Item1);  //8
     Console.WriteLine(t.Item5);  //12

 }
```

## ValueTuple

```c#
  static void Main()
  {
      ValueTuple<int, int> vt0 = new ValueTuple<int, int>(10, 20);
      (int, int) vt1 = (1, 2);  //shorter way

      var vt2 = (1, 2); //shorter way
      Console.WriteLine(vt2.Item1);
      Console.WriteLine(vt2.Item2);

      //value tuple with named fields
      (int lastYear, int currentYear) namedValueTuple = (2021, 2022);
      Console.WriteLine(namedValueTuple.lastYear);
      Console.WriteLine(namedValueTuple.currentYear);

      var rightHandNamedValueTuple = (language: "C#", tool: "Laptop", occupation: "Developer");
      Console.WriteLine(rightHandNamedValueTuple.language);

      //ValueTuples eight items:
      var valueTuple = ("my", "name", "is", "john", "doe", "and", "I", "am", 1000, "years", "old", true);
  }

  //value tuple as a parameter
  public static string TakeInAValueTuple((int legCount, bool isBlue) organism)
  {
      var hasAtLeastFourLegs = organism.legCount >= 4;
      var isBlue = organism.isBlue;
      return $"hasAtLeastFourLegs : {hasAtLeastFourLegs} and isBlue : {isBlue}";
  }

  //value tuple as a return type
  public static (bool isDay, string greeting) ReturnAValueTuple()
  {
      if (DateTime.Now.Hour < 12)
          return (isDay: true, greeting: "Good Morning");
      return (isDay: false, greeting: "Good Evening");
  }
```

### more about tuples

[https://code-maze.com/csharp-tuple/](https://code-maze.com/csharp-tuple/)

[https://code-maze.com/csharp-valuetuple-vs-tuple/](https://code-maze.com/csharp-valuetuple-vs-tuple/)

## ImplicitVariables

```c#
    static void Main(string[] args)
    {
        //can only be used for local variables, not for class level variables,
        //not for func parameters or return values
        //int i = 100;
        var i = 100;  //implicit variable

        //var j;  //error here what is type??

        var s = 1243;
        //s = ""; //error  //once type is assigned, you cant change it again
        s = 100;

        int a = 100;
        var b = 100;

        Console.WriteLine(i.GetType());
    }
```

## Collections

```c#
 All possible array initialization syntaxes
    string[] array = new string[2]; // creates array of length 2, default values
    string[] array = new string[] { "A", "B" }; // creates populated array of length 2
    string[] array = { "A" , "B" }; // creates populated array of length 2
    string[] array = new[] { "A", "B" }; // creates populated array of length 2
    string[] array = ["A", "B"]; // creates populated array of length 2
```

```c#


 static void Main()
 {
     ArrayList objArrayList = new ArrayList();
     objArrayList.Add("Vikram");
     objArrayList.Add(100);
     objArrayList.Add(1.1);
     objArrayList.Add(true);    //you can add various types of data in the collection

     objArrayList.Remove("Vikram");
     objArrayList.RemoveAt(2);  //index
     ArrayList o2 = new ArrayList();

     objArrayList.AddRange(o2);

     objArrayList.Insert(0, "new"); ////insert AN elemt of colln into arraylist at specified index
     objArrayList.InsertRange(0, o2);   //insert elemnts of colln into arraylist at specified index

     objArrayList.RemoveRange(0, 3); //index, number of items to remove

     //objArrayList.IndexOf
     //objArrayList.LastIndexOf
     //objArrayList.BinarySearch

     //objArrayList.Clear

     //objArrayList.Contains("new");
     object[] arr = new object[objArrayList.Count];
     objArrayList.CopyTo(arr);

     ArrayList o3 = objArrayList.GetRange(0, 3); //returns a subset of the arraylist

     //assumin objArrayList - 10,20 30 ,40
     //o2 - 5 15 25
     objArrayList.SetRange(0, o2);
     //objArrayList - 5 15 25 ,40

     object[] arr2 = objArrayList.ToArray();

     //objArrayList[0] = 10;  //objArrayList.this[0] = 10; -- uses an indexer
     Console.WriteLine( objArrayList.Count );
     foreach (object item in objArrayList)
     {
         Console.WriteLine(item);
     }
 }
```

## GenericsExample

```c#
 static void Main(string[] args)
{
            MyStack<int> o1 = new MyStack<int>(3);
            o1.Push(10);
}
```

```c#
class MyStack<T>
    //where T : class  //- T must be a reference type
    //where T : struct - T must be a value type
    //where T : ClassName - T must be either ClassName or a derived class
    //where T : InterfaceName - T must be a class that implements InterfaceName
    //where T : new() //- T must have a no parameter constructor

    //constraints can be combined. new() must appear at the end if new() is used
    //where T : ClassName, InterfaceName
    //where T : ClassName, InterfaceName, new()
    {
        T[] arr;
        public MyStack(int Size)
        {
            //T o = new T();

            arr = new T[Size];
        }
        int Pos = -1;
        public void Push(T i)
        {
            if (Pos == (arr.Length - 1))
                throw new Exception("Stack full");
            arr[++Pos] = i;
        }
        public T Pop()
        {
            if (Pos == -1)
                throw new Exception("Stack Empty");
            return arr[Pos--];
        }
    }
```

## Delegates
Call a function indirectly, similar to  function poitners in c++
```c#

    //step1 : create a delegate class that matches the func signature
    public delegate void Del1();
    public delegate int DelAdd(int a, int b);

    //Object
    //Delegate
    //MulticastDelegate
    //Del1

 internal class Program
    {
        static void Main1()
        {

            //step 2 : create a delegate reference and
            //point it to an object of the delegate class.
            //The delegate object will take the func name as a parameter

            Del1 objDel = new Del1(Display);  //OR like below line
            Del1 objDel = Display;   //<--

            //step 3: call the func via the delegate reference
            objDel();
        }
        static void Main2()
        {
            Del1 objDel = Display;
            objDel();
            objDel = Show;
            objDel();
            objDel += Show;  //if done like this then it adds onto it like a queue
            objDel();

            Console.WriteLine();
            objDel += Display;
            objDel();

            Console.WriteLine();
            objDel -= Display;   //here deleted
            objDel();
        }
         static void Main3()
        {
            Del1 objDel = Display;
            objDel();

            Console.WriteLine();
            objDel += Show;
            //objDel();

            Console.WriteLine();
            objDel += Display;
            //objDel();

            Console.WriteLine();
          //  objDel -= Display;
            objDel();


            Console.WriteLine();
            objDel -= Display;
            objDel();

            //Console.WriteLine();
            //objDel -= Show;
            //objDel();


        }

        static void Main4()
        {
            DelAdd oDelAdd = Add;
            oDelAdd += Subtract;
            Console.WriteLine(oDelAdd(10, 5));
        }
        static void Main5()
        {
            Del1 objDel = (Del1)Delegate.Combine(new Del1(Display), new Del1(Show), new Del1(Display));
            objDel();

            Console.WriteLine();
            //objDel = (Del1)Delegate.Remove(objDel, new Del1(Display));
            objDel = (Del1)Delegate.RemoveAll(objDel, new Del1(Display));
            objDel();
        }
        static void Main7()
        {
            Del1 objDel = Class1.Display;
            objDel();

            Class1 o = new Class1();
            objDel = o.Show;
        }
    }

```

```c#
    static void Main()
    {
        Console.WriteLine(CallMathOperation(Add, 10, 6));
        Console.WriteLine(CallMathOperation(Subtract, 10, 3));
    }
    //pass a func as a parameter.
    //called func receives it as a delegate
    static int CallMathOperation(DelAdd objMath, int a, int b)
    {
        return objMath(a, b);
    }
```

## Action Func Predicate

### **Action** is used to call functions which have **void** return type

```c#

    static void Main1()
    {
        Action o1 = Display;
        o1();

        Action<string> o2 = Display;
        o2("a");

        Action<string, int,bool> o3 = Display;  //upto 16 paramaters
        o3("a",1,false);
    }
```

### **Func** is used to call functions that have return value other than void

```c#
static void Main()
    {
        Func<string> o1 = GetTime;
        Console.WriteLine(o1());
        Func<int,int> o2 = GetDouble;   //the last parameter is always areturn type
        Console.WriteLine(o2(10));
        Func<int, int, int> o3 = Add;
        Console.WriteLine(o3(10,5));
        Func<int,bool> o4 = IsEven;
        Console.WriteLine( o4(10));
    }
```

### **Predicate** is used to call functions that have only **1** parameter with **bool** return type

```c#
static void Main()
    {
        Predicate<int> o5 = IsEven; //IsEven function with return tye bool and 1 param
        Console.WriteLine( o5(10));

        Employee emp = new Employee { Basic=11000};
        Predicate<Employee> o6 = IsBasicGreaterThan10000;
        Console.WriteLine(o6(emp));
    }
```

## Anonymous method

```c#
static void Main()
    {
        int i = 100;
        Action o1 = delegate()  //copy paste the function definition here and and change name to delegate --> AnonymousMethod
        {
            i++;
            Console.WriteLine("Anon method called" +i);
        };
        o1();   //gets called here

        Func<int, int, int> o2 = delegate(int a , int b)
        {
            return a + b;
        };

        Console.WriteLine(o2(10,5));
    }
    static int Add(int a, int b)
    {
        return a + b;
    }
```

## Lambda function

```c#
static void Main1()
{
    Func<int, int> o1 = delegate(int a)
    //{
    //    return a * 2;
    //};

    //Func<int, int> o1 =  ( a) =>
    //     a * 2;

    //Func<int, int> o1 = (a) => a * 2;
    Func<int, int> o1 = a => a * 2;
    Console.WriteLine(o1(10));

    Func<string> o2 = () => DateTime.Now.ToLongTimeString();
    Console.WriteLine(o2());
    Func<int, int, int> o3 = (a, b) => a + b;
    Console.WriteLine(o3(10,5));
    Func<int, bool> o4 = a => a % 2 == 0;
    Console.WriteLine(o4(10));
    Func<int, bool> o5 = a => {
        if (a % 2 == 0)
            return true;
        else
            return false;
    };
    Console.WriteLine(o5(10));
    Predicate<Employee> o6 = obj => obj.Basic > 10000;

    Employee emp = new Employee { Basic = 11000 };
    Console.WriteLine(o6(emp));

    Action o7 = () =>           //if method has no return value then must use curly {}
    {
        Console.WriteLine("Display called");
    };
    o7();
    Action<string> o8 = s =>
    {
        Console.WriteLine("Display called" + s);
    };
    o8("a");
}
```

## Exception Handling

```c#

static void Main()// finally block
        {
            Class1 obj = new Class1();
            try
            {
                //obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }
            catch (FormatException ex)
            {
                Console.WriteLine("FormatException occurred");
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("NRException occurred");
            }
            //catch (DivideByZeroException ex)
            //catch (ArithmeticException ex)
            catch (SystemException ex) //base class exception has to caught after derived class exceptions
            {
                Console.WriteLine("DBException occurred");
            }
            catch (Exception ex) //catches all unhandled exceptions
            {
                Console.WriteLine(ex.Message);
            }
            //finally runs when Exception does not occur,
            //or Exception occurs and is handled or
            //Exception occurs and is NOT handled , after finally wont run in this case
            finally
            {
                Console.WriteLine("finally");

            }
            Console.WriteLine("after finally");
        }

```

```c#

static void Main()
        {
            Class1 obj = new Class1();
            try
            {
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }

            catch (ApplicationException ex) //all user defined exceptions that have not been handled before
            {
                Console.WriteLine(ex.Message);
            }
            catch (SystemException ex) //all .net exceptions that have not been handled before
            {
                Console.WriteLine(ex.Message);
            }
        }
    }

    public class Class1
    {
        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //throw an exception
                    //Exception ex = new Exception();
                    //Exception ex = new Exception("Invalid P1");
                    //throw ex;
                    //throw new Exception("Invalid P1");
                    //throw new InvalidP1Exception();
                    throw new InvalidP1Exception("Invalid P1");
                }
            }
        }
    }

    public class InvalidP1Exception : ApplicationException
    {
        public InvalidP1Exception(string message) : base(message)
        {
        }
    }

```

## Dispose

```c#

internal class Program
    {

        static void Main9()
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();
            //o.Display();  //you can not call Display again once the dispose is called or
        }
        static void Main2()
        {
            using (Class1 o = new Class1())    //using will automatically call Dispose method, but hence the prerequisite is class must implement IDisposable
            {
                o.Display();
            }
        }
    }
    public class Class1 : IDisposable   //must inherit from this interface
    {
        public Class1()
        {
            //open file here
            //open db here
        }
        bool isDisposed;
        public void Display()
        {
            CheckForDisposed();
            Console.WriteLine("Display called");
        }
        public void Dispose()
        {
            CheckForDisposed();
            //close file
            //close db conn
            Console.WriteLine("Dispose code called. Write code here instead of Destructor");
            isDisposed = true;
        }
        private void CheckForDisposed() //check added for dispose not to be called again
        {
            if (isDisposed)
                throw new ObjectDisposedException("Class1");
        }
    }
```
## Events
#### all events have return type of **void**
```c#
 //step 1 : create a delegate class having the same signature as the event
 public delegate void Del1();

 public class Class1
 {
     //step 2 : declare the event of the delegate type
     public event Del1 InvalidP1;

     private int p1;
     public int P1
     {
         get
         {
             return p1;
         }
         set
         {
             if (value < 100)
                 p1 = value;
             else
             {
                 //step 3 : raise the event whenever you want to 
                 if(InvalidP1!=null)
                     InvalidP1();
             }
         }
     }
 }
```
## Language Features
### 1. AnonymousTypes

```c#
static void Main2()
{
    //Class1 o = new Class1{a=10,b="aaa",c=1.2};
    //var o = new {a=10,b="aaa",c=1.2};
    var o = new { Id = 10, Name = "aaa", Salary = 1.2, IsRetired = false };
    var o2 = new { Id = 11, Name = "bbb", Salary = 3.2 };
    Console.WriteLine(o.Id);
    Console.WriteLine(o.GetType());
    Console.WriteLine(o2.GetType());
}
```
### 2. PartialClasses

```c#
namespace PartialClasses
{
    //PARTIAL CLASSES
    //partial classes must be in the same assembly
    //partial classes must be in the same namespace
    //partial classes must have the same name
    public partial class Class1
    {
        public int i;
    }
    public partial class Class1
    {
        public int j;
    }
    public class Program
    {
        public static void Main3()
        {
            Class1 o = new Class1();
            //o.
        }
    }
}
namespace PartialClasses
{
    public partial class Class1
    {
        public int k;
    }
}
```
### 3. PartialMethods

```c#
public class MainClass
{
    public static void Main1()
    {
        Class1 o = new Class1();
        Console.WriteLine(o.Check());
        Console.ReadLine();
    }
}
//Partial methods can only be defined within a partial class.
//Partial methods must return void.
//Partial methods can be static or instance level.
//Partial methods cannnot have out params
//Partial methods are always implicitly private.
public partial class Class1
{
    private bool isValid = true;
    partial void Validate();
    public bool Check()
    {
        //.....
        Validate();
        return isValid;
    }
}
public partial class Class1
{
    partial void Validate()
    {
        //perform some validation code here
        isValid = false;
    }
}
```

### 4. ExtensionMethods

```c#
 public class MainClass
 {
     public static void Main2()
     {
         int i = 100;
         i = MyExtClass.Add(i, 10);
         MyExtClass.Display(i);
         
         string s = "aaa";
         MyExtClass.Show(s);
     }
     public static void Main()
     {
         ClsMaths oMaths = new ClsMaths();
         Console.WriteLine(oMaths.Add(10, 5));
         Console.WriteLine(oMaths.Multiply(10, 5));

         Console.WriteLine(oMaths.Subtract(10, 5));

         //Console.WriteLine(MyExtClass.Subtract(oMaths,10,5));
     }
 }

 //step 1 : create a static method in a static class

 public static class MyExtClass
 {
     //step 2 : the first parameter of the ext method must be the type
     //for which you are writing the ext method, preceded by the this keyword
     public static void Display(this int i)
     {
         Console.WriteLine(i);
     }
     public static int Add(this int i, int j)
     {
         return i + j;
     }
     public static void Show(this string s)
     {
         Console.WriteLine(s);
     }

     //if you define an ext method for the base class,
     //it is also available for the derived class

     public static void ExtMethodForBaseClass(this object o)
     {
         Console.WriteLine(o);
     }

     //if you define an ext method for the interface,
     //it is also available for the all classes that implement the interface
     public static int Subtract(this IMathOperations oIM, int a, int b)
     {
         return a -b;
     }
```
## Language Integrated Query
#### refer handwritten book

```c#
  Employee emp = lstEmp.Single(e => e.EmpNo == 1); //one record = okay
 //Employee emp = lstEmp.Single(e => e.EmpNo == 10);  //no records = error
 //Employee emp = lstEmp.Single(e => e.Basic > 5000); //multiple records - error


 //Employee emp = lstEmp.SingleOrDefault(e => e.EmpNo == 1); //one record = okay
 //Employee emp = lstEmp.SingleOrDefault(e => e.EmpNo == 10); //no records=null
 //Employee emp = lstEmp.SingleOrDefault(e =>  e.Basic > 5000);//multiple records - error


    //deffered execution 
    var emps = from emp in lstEmp select emp;   //query is not fire here directly

    Console.WriteLine();
    lstEmp.RemoveAt(0);

    foreach (var emp in emps)   //here query for emps is fired so always gives latest data
    {
        Console.WriteLine(emp.Name + "," + emp.EmpNo);
    }
    Console.ReadLine();



     //immediate execution 
    emps = emps.ToList();  //.ToArray .ToDictionary  //yahi pe query fire hoke store ho jata hai data in emps
    //Employee [] arrEmps = emps.ToArray();
    //Dictionary<int, Employee> d = emps.ToDictionary(e => e.EmpNo);

    group
    AddRecs();
    var emps = from emp in lstEmp
            group emp by emp.DeptNo;
    foreach (var item in emps)
    {
        Console.WriteLine(item.Key); //deptno
        foreach (var e in item)  //e is an Employee, item is a grouping of Employee
        {
            Console.WriteLine(e);
        }
        Console.WriteLine();
    }
```

## Threading

```c#
    Thread t1 = new Thread(new ThreadStart(Func1)); //ThreadStart represents method that executes on thread
    Thread t2 = new Thread(Func2);
    t1.IsBackground = true;  //if t1 is background then now main will not wait to let t1 finish, when main is over then program will be done
    //t2.IsBackground = true;

    t1.Start(); //starts function on separate thread
    t2.Start();

    // t2.IsBackground = true; // if main finish it does not wait for background threads to complete its execution  

    for (int i = 0; i < 1; i++)
    {
        Console.WriteLine("Main : " + i);
    }
    static void Func1()
    {
        for (int i = 0; i < 10; i++)
        {
            Console.WriteLine("First : " + i);
            //Thread.Sleep(5000);
        }
    }
    static void Func2()
    {
        for (int i = 0; i < 10; i++)
        {
            Console.WriteLine("Second : " + i);
            //Thread.Sleep(5000);
        }
    }
```

```c#
    t1.Join(); // here main is waiting for t1 to finish first then will proceed to next line //blocking line
    Console.WriteLine("this code should only run after Func1 is over");
```

```c#
    t1.Priority = ThreadPriority.Highest;  //but still no guarantee that it will happen in this way
    t2.Priority = ThreadPriority.Lowest;

            // if(t1.ThreadState == ThreadState.Running) //to check state
```



```c#
    AutoResetEvent wh = new AutoResetEvent(false);
    Thread t1 = new Thread(delegate ()
    {
        for (int i = 0; i < 200; i++)
        {
            Console.WriteLine("f1:" + i);
            if (i % 50 == 0)
            {
                //instead of Suspend, use this
                Console.WriteLine("waiting");
                wh.WaitOne(); //when this line executes, blocks current thread until current waithandle receives a signal
            }
        }
    });
    Console.WriteLine("t1 starting");
    t1.Start();
    Console.WriteLine("t1 starteedddd");
    Thread.Sleep(10000);
    Console.WriteLine("below sleep");
    Console.ReadLine();
    Console.WriteLine("resuming 1....");
    wh.Set();   //sets event of state to signaled, allows waiting threads to proceed

    //Thread.Sleep(2000);
    Console.ReadLine();
    Console.WriteLine("resuming 2....");
    wh.Set();

```

```c#
    Thread t1 = new Thread(new ParameterizedThreadStart(Func1));
    Thread t2 = new Thread(Func2);  //allows OBJECT to be paassed to thread whe thread is started
    int[] arr = new int[2] { 10, 20 };  //to pass many values to a function
    t1.Start(arr);
    //t1.Start("aaa");
    t2.Start("bbb");

    for (int i = 0; i < 100; i++)
    {
        Console.WriteLine("Main : " + i);
    }

    static void Func1(object obj)
    {
        int[] arr = (int[]) obj;

        for (int i = 0; i < 100; i++)
        {
            Console.WriteLine("First : " + i + obj.ToString());
        }
    }
    static void Func2(object obj)
    {
        for (int i = 0; i < 100; i++)
        {
            Console.WriteLine("Second : " + i + obj.ToString());
        }
    }
```


## ThreadPool
- any thread created in threadpool is background thread

```c#
static object lockObject = new object();
static void Main()
{
    Thread t1 = new Thread(new ThreadStart(FuncLock));

    t1.Start();
}

  static void FuncLock()
  {
      lock (lockObject) //Monitor.Enter(lockObject)
      {
        ... code here
      }
  }

static void FuncMonitor()
 {
     Monitor.Enter(lockObject);
     {
        ... code here
     }  //no braeckets needed
     Monitor.Exit(lockObject);
 }


```
## Async Code With Delegates

[async- await confusion solved (link)](https://www.youtube.com/watch?v=c3c-LLdjlGc)

[asynchronous and non-blocking calls? also between blocking and synchronous](https://stackoverflow.com/questions/2625493/asynchronous-and-non-blocking-calls-also-between-blocking-and-synchronous)

### Rules: await
#### 1. **await** can be only used to call an awaitable function. An awaitable function is a function that is returning a **task**
#### 2. If a function has an **await**, it must be marked **async**
#### 3. If main is marked **async**, then it must return a **Task**

```c#
static async Task Main()
{
    Console.WriteLine("Before");
    //string message = DoWorkAsync();  //waiting call, blocking call
    string message = await DoWorkAsync();  //waiting call, non blocking call, starts on diff thread
    Console.WriteLine(message);
    Console.WriteLine("After");
    Console.ReadLine();
}

---------------------------------------------------------------------------------------
 static void Main()
 {
     Action o1 = Display;
     Console.WriteLine("before");
     o1.BeginInvoke(null, null);    //starts on diff thread in async    (AsyncCallback, Object)
     Console.WriteLine("after");
     Action<string> o1 = Display;
    Console.WriteLine("before");
    o1.BeginInvoke("passed value",null, null);
 }

---------------------------------------------------------------------------------------

 static void Main3()
 {
     Func<string,string> o1 = Display;
     Console.WriteLine("before");
     o1.BeginInvoke("passed value", CallBackFunc, null);
    // o1.BeginInvoke("passed value", new AsyncCallback(CallBackFunc), null);
     Console.WriteLine("after");
     Console.ReadLine();
 }

---------------------------------------------------------------------------------------

 static string Display(string s)
 {
     Thread.Sleep(5000);
     Console.WriteLine("display " + s);
     return s.ToUpper();
 }
 static void CallBackFunc(IAsyncResult ar) 
 {
     Console.WriteLine("call back func called");

 }

---------------------------------------------------------------------------------------


 static void Main4()
{
    Func<string, string> o1 = Display;
    Console.WriteLine("before");
    IAsyncResult ar1 = o1.BeginInvoke("passed value", delegate(IAsyncResult ar)
    {
        Console.WriteLine("call back func called");
        string retval = o1.EndInvoke(ar);
        Console.WriteLine(retval);
    }, null);
    Console.WriteLine("after");
    Console.ReadLine();
}
static string Display(string s)
{
    Thread.Sleep(5000);
    Console.WriteLine("display " + s);
    return s.ToUpper();
}
```

## Task
```c#
Action objAction2 = Func2;
Task t2 = new Task(objAction2);

t1.Start();
------------------------------------------------------------------------

Task t1 = Task.Run(objAction1);   //Task.Run cant call function that has parameter  //new task + Start()
------------------------------------------------------------------------

 Task t2 = Task.Factory.StartNew(Func2, "bbbb"); // Can call function with parameter

 static void Func2(object obj)
 {
     for (int i = 0; i < 10; i++)
     {
         Console.WriteLine("second Func called {0},{1}", i, obj.ToString());
     }
 }
------------------------------------------------------------------------
//calling methods with ret type
 Task<int> t2 = new Task<int>(Func2, "bbb");
------------------------------------------------------------------------
  t2.Wait();
  Console.WriteLine(t2.Result); 
    // both above are waiting and blocking call

```


## MVC Core
```c#
    static void Connect()
    {
        SqlConnection cn = new SqlConnection();
        //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
        cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
        try                          👈🏽
        {
            cn.Open();
            Console.WriteLine("success");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
        finally
        {
            cn.Close();               👈🏽
        }
    }
---------------------------------------------------------------------------------------------
    static void Connect2()
    {
        using (SqlConnection cn = new SqlConnection())               👈🏽
        {
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            
        }
        
    }
---------------------------------------------------------------------------------------------
    static void Insert1()
    {
        SqlConnection cn = new SqlConnection();
        //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
        cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
        try
        {
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = CommandType.Text;
            cmdInsert.CommandText = "insert into Employees values(4,'Shivani', 12345, 30)";       👈🏽
            cmdInsert.ExecuteNonQuery();

            Console.WriteLine("success");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
        finally
        {
            cn.Close();
        }
    }
---------------------------------------------------------------------------------------------
    static void Insert2(Employee obj)            👈🏽
    {
        try
        {
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = CommandType.Text;
            cmdInsert.CommandText = $"insert into Employees values({obj.EmpNo},'{obj.Name}', {obj.Basic}, {obj.DeptNo})";            👈🏽

            Console.WriteLine(cmdInsert.CommandText);
            Console.ReadLine();
            cmdInsert.ExecuteNonQuery();

            Console.WriteLine("success");
        }
    }
---------------------------------------------------------------------------------------------
    //parameters
    static void Insert3(Employee obj)
    {
        try
        {
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = CommandType.Text;
            cmdInsert.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";   👈🏽

            cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);           👈🏽
            cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
            cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
            cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

            cmdInsert.ExecuteNonQuery();

            Console.WriteLine("success");
        }
    }
---------------------------------------------------------------------------------------------
    //stored procedure
    static void Insert4(Employee obj)
    {
        try
        {
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = CommandType.StoredProcedure;           👈🏽
            cmdInsert.CommandText = "InsertEmployee";           👈🏽

            cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
            cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
            cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
            cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
            cmdInsert.ExecuteNonQuery();

        }
    }
---------------------------------------------------------------------------------------------
    //select singke value
        static void SelectSingleValue()
        {
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select Name from Employees where EmpNo=1";
                //cmd.CommandText = "select count(*) from Employees ";
                //cmd.CommandText = "select * from Employees ";
                object retval = cmd.ExecuteScalar();           👈🏽
                Console.WriteLine(retval);
            }
        }
---------------------------------------------------------------------------------------------
    //select multiple values
    static void DataReader1()
    {
        try
        {
            cn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = cn;
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "select * from Employees ";
            
            SqlDataReader dr = cmd.ExecuteReader();         👈🏽
            //dr.HasRows  //---returns true if at least 1 row
            while (dr.Read())          👈🏽
            {
                Console.WriteLine(dr[1]);
                Console.WriteLine(dr["Name"]);
                //Employee o = new Employee();
                //o.Name = dr["Name"].ToString();
                //o.EmpNo = (int)dr["EmpNo"];

                //o.Name = dr.GetString(1);
                //o.Name = dr.GetString("Name");
                //o.EmpNo = dr.GetInt32("EmpNo");
            }
            dr.Close();         👈🏽
            Console.WriteLine("success");
        }
    }

---------------------------------------------------------------------------------------------

static void DataReader2()
{
    try
    {
        cn.Open();
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = cn;
        cmd.CommandType = CommandType.Text;
        cmd.CommandText = "select * from Employees;select * from departments ";

        SqlDataReader dr = cmd.ExecuteReader();

        while (dr.Read())
        {
            Console.WriteLine(dr[1]);
            Console.WriteLine(dr["Name"]);
            //Employee o = new Employee();
            //o.Name = dr["Name"].ToString();
            //o.EmpNo = (int)dr["EmpNo"];

            //o.Name = dr.GetString(1);
            //o.Name = dr.GetString("Name");
            //o.EmpNo = dr.GetInt32("EmpNo");
        }
        Console.WriteLine();
        dr.NextResult();         👈🏽 //advances SQldatareader to next record
        while (dr.Read())
        {
            Console.WriteLine(dr["DeptName"]);
        }
        dr.Close();              👈🏽

    }
}
---------------------------------------------------------------------------------------------
    static void Transactions()
    {
        cn.Open();
        SqlTransaction t = cn.BeginTransaction();         👈🏽

        SqlCommand cmdInsert = new SqlCommand();
        cmdInsert.Connection = cn;
        cmdInsert.Transaction = t;

        cmdInsert.CommandType = System.Data.CommandType.Text;
        cmdInsert.CommandText = "insert into Employees values(10, 'Shweta', 12345, 30)";

        SqlCommand cmdInsert2 = new SqlCommand();
        cmdInsert2.Connection = cn;
        cmdInsert2.Transaction = t;

        cmdInsert2.CommandType = System.Data.CommandType.Text;
        cmdInsert2.CommandText = "insert into Employees values(20, 'Shweta', 12345, 30)";
        try
        {
            cmdInsert.ExecuteNonQuery();
            cmdInsert2.ExecuteNonQuery();
            t.Commit();         👈🏽
            Console.WriteLine("no errors- commit");
        }
        catch (Exception ex)
        {
            t.Rollback();         👈🏽
            Console.WriteLine("Rollback");
            Console.WriteLine(ex.Message);
        }
        cn.Close();
    }

```


### HTML helpers/ Tag helpers

    What is the difference between Html.Textbox and Html.TextboxFor?

```c#
1:  @Html.TextBox("Name")
2:  Html.TextBoxFor(m => m.Name)

//  will both produce
<input id="Name" name="Name" type="text" />
```

0. The **TextBoxFor** is a newer MVC input extension introduced in MVC2 & is Strongly typed while **TextBox** is not strongly typed.
1. The typed **TextBoxFor** will generate your input names for you. This is usually just the property name but for properties of complex types can include an underscore such as 'customer_name'
2. Using the typed TextBoxFor version will allow you to use compile time checking. So if you change your model then you can check whether there are any errors in your views.
3. The main benefit of the newer strongly typed extensions is to show any errors / warnings at compile-time rather than runtime.
4. Html.TextBox amd Html.DropDownList are not strongly typed and hence they doesn't require a strongly typed view. This means that we can hardcode whatever name we want. On the other hand, Html.TextBoxFor and Html.DropDownListFor are strongly typed and requires a strongly typed view, and the name is inferred from the lambda expression.

```c#

<input asp-for="Basic"/> //automatically has auto binding

<input id="Name" name="Name" value="Name" type="text" />    //here we have to generate auto binding name =value same

TextBox @Html.TextBox("textBasic", Model.Basic) //does not use model binding, we have to mention it
//Model.Basic means Model mdla basic, model can be Employee
TextBoxFor @Html.TextBoxFor(x => x.Basic)   //uses model binding

// all above are same
```

```c#
    DropDownList @Html.DropDownList("ddlDepts", Model.Departments)  //

    DropDownListFor @Html.DropDownListFor(model => model.DeptNo, Model.Departments)

    DropDownListFor @Html.DropDownListFor(model => model.DeptNo, ViewBag.Departments as IEnumerable<SelectListItem>)

    <select asp-for="DeptNo" asp-items="Model.Departments"></select>

    //generaed equivalent code
    <select id="DeptNo" name="DeptNo">
        <option value="10">SALES</option>
        <option value="20">IT</option>
        <option value="30">HR</option>
    </select>
```

#### to send data from view to control 2 options are there

1. viewbag / viewdata/ tempdata/ session
2. view model - view model is Model class created specially for the view/ Model that has extra info to be used by view
   - create view modelwith extra info that you have to pass
   - use that model in view
   - send from controller to view


## Entity Framework

1. DB First approach

   - Db created first/ already there and classes are generated

2. Code First approach
   - Classes are created and tables are generated
3. Model first
   - Generate the DB and generate the classes

### 1. DB first

    What will EF will do for you?
        -> Don't need to know db things, you just need to know collections

1. We need to Create DB, Generates model classes automatically (Mapping) eg. Employee table -> Employee class, column to properties
2. Generates class that inherits from DbContext
   - gives collection of model class. eg. Employee collection
     1. dbcontext will read value from Db and populates into this collection
     2. have methods, if value in collection changes, then read value from collection and update into db

#### Steps for DB First

1. Add Nuget Packages

   ```markdown
   Microsoft.EntityFrameworkCore
   Microsoft.EntityFrameworkCore.SqlServer
   Microsoft.EntityFrameworkCore.Tools
   ```

2. Package Manager Console

   ```markdown
   Scaffold-DbContext "Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=ActsDec2023;Integrated Security=true" Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models
   ```

   Note : read more at https://docs.microsoft.com/en-us/ef/core/managing-schemas/scaffolding?tabs=vs

3. Add EF service in $Program.cs$

   ```c#
   public static void Main(string[] args)
        {
            builder.Services.AddControllersWithViews();
            builder.Services.AddDbContext<ActsDec2023Context>(options =>
                        options.UseSqlServer(builder.Configuration.GetConnectionString("ActsDec2023Context")));
        }
   ```

4. Specify connection string $appsettings.json$

   ```json
   "ConnectionStrings": {
       "ActsDec2023Context": "Data Source=(localdb)\\MsSqlLocalDb;Initial Catalog=ActsDec2023;Integrated Security=true;MultipleActiveResultSets=true"
   }
   ```

5. Add controller with views, using Entity Framework

    ```c#
    public class EmployeesController : Controller
    {
        private readonly ActsDec2023Context _context;

        public EmployeesController(ActsDec2023Context context)  //dependency injection
        {
            _context = context;
        }
    }
    ```

## Controller code

```c#
    public class EmployeesController : Controller   //Controller here has support of View, ControllerBase doesn't have View support (Used in webapi coz swagger is therre for view)
    {
        private readonly ActsDec2023Context _context;   //reference to

        public EmployeesController(ActsDec2023Context context)
        {
            _context = context;
        }

        // GET: Employees
       public IActionResult Index()
        {
            //craete collection emp obj
            var list = _context.Employees;
            //emp collection is created // Department is populated here included in here
            var list2 = _context.Employees.Include(emp => emp.DeptNoNavigation);
            //return collection to view
            return View(list2); //deferred execution
            //return  View(list2.ToList());  //immediate execution
        }

        //same as above Index() action but with await async
        public async Task<IActionResult> Index()
        {
            var actsDec2023Context = _context.Employees.Include(e => e.DeptNoNavigation);
            return View(await actsDec2023Context.ToListAsync());
        }
```

```c#
 // POST: Employees/Create
 [HttpPost]
 [ValidateAntiForgeryToken]
 public async Task<IActionResult> Create([Bind("EmpNo,Name,Basic,DeptNo")] Employee employee)
 {                          //Bind here is used to Bind only the mentioned properties from the form post
     if (ModelState.IsValid)  //false: coz DeptNoNavigation is coming null
     {                       // soln: in ViewModelClass, make DeptNoNavigation Nullable (Department<pre>**?**</pre> DeptNoNavigation)
     // meaning --> DeptNoNavigation can contain null
         _context.Add(employee);    //better way is _context.Employee.Add(employee);
         await _context.SaveChangesAsync(); //wwhatever data in context is saved to the database, we just add it to colln
         return RedirectToAction(nameof(Index));//reiderct to actioion index
     }
     else{  //to check the errors why modelstate.isValid is false
        string s = "";
        foreach (var item in ModelState.Values)
        {
            foreach (var item1 in item.Errors)
            {
                s += item1.ErrorMessage;
            }
        }
     }
     ViewData["DeptNo"] = new SelectList(_context.Departments, "DeptNo", "DeptName", employee.DeptNo);//for dropdown list
     return View(employee);

 }
```

### 2. Code first

    What will EF will do for you?
        -> Don't need to know db things, you just need to know collections

1. We need to code Classes, Generates Database automatically eg. Employee class -> Employee table
2. Generates DB according to code - create DbContext Class
   - eg. DbSet<Employee> -->creates the Employee table
     1. dbcontext will read value from Db and populates into this collection
     2. have methods, if value in collection changes, then read value from collection and update into db

#### Steps for Code First

1.  Add Nuget Packages
    ```markdown
    Microsoft.EntityFrameworkCore
    Microsoft.EntityFrameworkCore.SqlServer
    Microsoft.EntityFrameworkCore.Tools
    ```
2.  Add Model class and DbContext class

    - Create Model class eg. `public partial class Employee { }`
    - Right-click and create model class, eg. `Employee.cs`
    - Write data fields members in it eg. `public int EmpNo {get; set;}`
    - To add key
      - `public int Id {get; set;}`
      - `public int EmployeeId {get; set;}`
      - `[Key]` //above code can work for primary key but use [Key]
      - `public int EmpNo {get; set;}`

3.  Add connection string in appsettings.json

    > conn string of Db to generate //data base name should be new else old will be overwritten

    ```c#
     "ConnectionStrings": {
         "EmpDbContext": "Data Source=(localdb)\\MsSqlLocalDb;Initial Catalog=EmpDb;Integrated Security=true;MultipleActiveResultSets=true"
     }
    ```

4.  Add EF service in Program.cs

    ```c#
    public static void Main(string[] args)
    {
        builder.Services.AddControllersWithViews();
        builder.Services.AddDbContext<EmpDbContext>(options =>
                    options.UseSqlServer(builder.Configuration.GetConnectionString("EmpDbContext")));
    }
    ```

5.  Package Manager Console

    - `Add-Migration InitialCreate` generates Migration script, this script is create in fluent api language, saved in folder called Migration, InitalCrereate ism just name, in that there is details what kind of databse to generate.
      Also has file having code BuildModel, thid code calls the migration script

    - `Update-Database`

6.  Then add controller

## WebAPI

    A way by which you can access some other application
    Web API allows access to service data from web browsers, mobile apps, and other devices.
    RESTful(Representational State Transfer)[State-->Data in app] --> Along with State being sent it is also representing what to do with the data or sending the instruction for what the state should do

### Create WebAPI MVC project

**\*while adding controller add from webapi dialogue box**

1. create webapi c# project
1. tick use controller
1. controller
   mvc empty controller --> blank
   mvc controller with read/write action --> it gives method, you write query inc lass ADO and connection string and all
   mvc controller with views, using Entity FrameWork --> it gives methods with db input code too
