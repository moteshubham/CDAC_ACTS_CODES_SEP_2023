namespace ImplicitVariables
{
    internal class Program
    {
        
        static void Main(string[] args)
        {
            //can only be used for local variables, not for class level variables,
            //not for func parameters or return values
            //int i = 100;
            var i = 100;  //implicit variable

            //var j;  //error  - must be initialized

            var s = 1243;
            //s = ""; //error  - cant convert string i= to int
            s = 100;
            var h = "Sdf";
            int a = 100;
            var b = 100;

            Console.WriteLine(h.GetType());
        }
    }
}