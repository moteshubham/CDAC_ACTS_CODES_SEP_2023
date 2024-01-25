using System.Collections;

namespace Indexers
{
    internal class Program
    {
        static void Main1()
        {
            ArrayList oAL = new ArrayList();

            Class1 o = new Class1();
            o[0] = 100;
            o[1] = 200;
            o[2] = 300;

            Console.WriteLine(o[0]);
            Console.WriteLine(o[1]);
            Console.WriteLine(o[2]);
        }
    }

    public class Class1
    {
        private int[] arr = new int[3];
        public int this[int index]
        {
            get
            {
                return arr[index];
            }
            set
            {
                arr[index] = value;
            }
        }
    }
}

namespace Indexer2
{
    class Program
    {
        static void Main()
        {
            Class1 o = new Class1(5, 2000);
            o[2000] = 100;
            o[2001] = 100;
            o[2002] = 100;
            o[2003] = 100;
            o[2004] = 100;
            Console.WriteLine(o[2003]);
            Console.ReadLine();
        }
    }
    public class Class1
    {
        private int[] arr;
        int start;
        public Class1(int Size, int start)
        {
            this.start = start;
            arr = new int[Size];
        }
        public int this[int index]
        {
            get
            {
                return arr[index - start];
            }
            set
            {
                arr[index - start] = value;
            }
        }

    }
}
