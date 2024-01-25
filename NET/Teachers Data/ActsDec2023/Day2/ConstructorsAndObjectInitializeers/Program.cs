namespace ConstructorsAndObjectInitializers1
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o1 = new Class1();
            Console.WriteLine(o1.i);

            Class1 o2 = new Class1(20);
            Console.WriteLine(o2.i);
        }
    }

    public class Class1
    {
        public int i;
        //public Class1()
        //{
        //    Console.WriteLine("no param cons called");
        //    i = 10;
        //}
        //public Class1(int i)
        //{
        //    Console.WriteLine("int cons called");
        //    this.i = i; //this is a reference to the current object
        //}
        public Class1(int i = 10)
        {
            Console.WriteLine("cons called");
            this.i = i; //this is a reference to the current object
        }
    }

}

namespace ConstructorsAndObjectInitializers2
{
    internal class Program
    {
        static void Main()
        {
            Class1 o1 = new Class1();
            o1.i = 10;
            o1.j= 20;   
            o1.k= 30;
            Console.WriteLine(o1.i);
            Console.WriteLine(o1.j);
            Console.WriteLine(o1.k);


            //object initializer
            //Class1 o2 = new Class1() { i = 10, j = 20, k = 30 };
            Class1 o2 = new Class1 { i = 10, j = 20, k = 30 };
            //Class1 o2 = new Class1 ( 10, 20, 30 );

            Console.WriteLine(o2.i);
            Console.WriteLine(o2.j);
            Console.WriteLine(o2.k);

        }
    }

    public class Class1
    {
        public int i;
        public int j;
        public int k;
    }

}