package fa.training.assignment_802.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fa.training.assignment_802.entities.*;

public class MagazineService {
	List<Magazine> magazines;
	
	public MagazineService() {
		magazines = new ArrayList<Magazine>();
	}
	
	public void addMagazine(Magazine newMagazine) {
		magazines.add(newMagazine);
	}
	
	public void display() {
		for (Magazine magazine : magazines) {
			magazine.display();
		}
	}
	//display all books and magazines have same publication year and publisher
	public void displayListSameProperty(List<Book> books) {
		List<Publication> publicationList = new ArrayList<Publication>();
		publicationList.addAll(magazines);
		publicationList.addAll(books);
		List<Publication> samePropertyList = new ArrayList<Publication>(); //initialize list to store same value
		for (int i = 0; i < publicationList.size() -1; i++) {
			boolean flag = false;
			for (int j = i+1; j < publicationList.size(); j++) {
				/* check if index have same value with the next indexes*/ 
				if(publicationList.get(i).getPublicationYear() == publicationList.get(j).getPublicationYear() 
						&& publicationList.get(i).getPublisher().equals(publicationList.get(j).getPublisher())) {
					samePropertyList.add(publicationList.get(j)); 
					publicationList.remove(j); // add it to list and remove same value indexes to reduce loops of first for 
					flag = true;
				}
			}
			if(flag) {
				samePropertyList.add(publicationList.get(i)); 
				System.out.println("-----------------");
				System.out.println("Year: " + publicationList.get(i).getPublicationYear() 
						+ "||Publisher: " + publicationList.get(i).getPublisher());
				for (Publication publication : samePropertyList) {
					if(publication instanceof Magazine) {
						System.out.print("Magazine |");
						((Magazine) publication).display();
					}
					if(publication instanceof Book) {
						System.out.print("Book |");
						((Book) publication).display();
					}
				}
				samePropertyList.clear(); // clear data in list to start new loops
			}
		}
	}
	
	public void sortList() {
		Collections.sort(magazines, (m1, m2) -> Integer.compare(m1.getVolume(), m2.getVolume()));
		Collections.reverse(magazines);
	}
	
	public void displayTop10() {
		System.out.println("--------Top 10--------");
		sortList();
		int displayListLength = magazines.size() >= 10 ? 10 : magazines.size();
		for (int i = 0; i < displayListLength; i++) {
			System.out.print((i+1) + " | ");
			magazines.get(i).display();
		}
	}
}
