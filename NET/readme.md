### GenericsExample

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

### Delegates

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

### Action Func Predicate

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

### Anonymous method

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

### Lambda function

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
