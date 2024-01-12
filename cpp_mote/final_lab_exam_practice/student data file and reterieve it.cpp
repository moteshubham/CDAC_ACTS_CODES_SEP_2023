

#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

class Course
{
public:
    string course_name;
    int fees;

    Course(string course_name, int fees) : course_name(course_name), fees(fees) {}
};

class Student
{
public:
    string name;
    int rollno;
    long mobile;
    vector<Course> courses;

    Student(string name, int rollno, long mobile) : name(name), rollno(rollno), mobile(mobile) {}

    void addCourse(Course course)
    {
        courses.push_back(course);
    }
};

void saveStudentDetails(vector<Student> students)
{
    ofstream file("studentDetails.txt");
    if (file.is_open())
    {
        for (auto &student : students)
        {
            file << "Name: " << student.name << endl;
            file << "Rollno: " << student.rollno << endl;
            file << "Mobile: " << student.mobile << endl;
            file << "Courses: " << endl;
            for (auto &course : student.courses)
            {
                file << course.course_name << " - Fees: " << course.fees << endl;
            }
            file << endl;
        }
        file.close();
    }
    else
    {
        cout << "Unable to open file";
    }
}

int main()
{
    vector<Student> students;
    vector<Course> courses = {Course("C++", 2000), Course("Java", 3000), Course("Python", 1000)};
    int choice;

    do
    {
        cout << "1. Register Student" << endl;
        cout << "2. Take course" << endl;
        cout << "3. display specific student's taken courses" << endl;
        cout << "4. display all students and their courses registered" << endl;
        cout << "5. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            string name;
            int rollno;
            long mobile;
            cout << "Enter name: ";
            cin >> name;
            cout << "Enter rollno: ";
            cin >> rollno;
            cout << "Enter mobile: ";
            cin >> mobile;
            Student student(name, rollno, mobile);
            students.push_back(student);
            break;
        }
        case 2:
        {
            int rollno;
            string course_name;
            cout << "Enter rollno: ";
            cin >> rollno;
            cout << "Enter course name: ";
            cin >> course_name;
            for (auto &student : students)
            {
                if (student.rollno == rollno)
                {
                    for (auto &course : courses)
                    {
                        if (course.course_name == course_name)
                        {
                            student.addCourse(course);
                            cout << "Course added successfully" << endl;
                        }
                    }
                }
            }
            break;
        }
        case 3:
        {
            int rollno;
            cout << "Enter rollno: ";
            cin >> rollno;
            for (auto &student : students)
            {
                if (student.rollno == rollno)
                {
                    cout << "Name: " << student.name << endl;
                    cout << "Rollno: " << student.rollno << endl;
                    cout << "Mobile: " << student.mobile << endl;
                    cout << "Courses: " << endl;
                    for (auto &course : student.courses)
                    {
                        cout << course.course_name << " - Fees: " << course.fees << endl;
                    }
                }
            }
            break;
        }
        case 4:
        {
            for (auto &student : students)
            {
                cout << "Name: " << student.name << endl;
                cout << "Rollno: " << student.rollno << endl;
                cout << "Mobile: " << student.mobile << endl;
                cout << "Courses: " << endl;
                for (auto &course : student.courses)
                {
                    cout << course.course_name << " - Fees: " << course.fees << endl;
                }
                cout << endl;
            }
            break;
        }
        case 5:
            saveStudentDetails(students);
            break;
        default:
            cout << "Invalid choice" << endl;
        }
    } while (choice != 5);

    return 0;
}