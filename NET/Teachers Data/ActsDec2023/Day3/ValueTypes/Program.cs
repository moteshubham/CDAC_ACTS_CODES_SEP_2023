namespace ValueTypes1
{
    internal class Program
    {
        static void Main1()
        {
            MyPoint p = new MyPoint();
            Console.WriteLine(p.X);
        }
    }
    public struct MyPoint
    {
        public int A
        {
            get; set;
        }
        public int X;
        private int b;
        public int B
        {
            get { return b; }
            set { b = value; }
        }
        public MyPoint()
        {
            //this.X = 10;
            //this.A = 30;
            //this.b = 0;
            //this.B = 40;
        }

    }
}
namespace ValueTypes2
{
    class Program
    {
        static void Main()
        {
            Console.WriteLine(TimeOfDay.Morning);
            //Display1(1);
            Display2(TimeOfDay.Afternoon);
        }
        static void Display1(int t)
        {
            if (t == 10)
                Console.WriteLine("Good Morning");
            else if (t == 11)
                Console.WriteLine("Good Afternoon");
            else if (t == 12)
                Console.WriteLine("Good Evening");
            else if (t == 13)
                Console.WriteLine("Good Night");
        }
        static void Display2(TimeOfDay t)
        {
            if ( t == TimeOfDay.Morning )
                Console.WriteLine("Good Morning");
            else if (t == TimeOfDay.Afternoon)
                Console.WriteLine("Good Afternoon");
            else if (t == TimeOfDay.Evening)
                Console.WriteLine("Good Evening");
            else if (t == TimeOfDay.Night)
                Console.WriteLine("Good Night");
        }
    }

    public enum TimeOfDay //:long
    {
        Morning ,
        Afternoon,
        Evening,
        Night
    }

}