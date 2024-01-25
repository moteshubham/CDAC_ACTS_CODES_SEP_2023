using static System.Net.Mime.MediaTypeNames;

namespace ImplicitVariables
{
    internal class Program
    {
        
        static void Main(string[] args)
        {
            string s = "Test";

            string t = string.copy(s);

            Console.WriteLine(s == t);

Console.WriteLine((object)s == (object)t);
        }
    
}
    }
}