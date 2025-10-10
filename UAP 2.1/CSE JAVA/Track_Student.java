import java.util.Scanner;

public class Track_Student {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UAP Stu = new UAP("University of Asis Pacific");
		 String id;
		 String name;
		 double Assesment;
		 double mid;
		 double Final;
		
		 int choice = -1;
		 
		 while(choice != 0) {
			 System.out.println("1. View All");
			 System.out.println("2. View Individual");
			 System.out.println("3. Add Student");
			 System.out.println("4. Update Assesment");
			 System.out.println("5. Update Mid");
			 System.out.println("6. Update Final");
			 System.out.println("7. View Total");
			 System.out.println("0. Exit");
			 
			 choice = scan.nextInt();
			 
			 switch(choice){
				 
				 case 1:
					 break;
			 }
			 
		 }
		 
	}

}
