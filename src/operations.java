import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




public class operations {
	public static Entry[] entryList;
	public static int numEntries;
	public static String[] names;
	public static String[] sortedNames;
	static Entry[] possibleEntriesArray;
	public static Entry[] newEntryList;
	public static ArrayList<Entry> possibleEntries;
	public static findError error;
	public static void readPhoneBook(String file) throws Exception {
		int i;
		numEntries = 0;
		Scanner fileReader;
		
		entryList = new Entry[200];
		newEntryList = entryList;
		
		try {
			fileReader = new Scanner(new File(file));
			fileReader.useDelimiter("\t|\n");
			
			while (fileReader.hasNext()) {
				entryList[numEntries] = new Entry();
				entryList[numEntries].name = fileReader.next();
				entryList[numEntries].number = fileReader.next();
				entryList[numEntries].notes = fileReader.next();
				entryList[numEntries].eMail = fileReader.next();
				numEntries++;
			}
			
			
		} catch (Exception NoSuchElementException){
			
		}
		
		
	}
	
	public static void storePhoneBook(String file) throws Exception {
		PrintStream print;
		finishPanel finish;
		print = new PrintStream(file);
		
		for (int i = 0; i < numEntries; i++) {
			print.println(entryList[i].name + "\t" + entryList[i].number + "\t" + entryList[i].notes + "\t" + entryList[i].eMail);
		}
		
		print.close();
		finish = new finishPanel();
		
		
	}
	
	
	
	public static void newEntry () {
		newEntryPanel panel;
		mainScreen panel1;
		panel = mainScreen.panel;
		
		
		entryList[numEntries] = new Entry();
		if(panel.nameField.getText().equals("")) { 
			entryList[numEntries].name = "No name";
		} else {
			entryList[numEntries].name = panel.nameField.getText();
		} if (panel.notesField.getText().equals("")) { 
			entryList[numEntries].notes = "No notes.";
		} else {	
			entryList[numEntries].notes = panel.notesField.getText();
		} if (panel.numberField.getText().equals("")) {
			entryList[numEntries].number = "No number";
		} else {		
			entryList[numEntries].number = panel.numberField.getText();
		} if(panel.eMailField.getText().equals("")) {
			entryList[numEntries].eMail = "No eMail";
		} else {
			entryList[numEntries].eMail = panel.eMailField.getText();
		}
		numEntries++;
		
		sortNames();
		
		Start.main.dispose();
		panel1 = new mainScreen();
		panel.dispose();
		
		
	}
	
	public static String[] getNames() {
		
		names = new String[numEntries];
		
		for(int i = 0; i < numEntries; i++) {
			names[i] = entryList[i].name;
					
		}
		
		return names;
	}
	
	public static void sortNames() {
		Entry tempEntry;
		
		names = new String[numEntries];
		names = getNames();
		Arrays.sort(names);
		
		tempEntry = new Entry();
		
		for(int i = 0; i < numEntries; i++) {
			for(int x = 0; x < numEntries; x++) {
				if(names[i].equalsIgnoreCase(entryList[x].name)) {
					tempEntry = entryList[x];
					entryList[x] = entryList[i];
					entryList[i] = tempEntry;
				}
			}
		}
		
	}
	
	
	public static void deleteEntry(int name) {
		
		
		
		newEntryList = new Entry[numEntries];
		
		for(int i = 0; i < numEntries - 1; i++) {
			if(name == i) {
				for(int x = i; x < numEntries - 1; x++) {
					newEntryList[x] = new Entry();
					newEntryList[x] = entryList[x + 1];					}
					break;
			}
			newEntryList[i] = new Entry();
			newEntryList[i] = entryList[i];
		}
		
		entryList = newEntryList;
		numEntries--;	
	
	}
		
	
	public static void findEntry(String characters) {
		int numPossibleEntries;
		
		numPossibleEntries = 0;
		possibleEntries = new ArrayList<Entry>();
		
		for(int i = 0; i < numEntries; i++) {
			if(entryList[i].name.toLowerCase().contains((characters).toLowerCase())) {
				possibleEntries.add(entryList[i]);
				numPossibleEntries++;
			}
		}
		possibleEntriesArray = new Entry[numPossibleEntries];
		possibleEntries.toArray(possibleEntriesArray);
		if(numPossibleEntries != 0) {
			Start.isFound = true;
			Start.main.dispose();
			Start.main = new mainScreen();
		}
		else if (numPossibleEntries == 0) {
			error = new findError();
		}
		
		
		
		
	}
	
}
