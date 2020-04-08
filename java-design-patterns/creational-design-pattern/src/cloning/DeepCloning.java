package cloning;


@SuppressWarnings("unused")
class CourseForDeepCloning implements Cloneable{
	private String subject1; 
	private String subject2;
    private String subject3;
 
    public CourseForDeepCloning(String subject1, String subject2, String subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }
    
    public String getSubject1() {
    	return subject1;
    }
    
    public void setSubject1(String subject1) {
    	this.subject1 = subject1;
    }
    
    public String getSubject2() {
    	return subject2;
    }
    
    public void setSubject2(String subject2) {
    	this.subject1 = subject2;
    }
    
    public String getSubject3() {
    	return subject3;
    }
    
    public void setSubject3(String subject3) {
    	this.subject3 = subject3;
    }
    
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


@SuppressWarnings("unused")
class StudentForDeepCloning implements Cloneable {
	private int id;
	private String name;
	private  CourseForDeepCloning courseForDeepCloning;
 
    public StudentForDeepCloning(int id, String name, CourseForDeepCloning courseForDeepCloning) {
        this.id = id;
        this.name = name;
        this.courseForDeepCloning = courseForDeepCloning;
    }
    
    public CourseForDeepCloning getCourseForDeepCloning() {
    	return this.courseForDeepCloning;
    }
    
    public void setCourseForDeepCloning(CourseForDeepCloning courseForDeepCloning) {
    	this.courseForDeepCloning = courseForDeepCloning;
    }
    
    //Overriding clone() method to create a deep copy of an object.
    protected Object clone() throws CloneNotSupportedException {
        StudentForDeepCloning student = (StudentForDeepCloning) super.clone();
 
        student.courseForDeepCloning = (CourseForDeepCloning) courseForDeepCloning.clone();
 
        return student;
    }
}


public class DeepCloning {
	public static void main(String[] args) {
		CourseForDeepCloning science = new CourseForDeepCloning("Physics", "Chemistry", "Biology");
		 
        StudentForDeepCloning studentForDeepCloning1 = new StudentForDeepCloning(111, "John", science);
 
        StudentForDeepCloning studentForDeepCloning2 = null;
 
        try {
            //Creating a clone of student1 and assigning it to student2
            studentForDeepCloning2 = (StudentForDeepCloning) studentForDeepCloning1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
 
        //Printing the subject3 of 'student1'
        System.out.println(studentForDeepCloning1.getCourseForDeepCloning().getSubject3()); //Output : Biology
 
        //Changing the subject3 of 'student2'
        studentForDeepCloning2.getCourseForDeepCloning().setSubject3("Maths");
 
        //This change will not be reflected in original student 'student1' 
        System.out.println(studentForDeepCloning1.getCourseForDeepCloning().getSubject3());       //Output : Biology
    }
}
