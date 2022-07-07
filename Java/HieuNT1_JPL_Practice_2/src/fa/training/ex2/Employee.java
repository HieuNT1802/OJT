package fa.training.ex2;

public class Employee {
  int id;
  String name;
  String address;
  Double salary;
public Employee(int id, String name, String address, Double salary) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.salary = salary;
}


public Employee() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary;
}
  
}
