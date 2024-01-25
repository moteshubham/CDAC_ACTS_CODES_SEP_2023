using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

//nuget - Add Microsoft.AspNet.WebApi.Client package
namespace ClientForWebApi
{
    class Program
    {
        
        static string url = "http://localhost:5297/api/";
        //post
        static void Main1()
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);

                var empstr = "{\"EmpNo\": 99999,\"Name\": \"Harsh\",\"Basic\": 22345,\"DeptNo\": 20}";
                HttpContent content = new StringContent(empstr, Encoding.UTF8, "application/json");

                //GetAsync to send a GET    
                //PutAsync to send a PUT   
                //DeleteAsync to send a DELETE   
                var responseTask = client.PostAsync("Employees", content);
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    Console.WriteLine("success");
                    //var readTask = result.Content.ReadAsAsync<Employee>();
                    //readTask.Wait();

                    //Employee obj = readTask.Result;
                    //Console.WriteLine(obj.Name);

                }
                else
                {
                    Console.WriteLine("error");
                }
            }
            Console.ReadLine();
        }
        
        
        //get single
        static void Main2()
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
    
                var responseTask = client.GetAsync("Employees/1");
                responseTask.Wait();

                var result = responseTask.Result;

                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Employee>();
                    readTask.Wait();

                    Employee obj = readTask.Result;
                    Console.WriteLine(obj.Name);
                    //Console.WriteLine(readTask.Result.Name);
                }
                else
                {
                    //Error response received   
                    Console.WriteLine("ERROR");
                }
            }
            Console.ReadLine();
        }
        
        
        //get all
        static void Main3()
        {
            IEnumerable<Employee> members = null;

            using (var client = new HttpClient())
            {

                client.BaseAddress = new Uri(url);
                var responseTask = client.GetAsync("Employees");
                responseTask.Wait();

                //To store result of web api response.   
                var result = responseTask.Result;

                //If success received   
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<IEnumerable<Employee>>();
                    readTask.Wait();

                    members = readTask.Result;
                }
                else
                {
                    //Error response received
                    Console.WriteLine("error - no data recd");
                    members = Enumerable.Empty<Employee>();
                }
                foreach (Employee emp in members)
                {
                    Console.WriteLine(emp.EmpNo);
                    Console.WriteLine(emp.Name);
                    Console.WriteLine();

                }

            }
            Console.ReadLine();
        }

        //put
        static void Main4()
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);

                var empstr = "{\"EmpNo\": 99999,\"Name\": \"Changed Value\",\"Basic\": 22345,\"DeptNo\": 20}";
                HttpContent content = new StringContent(empstr, Encoding.UTF8, "application/json");

                var responseTask = client.PutAsync("Employees/99999", content);
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    Console.WriteLine("success");
                }
                else
                {
                    Console.WriteLine("error");
                }
            }
            Console.ReadLine();
        }

        
        //delete 
        static void Main()
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);

                var responseTask = client.DeleteAsync("Employees/99999");
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    Console.WriteLine("successfully deleted");

                    //var readTask = result.Content.ReadAsAsync<Employee>();
                    //readTask.Wait();

                    //Console.WriteLine(readTask.Result.Name);
                }
                else
                {
                    //Error response received   
                    Console.WriteLine("could not delete");
                }
            }
            Console.ReadLine();
        }


    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}
