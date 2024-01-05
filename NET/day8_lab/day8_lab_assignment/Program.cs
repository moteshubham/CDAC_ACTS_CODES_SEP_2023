namespace day8_lab_assignment
{
    internal class Program
    {
        static object lockObject = new object();
        static int i = 0;
        static void Main()
        {

            Thread t1 = new Thread(new ThreadStart(OddNum));
            Thread t2 = new Thread(new ThreadStart(EvenNum));
            t1.Start();
            t2.Start();
        }

        public static void OddNum()
        {
            lock (lockObject) //Monitor.Enter(lockObject)
            {
                
                Console.WriteLine("odd : " + ++i);
            }
        }


        public static void EvenNum()
        {
            lock (lockObject) //Monitor.Enter(lockObject)
            {
                Console.WriteLine("even : " + ++i);
            }
        }
    }
}