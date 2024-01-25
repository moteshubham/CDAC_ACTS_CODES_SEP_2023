namespace FileHandling
{
    internal class Program
    {
        static void Main()
        {
            CreateTextFile1();
            ReadTextFile1();
        }
        private static void CreateTextFile1()
        {
            
            StreamWriter writer = File.CreateText("C:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }

        static void ReadTextFile1()
        {
            string s;
            StreamReader reader = File.OpenText("C:\\aaaa\\a.txt");
            while ((s = reader.ReadLine()) != null)
            {
                Console.WriteLine(s);
            }
            reader.Close();
        }

    }
}