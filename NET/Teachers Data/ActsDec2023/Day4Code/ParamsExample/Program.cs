using System.Diagnostics.CodeAnalysis;

namespace ParamsExample
{
    internal class Program
    {
        static void Main()
        {
            Console.WriteLine(Add(1, 2, 3));
            Console.WriteLine(Add(1, 2, 3,4, 5));
            Console.WriteLine(Add(1, 2, 3, 4 ,5,6,7));

        }
        static int Add(params int[] arr)
        {
            int sum = 0;
            foreach (int item in arr) 
            { 
                sum+= item;
            }
            return sum;
        }
    }
}