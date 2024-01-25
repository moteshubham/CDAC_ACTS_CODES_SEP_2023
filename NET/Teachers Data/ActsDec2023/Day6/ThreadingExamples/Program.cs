namespace ThreadingExamples1
{
    internal class Program
    {
        static void Main0()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);
            t1.Start();
            t2.Start();

            //Console.WriteLine(Thread.CurrentThread.ManagedThreadId);
            for (int i = 0; i < 1; i++)
            {
                Console.WriteLine("Main : " + i);
            }
        }
        static void Main1()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);
            t1.IsBackground = true;
            t2.IsBackground = true;

            t1.Start();
            t2.Start();

            for (int i = 0; i < 1; i++)
            {
                Console.WriteLine("Main : " + i);
            }
        }
        static void Main2()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);

            t1.Start();
            t2.Start();

            for (int i = 0; i < 1; i++)
            {
                Console.WriteLine("Main : " + i);
            }
            t1.Join();
            Console.WriteLine("this code should only run after Func1 is over");
        }
        static void Main3()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);

            t1.Priority = ThreadPriority.Highest;
            t2.Priority = ThreadPriority.Lowest;


            t1.Start();
            t2.Start();

            for (int i = 0; i < 1; i++)
            {
                Console.WriteLine("Main : " + i);
            }
        }

        static void Main4()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);

           //if(t1.ThreadState == ThreadState.)

            t1.Start();
            //t1.Abort();
            //t1.Suspend();
            //t1.Resume();


            t2.Start();

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Main : " + i);
                Thread.Sleep(5000);
            }
        }
        static void Main()
        {
            AutoResetEvent wh = new AutoResetEvent(false);
            Thread t1 = new Thread(delegate ()
            {
                for (int i = 0; i < 200; i++)
                {
                    Console.WriteLine("f1:" + i);
                    if (i % 50 == 0)
                    {
                        //instead of Suspend, use this
                        Console.WriteLine("waiting");
                        wh.WaitOne();//when this line executes, blocks current thread until current waithandle receives a signal
                    }
                }
            });
            t1.Start();

            //Thread.Sleep(2000);
            Console.ReadLine();
            Console.WriteLine("resuming 1....");
            wh.Set();

            //Thread.Sleep(2000);
            Console.ReadLine();
            Console.WriteLine("resuming 2....");
            wh.Set();

            //Thread.Sleep(2000);
            Console.ReadLine();
            Console.WriteLine("resuming 3....");
            wh.Set();   //sets event of state to signaled, allows waiting threads to proceed

            //Thread.Sleep(2000);
            Console.ReadLine();
            Console.WriteLine("resuming 4....");
            wh.Set();
        }
        static void Func1()
        {
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("First : " + i);
                //Thread.Sleep(5000);
            }
        }
        static void Func2()
        {
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("Second : " + i);
                //Thread.Sleep(5000);

            }

        }
    }
}

namespace ThreadingExamples2
{
    internal class Program
    {
        static void Main55()
        {
            Thread t1 = new Thread(new ParameterizedThreadStart(Func1));
            Thread t2 = new Thread(Func2);
            int[] arr = new int[2] { 10, 20 };
            t1.Start(arr);
            //t1.Start("aaa");
            t2.Start("bbb");

            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("Main : " + i);
            }
        }

        static void Func1(object obj)
        {
            int[] arr = (int[]) obj;

            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("First : " + i + obj.ToString());
            }

        }
        static void Func2(object obj)
        {
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("Second : " + i + obj.ToString());
            }

        }

    }
}