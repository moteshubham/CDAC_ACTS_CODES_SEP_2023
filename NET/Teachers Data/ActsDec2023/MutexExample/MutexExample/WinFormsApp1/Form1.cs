namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        Mutex m;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            label1.Text = "Running";
            this.Refresh();

            bool initiallyOwned;
            m = new Mutex(true, "Mutex1", out initiallyOwned);

            MessageBox.Show(initiallyOwned.ToString());
            for (long i = 0; i < 9999999999; i++)
            {

            }
            label1.Text = "Ended";
            m.ReleaseMutex();
        }
    }
}