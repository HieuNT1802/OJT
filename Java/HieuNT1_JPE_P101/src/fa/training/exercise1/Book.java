package fa.training.exercise1;

public class Book {
 private String name;
 private int ISBN;
 private String authorname;
 private String publisher;
 
public Book() {

}
public Book(String name, int iSBN, String authorname, String publisher) {
	this.name = name;
	ISBN = iSBN;
	this.authorname = authorname;
	this.publisher = publisher;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}
public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
//@Override
//public String toString() {
//	return "Book [name=" + name + ", ISBN=" + ISBN + ", authorname=" + authorname + ", publisher=" + publisher + "]";
//}
 String getBookInfo() {
	  String info = "Name:   "+ name + "\nISBN Number:  " + ISBN +
              "\nAuthor:   "+authorname+"\nPublisher:   "+ publisher;
	 return info;
 }
}
