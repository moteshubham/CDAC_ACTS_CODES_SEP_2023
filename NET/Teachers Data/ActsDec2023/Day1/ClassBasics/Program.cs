//using System;

namespace ClassBasics
{
    internal class Program
    {
        static void Main()
        {
            //Console.WriteLine("Hello, World!");
            //System.Console.WriteLine("Hello World");

            //Class1 o;  //o is a reference of type Class1
            //o = new Class1(); //new Class1() is an object of the class

            Class1 o = new Class1();
            o.Display();
            o.Display("string");

            Console.WriteLine(o.Add());
            Console.WriteLine(o.Add(10));
            Console.WriteLine(o.Add(10, 20));
            Console.WriteLine(o.Add(10, 20, 30));

        }
    }

   
    public class Class1 //: Object
    {
        public void Display()
        {
            Console.WriteLine("Display");
        }

        //function overloading
        public void Display(string s)
        {
            Console.WriteLine("Display"+ s);
        }

        //public int Add(int a, int b)
        //{ 
        //    return a + b;
        //}
        //public int Add(int a, int b, int c)
        //{
        //    return a + b + c;
        //}

        //default value
        //optional parameters

        //dfault params must be from right to left
        public int Add(int a=0 , int b = 0, int c=0 )
        {
            return a + b + c;
        }


    }
}
namespace N1
{
    public class Class1 { }
    namespace N2
    {
        public class Class1 { }
        public class Class2 { }
    }

}