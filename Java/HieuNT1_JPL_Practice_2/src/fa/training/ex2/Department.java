package fa.training.ex2;

import java.util.List;

public class Department {
//   String name, loc;
//    Employee emp[];
//    public Department()
//    {
//        name=null;
//        loc=null;
//        emp = new Employee[1];
//        emp[0]=new Employee();
//    }
//    public Department(String n, String l, Employee e[])
//    {
//        name=n;
//        loc=l;
//        emp = e;
//    }
//// public Employee[] addEmployee() {
////	 Employee ep1 = new Employee(1, "Hieu", "Ha noi", 1000.0);
////	 Employee ep2 = new Employee(2, "Hieu", "Ha noi", 1000.0);
////	 Employee ep3 = new Employee(3, "Hieu", "Ha noi", 1000.0);
////	 Employee ep4 = new Employee(4, "Hieu", "Ha noi", 1000.0);
////	 Employee ep5 = new Employee(5, "Hieu", "Ha noi", 1000.0);
////	 Employee[] arrEmployee={ep1,ep2,ep3,ep4,ep5};
////	 return arrEmployee;
//// }
// 
//    public  void addEmployee(Employee e) 
//    { 
//        Employee arEm[] = new Employee[emp.length + 1]; 
//  
//        for (int i = 0; i < emp.length; i++) 
//        	arEm[i] = emp[i]; 
//        arEm[emp.length] = e; 
//  
//        emp= arEm; 
//    }
//    public void Display(Employee[] emp) {
//   	 for(Employee aEmployee : emp ) {
//   		 System.out.println(aEmployee);
//   	 }
//    }
//    public void removeEmployee(int reEm )
//    {
//        if (emp == null || reEm < 0 || reEm >= emp.length) { 
//            return ;
//        } 
//        Employee[] nEmp = new Employee[emp.length - 1]; 
//
//        for (int i = 0, k = 0; i < emp.length; i++) { 
//            if (i == reEm)
//            {
//                continue;
//            }
//        nEmp[k++] = emp[i];
//        }
//        emp = nEmp;
//    }
// public static void main(String[] args) {
//	
//	 Employee[] em = new Employee[5];
//     System.out.println("Input Employee Information");
//     for(int i=0; i<5; i++)
//     {
//         String n= new String("Employee"+(i+1));
//         String ad=new String("Address"+(i+1));
//         
//         em[i]=new Employee(i+1,n,ad,i+9999.0);
//     }
//     Department de =new Department();
//     de.Display(em);
//     Department d=new Department("Information Technology", "FPT SoftWare", em);
//     System.out.println("Yearly Expenditure for the department is : ");
//     
//    int s=0;
//    
//     for(int i=0; i<5; i++)
//     {
//         s+=d.emp[i].getSalary();   
//    }
//     
//     System.out.print(10*s);
//}
	String name;
	String loc;
	List<Employee> employees;
	public Department() {
		
	}
	public Department(String name, String loc, List<Employee> employees) {
		super();
		this.name = name;
		this.loc = loc;
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	@Override
	public String toString() {
		return "Department [name=" + name + ", loc=" + loc + ", employees=" + employees + "]";
	}
	public boolean addEmployee(Employee employees) {
		return this.employees.add(employees);
	} 
	public boolean removeEmployee(Employee employees) {
		return this.employees.remove(employees);
		}
	public Employee findEmpId(){
		return null;
	}
	public static void main(String[] args) {
		Department fid= new Department("Ho tro tai chinh", "HN", null);
		fid.addEmployee(new Employee(0, "werf", "wfwef",234325.0));
}}
