namespace RefAndValue2
{
     internal class Program
    {
        static void Main1()
        {
            int i, j;
            Init(out i, out j);
            Swap(ref i,ref j);
            Print(in i);
            Print(j);
            //Console.WriteLine(i);
            //Console.WriteLine(j);
        }
        static void Swap(ref int a, ref int b) 
        {
            int temp = a;
            a = b;
            b = temp;
        }
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
    }
}
namespace RefAndValueTypes3 //passing reference types
{
    class Program
    {
        static void Main()
        {
            Class1 o = new Class1();
            o.i = 100;
            //DoSomething1(o);
            //DoSomething2(o);
            //DoSomething3(ref o);
            //DoSomething4(out o);
            DoSomething5(in o);
            Console.WriteLine(o.i);
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
    }
    public class Class1
    {
        public int i;
    }
}