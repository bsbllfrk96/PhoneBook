import java.awt.Font;


public class Start {
	public static mainScreen main;
	public static Boolean isFound;
	public static Font f;
	public static void main(String[] args) throws Exception {
		final String FILE;
		f = new Font("Serif", Font.PLAIN, 20);

		FILE = "phonebook.txt";
		isFound = false;
		operations.readPhoneBook(FILE);
		
		main = new mainScreen();
		
		
	}
}
