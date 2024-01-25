namespace RefAndValue
{
    internal class Program
    {
        static void Main2()
        {
            Class1 o1 = new Class1();
            Class1 o2 = new Class1();
            o1.i = 100;
            o2.i = 200;
            o2 = o1;
            o2.i = 300;
            Console.WriteLine(o1.i);
            Console.WriteLine(o2.i);
        }

        static void Main4()
        {
            int o1, o2;
            o1 = 100;
            o2 = 200;
            o1 = o2;
            o2 = 300;
            Console.WriteLine(o1);
            Console.WriteLine(o2);
            Console.ReadLine();
        }
        static void Main()
        {
            string o1, o2;
            o1 = "100";
            o2 = "200";
            o1 = o2;
            o2 = "300";
            Console.WriteLine(o1);
            Console.WriteLine(o2);
            Console.ReadLine();
        }

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

            float f;   //Single
            double d;  //Double
            decimal c; //Decimal

            char ch; //Char
            bool b; //Boolean

            object o; //Object
            string s; //String
        }
        static void Boxing()
        {
            int i = 100;

            object o;
            o = i;  //boxing
            int j;
            j = (int)o; //unboxing

        }
    }
    public class Class1
    {
        public int i;
    }
}