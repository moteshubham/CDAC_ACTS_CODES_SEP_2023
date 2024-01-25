using N2;

namespace N1
{
    public class Class1
    {
        public String displayMe()
        {
            return "jabardast compiler";
        }
    }
    public class Class2
    {
        static void Main()
        {
            Class1 c = new Class1();
            System.Console.WriteLine("Hello mote " + c.displayMe());

            Console.WriteLine(Class3.displayYou());
            Console.WriteLine(N2.Class3.displayYou());

        }
    }

}

namespace N2
{
    public class Class3
    {
        public static int displayYou()
        {
            return 12;
        }
    }
}