package cloning;

@SuppressWarnings("unused")
class CourseForShallowCloning {
	private String subject1; 
	private String subject2;
    private String subject3;
 
    public CourseForShallowCloning(String subject1, String subject2, String subject3) {
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
}


@SuppressWarnings("unused")
class StudentForShallowCloning implements Cloneable {
	private int id;
	private String name;
	private  CourseForShallowCloning courseForShallowCloning;
 
    public StudentForShallowCloning(int id, String name, CourseForShallowCloning courseForShallowCloning) {
        this.id = id;
        this.name = name;
        this.courseForShallowCloning = courseForShallowCloning;
    }
 
    //Default version of clone() method. It creates shallow copy of an object.
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public CourseForShallowCloning getCourseForShallowCloning() {
    	return this.courseForShallowCloning;
    }
    
    public void setCourseForShallowCloning(CourseForShallowCloning courseForShallowCloning) {
    	this.courseForShallowCloning = courseForShallowCloning;
    }
}


@SuppressWarnings("unused")
public class ShallowCloning {

	public static void main(String[] args) {
		CourseForShallowCloning science = new CourseForShallowCloning("Physics", "Chemistry", "Biology");
        StudentForShallowCloning StudentForShallowCloning1 = new StudentForShallowCloning(111, "John", science);
        StudentForShallowCloning StudentForShallowCloning2 = null;
 
        try {
            //Creating a clone of StudentForShallowCloning1 and assigning it to StudentForShallowCloning2
        	StudentForShallowCloning2 = (StudentForShallowCloning) StudentForShallowCloning1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
 
        //Printing the subject3 of 'StudentForShallowCloning1'
        System.out.println(StudentForShallowCloning1.getCourseForShallowCloning().getSubject3());         //Output : Biology
 
        //Changing the subject3 of 'StudentForShallowCloning2'
        StudentForShallowCloning2.getCourseForShallowCloning().setSubject3("Maths");
 
        //This change will be reflected in original StudentForShallowCloning 'StudentForShallowCloning1'
        System.out.println(StudentForShallowCloning1.getCourseForShallowCloning().getSubject3());       //Output : Maths
	}

}
