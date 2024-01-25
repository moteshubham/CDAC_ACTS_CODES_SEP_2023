namespace IDisposableExample
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();
            o.Display();
        }
        static void Main2()
        {
            using (Class1 o = new Class1()) 
            {
                o.Display();
            }
        }
    }

    public class Class1 : IDisposable
    {
        public Class1()
        {
            //open file here
            //open db here
            Console.WriteLine("cons");
        }
        public void Display()
        {
            Console.WriteLine("Display called");
        }


        public void Dispose()
        {
            //close file
            //close db conn
            Console.WriteLine("Dispose code called. Write code here instead of Destructor");
        }
        //~Class1()
        //{
        //    Console.WriteLine("des");
        //}

    }
}

namespace IDisposableExample2
{
    internal class Program
    {
        static void Main()
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();
            o.Display();
        }
    }
    public class Class1 : IDisposable
    {
        public Class1()
        {
            //open file here
            //open db here
        }
        bool isDisposed;
        public void Display()
        {
            CheckForDisposed();
            Console.WriteLine("Display called");
        }
        public void Dispose()
        {
            CheckForDisposed();
            //close file
            //close db conn
            Console.WriteLine("Dispose code called. Write code here instead of Destructor");
            isDisposed = true;
        }
        private void CheckForDisposed()
        {
            if (isDisposed)
                throw new ObjectDisposedException("Class1");
        }
    }

}