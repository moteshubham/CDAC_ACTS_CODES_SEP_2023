using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace AsyncCodeWithDelegates1
{
    internal class Program
    {
        static void Main0()
        {
            Action o1 = Display;
            Console.WriteLine("before");
            o1.BeginInvoke(null, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display()
        {
            Thread.Sleep(5000);
            Console.WriteLine("display");
        }
    }
}


namespace AsyncCodeWithDelegates2
{
    internal class Program
    {
        static void Main2()
        {
            Action<string> o1 = Display;
            Console.WriteLine("before");
            o1.BeginInvoke("passed value",null, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display(string s)
        {
            Thread.Sleep(5000);
            Console.WriteLine("display " +s);
        }
    }
}

namespace AsyncCodeWithDelegates3
{
    internal class Program
    {
        static void Main()
        {
            Func<string,string> o1 = Display;
            Console.WriteLine("before");
            o1.BeginInvoke("passed value", CallBackFunc, null);
           // o1.BeginInvoke("passed value", new AsyncCallback(CallBackFunc), null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static string Display(string s)
        {
            Thread.Sleep(5000);
            Console.WriteLine("display " + s);
            return s.ToUpper();
        }
        static void CallBackFunc(IAsyncResult ar) 
        {
            Console.WriteLine("call back func called");

        }
    }
}

namespace AsyncCodeWithDelegates4
{
    internal class Program
    {
        static void Main4()
        {
            Func<string, string> o1 = Display;
            Console.WriteLine("before");
            IAsyncResult ar1 = o1.BeginInvoke("passed value", delegate(IAsyncResult ar)
            {
                Console.WriteLine("call back func called");
                string retval = o1.EndInvoke(ar);
                Console.WriteLine(retval);

            }, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static string Display(string s)
        {
            Thread.Sleep(5000);
            Console.WriteLine("display " + s);
            return s.ToUpper();
        }
       
    }
}

namespace AsyncCodeWithDelegates5
{
    internal class Program
    {
        static void Main11()
        {
            Func<string, string> o1 = Display;
            Console.WriteLine("before");
            IAsyncResult ar =  o1.BeginInvoke("passed value", null, null);
            Console.WriteLine("after");

            while (!ar.IsCompleted) ;

            string retval = o1.EndInvoke(ar);
            Console.WriteLine(retval);

            Console.ReadLine();
        }
        static string Display(string s)
        {
            Thread.Sleep(5000);
            Console.WriteLine("display " + s);
            return s.ToUpper();
        }
       
    }
}

