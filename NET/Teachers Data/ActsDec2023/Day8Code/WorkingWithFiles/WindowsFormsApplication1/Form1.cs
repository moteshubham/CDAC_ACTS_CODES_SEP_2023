using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            //Directory.CreateDirectory("C:\\new");
            Directory.CreateDirectory(@"C:\aaaa");
            //Directory.

            //DirectoryInfo dir = new DirectoryInfo("C:\\aaaa");
            
            //dir.

        }

        private void button2_Click(object sender, EventArgs e)
        {

            File.Create("C:\\aaaa\\a.txt");
            //File.
            
            //FileInfo file = new FileInfo("C:\\aaaa\\a.txt");
            //file.
        }

        private void button3_Click(object sender, EventArgs e)
        {

            DriveInfo drive = new DriveInfo("C");
           //drive.
           //if(drive.DriveType == DriveType.
            
        }











        private void button4_Click(object sender, EventArgs e)
        {
            //string s = "Hello World";
            //byte[] arr = Encoding.Default.GetBytes(s);
            
            //FileStream stream = File.Open("C:\\aaaa\\a.txt", FileMode.Create);


            //stream.Write(arr, 0, arr.Length);

            ////stream.Length
            ////stream.Read()

            //stream.Close();

            //-------------------------------
            StreamWriter writer = File.CreateText("C:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }






        private void button5_Click(object sender, EventArgs e)
        {
            string s;
            StreamReader reader = File.OpenText("C:\\aaaa\\a.txt");
            while ((s = reader.ReadLine())!= null)
            {
                MessageBox.Show(s);
            }
            reader.Close();
        }





        private void button6_Click(object sender, EventArgs e)
        {
            string s = "Hello";
            int i = 100;
            bool b = true;

            FileInfo f = new FileInfo("C:\\aaaa\\a.dat");

            BinaryWriter binary_writer = new BinaryWriter(f.OpenWrite());

            binary_writer.Write(s);
            binary_writer.Write(i);
            binary_writer.Write(b);

            binary_writer.Close();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            string s ;
            int i ;
            bool b ;

            FileInfo f = new FileInfo("C:\\aaaa\\a.dat");

            BinaryReader binary_reader = new BinaryReader(f.OpenRead());

            s = binary_reader.ReadString();
            i = binary_reader.ReadInt32();
            b = binary_reader.ReadBoolean();

            MessageBox.Show(s);
            MessageBox.Show(i.ToString());
            MessageBox.Show(b.ToString());
            binary_reader.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
