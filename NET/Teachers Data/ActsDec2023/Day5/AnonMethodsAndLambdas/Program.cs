namespace AnonMethodsAndLambdas1
{
    internal class Program
    {
        static void Main1()
        {
            int i = 100;
            Action o1 = delegate()
            {
                i++;
                Console.WriteLine("Anon method called" +i);
            };
            o1();

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
    }
}

namespace AnonMethodsAndLambdas2
{
    internal class Program
    {
        static void Main()
        {
            //Func<int, int> o1 = delegate(int a)
            //{
            //    return a * 2;
            //};

            //Func<int, int> o1 =  ( a) =>
           
            //     a * 2;
            ;
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

            Action o7 = () =>
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
        static string GetTime()
        {
            return DateTime.Now.ToLongTimeString();
        }
        static int GetDouble(int a)
        {
            return a * 2;
        }
        static bool IsEven(int a)
        {
            if (a % 2 == 0)
                return true;
            else
                return false;
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
        static bool IsBasicGreaterThan10000(Employee obj)
        {
            return obj.Basic > 1000;
        }
        static void Display()
        {
            Console.WriteLine("Display called");
        }
        static void Display(string s)
        {
            Console.WriteLine("Display called" + s);
        }
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

    }
}