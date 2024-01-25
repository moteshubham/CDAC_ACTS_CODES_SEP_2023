namespace OperatorOverLoading
{
    internal class Program
    {
        static void Main()
        {
            Class1 o1 = new Class1 { i = 10 };
            Class1 o2 = new Class1 { i = 20 };

            o1 = o1 + o2;
            Console.WriteLine(o1.i);
            o1 = o1 -5;
            Console.WriteLine(o1.i);
            //o1 = Class1.operator+(o1,o2);
        }
    }
    public class Class1
    {
        public int i;
        public static Class1 operator+(Class1 o1, Class1 o2)
        {
            Class1 retval = new Class1();
            retval.i = o1.i + o2.i;
            return retval;
        }
        public static Class1 operator-(Class1 o1, int o2)
        {
            Class1 retval = new Class1();
            retval.i = o1.i - o2;
            return retval;
        }
    }
}