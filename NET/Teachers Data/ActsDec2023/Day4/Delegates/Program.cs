using Delegates1;

namespace Delegates1
{
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

            Del1 objDel = new Del1(Display);

            //step 3: call the func via the delegate reference
            objDel();
        }
        static void Main2()
        {
            Del1 objDel = Display;
            objDel();
            objDel = Show;
            objDel();
        }
        static void Main()
        {
            Console.WriteLine("motemote");
            Del1 objDel = Display;
            objDel();

            Console.WriteLine();
            objDel += Show;
            objDel();

            Console.WriteLine();
            objDel += Display;
            objDel();

            Console.WriteLine();
            objDel -= Display;
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
            Console.WriteLine(oDelAdd(10,5));
        }
        static void Main5()
        {
            Del1 objDel =(Del1) Delegate.Combine(new Del1(Display), new Del1(Show), new Del1(Display));
            objDel();

            Console.WriteLine();
            //objDel = (Del1)Delegate.Remove(objDel, new Del1(Display));
            objDel = (Del1)Delegate.RemoveAll(objDel, new Del1(Display));
            objDel();
        }

        static void Display()
        {
            Console.WriteLine("display");
        }
        static void Display(string s)
        {
            Console.WriteLine("display"+ s);
        }
        static void Show()
        {
            Console.WriteLine("Show");
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
        static int Subtract(int a, int b)
        {
            return a - b;
        }
        static void Main9()
        {
            Del1 objDel = Class1.Display;
            objDel();

            Class1 o = new Class1();
            objDel = o.Show;
        }
    }

    public class Class1
    {
        public static void Display()
        {
            Console.WriteLine("class 1 display");
        }
        public void Show()
        {
            Console.WriteLine("class1 Show");
        }
    }
}


namespace Delegates2
{
    //step1 : create a delegate class that matches the func signature
    public delegate int DelAdd(int a, int b);


    internal class Program2
    {
        static void Main()
        {
            Console.WriteLine("motemote");
            Del1 objDel = Display;
            objDel();

            Console.WriteLine();
            objDel += Show;
            objDel();

            Console.WriteLine();
            objDel += Display;
            objDel();

            Console.WriteLine();
            objDel -= Display;
            objDel();


            Console.WriteLine();
            objDel -= Display;
            objDel();

            //Console.WriteLine();
            //objDel -= Show;
            //objDel();

            //Console.WriteLine(CallMathOperation(Add,10,6));
            //Console.WriteLine(CallMathOperation(Subtract, 10, 3));
        }
        //pass a func as a parameter.
        //called func receives it as a delegate
        static int CallMathOperation(DelAdd objMath, int a, int b) 
        {
            return objMath(a,b);
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
        static int Subtract(int a, int b)
        {
            return a - b;
        }
        static void Display()
        {
            Console.WriteLine("display");
        }
        static void Display(string s)
        {
            Console.WriteLine("display" + s);
        }
        static void Show()
        {
            Console.WriteLine("Show");
        }

    }

   
}