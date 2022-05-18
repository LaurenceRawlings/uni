public class Student {
    private String firstName, surname;
    private double testMark, courseWorkMark;

    public Student(String firstName, String surname) {
        setFirstName(firstName);
        setSurname(surname);
    }

    public Student(String firstName, String surname, double testMark, double courseWorkMark){
        setFirstName(firstName);
        setSurname(surname);
        setTestMark(testMark);
        setCourseWorkMark(courseWorkMark);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setTestMark(double testMark){
        this.testMark = testMark;
    }

    public void setCourseWorkMark(double courseWorkMark){
        this.courseWorkMark = courseWorkMark;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getSurname(){
        return surname;
    }

    public String getFullName(){
        return firstName + " " + surname;
    }

    public double getTestMark(){
        return testMark;
    }

    public double getCourseWorkMark(){
        return courseWorkMark;
    }

    public double getAverageMark(){
        return (testMark + courseWorkMark) / 2.0;
    }
}
