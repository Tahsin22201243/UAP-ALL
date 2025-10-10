import java.util.ArrayList;

public class UAP {
	
	public String name;
	
	public ArrayList<Student> students;
	
	public UAP(String name) {
		this.name= name;
		this.students = new ArrayList<>();
	}

	public Student findStudent(String id) {
		for(Student found : students) {
			if(found.id.equals(id)) {
			return found;
			}
		}	
		return null;
	}
	
	public void addStudent(String id, String name, double Assesment, double mid, double Final) {
		Student st = findStudent(id);
		if( st== null) {
			Student stu = new Student(id, name, Assesment, mid, Final);
			students.add(stu);
		}
		
	}
	
	public void UpdateAssessmentMark(String id, double addAssesmentMark) {
		Student st = findStudent(id);
		if( st != null) {
			st.addAssesmentMark(addAssesmentMark);
		}
	}
	
	public void UpdateMidMark(String id, double addMidMark) {
		Student st = findStudent(id);
		if( st != null) {
			st.addMidMark(addMidMark);
		}
	}
	
	
	public void UpdateFinalMark(String id, double addFinalMark) {
		Student st = findStudent(id);
		if( st != null) {
			st.addFinalMark(addFinalMark);
		}
	}
	
	public void TotalMark(String id) {
		Student st = findStudent(id);
		if( st != null) {
			System.out.printf("Total Mark - %f", st.totalMark());
		}
	}
	
	public void viewIndividual(String id) {
		Student st = findStudent(id);
		if( st != null) {
			System.out.println(st);
		}
	}
	
	public void displayAll() {
		for(Student all : students) {
			System.out.println("all");
		}
	}
	
}
