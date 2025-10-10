
public class Student {

	public String id;
	public String name;
	public double Assesment;
	public double mid;
	public double Final;
	
	public Student(String id,String name,double Assesment,double mid,double Final) {
		this.id=id;
		this.name= name;
		this.Assesment=Assesment;
		this.mid=mid;
		this.Final=Final;
	}
	
	public void addAssesmentMark(double value) {
		this.Assesment= value;
	}
	
	public void addMidMark(double value) {
		this.mid= value;
	}
	
	public void addFinalMark(double value) {
		this.Final=value;
	}
	
	public double totalMark() {
		double x = Assesment+mid+Final;
		
		return x;
	}
	
	public String toString() {
		return String.format("ID = %s\n,Name = %s\n,Assesment = %f\n,Mid = %f\n,Final = %f\n", id, name, Assesment,mid, Final);
	}
	
}
