# Day4

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

            return names[^2];   // secod fro last   //E
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
      (int, int) vt1 = (1, 2);

      var vt2 = (1, 2);
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

     objArrayList.Insert(0, "new");
     objArrayList.InsertRange(0, o2);

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
            objDel += Show;  //if done like this then it adds onto it like a stack
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

**Action** is used to call functions which have **void** return type

```c#

        static void Main1()
        {
            Action o1 = Display;
            o1();

            Action<string> o2 = Display;
            o2("a");

            Action<string, int,bool> o3 = Display;
            o3("a",1,false);
        }
```

**Func** is used to call functions that have return value other than void

```c#
  static void Main()
        {
            Func<string> o1 = GetTime;
            Console.WriteLine(o1());
            Func<int,int> o2 = GetDouble;
            Console.WriteLine(o2(10));
            Func<int, int, int> o3 = Add;
            Console.WriteLine(o3(10,5));
            Func<int,bool> o4 = IsEven;
            Console.WriteLine( o4(10));
        }
```

**Predicate** is used to call functions that have only **1** parameter with **bool** return type

```c#
  static void Main()
        {
            Predicate<int> o5 = IsEven;
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
