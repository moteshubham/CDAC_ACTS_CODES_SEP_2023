namespace Functions
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o = new Class1();

            //positional parameters
            Console.WriteLine(o.Add(10, 20, 30));
            Console.WriteLine(o.Add(10, 20));
            Console.WriteLine(o.Add(10));
            Console.WriteLine(o.Add());

            //named parameters
            Console.WriteLine(o.Add(c: 10));
            Console.WriteLine(o.Add(c: 10, a: 5, b: 7));
            Console.WriteLine(o.Add(c: 10, b: 7));

            Console.WriteLine(o.Add(1, c: 10));
            //Console.WriteLine(o.Add2(1, c: 10));  //error - b is required


        }

        static void Main()
        {
            Class1 o = new Class1();
            o.DoSomething();
        }
    }

    public class Class1// :Object
    {
        public void Display()
        {
            Console.WriteLine("Display");
        }
        //overload a function - same function name, diff parameters
        public void Display(string s)
        {
            Console.WriteLine("Display" + s);
        }


        //public int Add(int a, int b)
        //{
        //    return a + b;
        //}
        //public int Add(int a, int b, int c)
        //{
        //    return a + b + c;
        //}


        //default values
        public int Add(int a = 0, int b = 0, int c = 0)
        {
            return a + b + c;
        }

        public int Add2(int a, int b, int c = 0)
        {
            return a + b + c;
        }

        //error - default values are given from right to left
        //public int Add3(int a=0, int b, int c )
        //{
        //    return a + b + c;
        //}

        public void DoSomething()
        {
            int i = 100; //local variables

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
            DoSomething2();

            //static local function
            //local function cannot access local variables defined in the outer function

            static void DoSomething3()
            {
                //i++;
                //Console.WriteLine(i);
            }
        }

        
    }

}