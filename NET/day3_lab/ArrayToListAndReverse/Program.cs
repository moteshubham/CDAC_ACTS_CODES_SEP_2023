namespace ArrayToListAndReverse
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Array to list:");
            int[] ints =new int[10];
            for(int i = 0; i < 10; i++)
            {
                ints[i] = i;    
            }
            List<int> list = ints.ToList();
                //new List<int>();
            //list.AddRange(ints);
            list.ForEach(x =>Console.WriteLine(x));
            Console.WriteLine();
            Console.WriteLine("List to array");
            List<int> ints2 = new List<int>();
            for(int i = 0;i < 10; i++)
            {
                ints2.Add(i);
            }

            int[] listToArr = ints2.ToArray();
                //new int[ints2.Count];
            int k = 0;
            ints2.ForEach(x=> listToArr[k++] = x);

            foreach (int item in listToArr)
            {
                Console.WriteLine(item);
            }

        }
    }
}