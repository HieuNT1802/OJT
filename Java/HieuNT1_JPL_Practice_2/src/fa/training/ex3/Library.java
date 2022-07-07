package fa.training.ex3;

public class Library {
	Book bok[];
	int totalB = 0;
	Library()
	{
		bok = new Book[5];
		for( int i=0; i<5; i++ )
			bok[i] = new Book();
	}
	void Add(String t, String pb, int pg, float pr, String ... str )
	{
		bok[totalB].create( t, pb, pg, pr );
		int k = str.length;
		if( k == 1 )
		{
			String S = str[0];
			bok[totalB].getAuthor(S);
		}
		else if( k == 2)
		{
			String S = str[0];
			String S1 = str[1];
			bok[totalB].getAuthor(S, S1);
		}
		else if( k == 3)
		{
			String S = str[0];
			String S1 = str[1];
			String S2 = str[2];
			bok[totalB].getAuthor(S, S1, S2);
		}
		totalB++;
	}
	void display()
	{
		System.out.println("---- All books in library ---- \n");
		for( int i=0; i<totalB; i++ )
			bok[i].Display();
	}
	public static void main(String[] args) {
		Library li = new Library();
		li.Add("Sherlock", "Purlitzer", 1900, 999f, "Sir Arthur Conan Doyle" );
		li.Add("HarryPoter", "Ozeemi", 1900, 999f, "Sir Arthur Conan Doyle" );
		li.Add("IronMan", "DecoMe", 1900, 999f, "Sir Arthur Conan Doyle" );
		li.display();
	}
}
