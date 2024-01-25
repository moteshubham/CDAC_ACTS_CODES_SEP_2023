namespace IndicesAndRanges
{
    internal class Program
    {
        static void Main1()
        {
            string[] names = { "A", "B", "C", "D", "E", "F" };
            Console.WriteLine(IndexExamples.GetFirst(names));
            Console.WriteLine(IndexExamples.GetLastMethod1(names));
            Console.WriteLine(IndexExamples.GetLastMethod2(names));
            Console.WriteLine(IndexExamples.GetSecondLast(names));
        }
        static void Main()
        {
            string[] names = { "A", "B", "C", "D", "E", "F" };
            string[] retval;
            retval = RangeExamples.GetAll(names);
            //retval = RangeExamples.GetFirstTwoElements(names);
            //retval = RangeExamples.GetFirstThreeElements(names);
            //retval = RangeExamples.GetLastThreeElements(names);
            //retval = RangeExamples.GetThreeElementsFromMiddle(names);
            foreach (string name in retval) 
            {
                Console.WriteLine(name);
            }
        }
    }
    public class IndexExamples
    {
        public static string GetFirst(string[] names)
        {
            Index index = new Index(0);
            return names[index];
        }
        public static string GetLastMethod1(string[] names)
        {
            var index = new Index(1,true);  //get last
           //var index = new Index(2, true);  //get second last
           // var index = new Index(3, true);  //get third last
            return names[index];
        }
        public static string GetLastMethod2(string[] names)
        {
            return names[^1];
        }
        public static string GetSecondLast(string[] names)
        {
            return names[^2];
        }
    }

    public class RangeExamples
    {
        public static string[] GetAll(string[] arr)
        {
            return arr[..];
        }

        public static string[] GetFirstTwoElements(string[] arr)
        {
            var start = new Index(0);
            var end = new Index(2);
            var range = new Range(start, end);
            return arr[range];
        }

        public static string[] GetFirstThreeElements(string[] arr)
        {
            return arr[..3];
        }

        public static string[] GetLastThreeElements(string[] arr)
        {
            return arr[^3..];
        }

        public static string[] GetThreeElementsFromMiddle(string[] arr)
        {
            return arr[3..6];
        }
    }
}