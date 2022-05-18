public class Main {

    public static void main(String[] args) {
	    Student[] students = new Student[3];

	    students[0] = new Student("Laurence", "Rawlings", 90, 95);
	    students[1] = new Student("Toby", "Plunkett", 80, 100);
	    students[2] = new Student("Fraser", "Grandfield", 90, 90);


	    for(int i = 0; i < students.length; i++){
            System.out.println(String.format("Student %d:\n" + students[i].getSurname() + ", " +
					students[i].getFirstName() + "\n" + students[i].getFullName() + "\nTest Mark: " +
					students[i].getTestMark() + "\nCourse Work Mark: " + students[i].getCourseWorkMark() +
					"\nAverage Mark: " + students[i].getAverageMark() + "\n", i+1));
        }
    }
}
