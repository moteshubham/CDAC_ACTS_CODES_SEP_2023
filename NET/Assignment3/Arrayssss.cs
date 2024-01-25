using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Channels;
using System.Threading.Tasks;

namespace Assignment3
{
    internal class Array
    {
        static void Main()
        {
            Console.WriteLine("Enter number of batches: ");
            int batches = int.Parse(Console.ReadLine());
            int[][] arr = new int[batches][];

            for(int i = 0; i < batches; i++) {
                Console.WriteLine($"Enter number of students on batch {i+1}");
                int students = int.Parse(Console.ReadLine());
                arr[i]=new int[students];
            }


          /*  for(int i=0; i<batches; i++) {
                Console.WriteLine($"Batch {i+1} have {arr[i].Length} students" );
            } */


            for(int i = 0;i < batches; i++)
            {

                for(int j = 0; j < arr[i].Length;j++)
                {
                    Console.WriteLine($"Enter marks for student no {j+1} of batch {i+1}");
                    arr[i][j]=int.Parse(Console.ReadLine());    
                }
            }

            for( int i = 0;i< batches; i++) {
                Console.WriteLine($"Batch {i+1} marks:");
                for (int j=0; j < arr[i].Length; j++)
                {
                    Console.WriteLine($"Marks of student no {j + 1} : " + arr[i][j]);
                }            
            }
        }

    }
}
