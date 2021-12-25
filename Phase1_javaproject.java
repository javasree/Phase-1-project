import java.util.*;  
import java.io.*;
public class Phase1_javaproject {

	public static void menu() // Displays the main menu
	{
		System.out.println("Choose one of the following options:");
		System.out.println("1. Retreive all files");
		System.out.println("2. File operations");
		System.out.println("3. Terminate the application");
	}
	public static void operationMenu() // Displays the operations menu
	{
		System.out.println("Choose an operation to perform:");
		System.out.println("a) Add a new file");
		System.out.println("b) Delete a file");
		System.out.println("c) Retrieve a file with the given name");
		System.out.println("d) Go back to main menu.");
	}
	public static void main(String[] args) throws IOException 
	{   // About the project and me
		System.out.println("Welcome to my project Lckedme.com File Handler");
		System.out.println("                                  Developed");
		System.out.println("                                     by ");
		System.out.println("                                   Jayasree");
			
		// Creating the new folder for the project
		System.out.println("Enter the name of the folder that you want to create for the project");
		try (Scanner x = new Scanner (System.in)) {
			String Foldername= x.nextLine();
			File F1= new File(Foldername);
			F1.mkdir();
			if(F1.exists()) {System.out.println("Your folder "+(String)F1.getName()+ " is created\n");}
		
		Scanner s = new Scanner(System.in); // For main menu options
		Scanner z= new Scanner (System.in); // For operation menu options
			int choice = -1;  // For repetition of main menu
			while(choice==-1) {
				menu();
				choice= s.nextInt(); // input a menu option
				switch(choice) {
				case 1:
					// To retrieve all files from the folder
					File A[]= F1.listFiles();
					Arrays.sort(A);
					for (File e:A) {
						if(e.isFile()) {System.out.println(e.getName());}
						else if(e.isDirectory()) {System.out.println(e.getName());}
					}
					System.out.println("All files are retrieved\n");
					break;
				case 2:
					// To do file operations
					operationMenu();
					String o= z.nextLine();
					
					while(o!="") {
					switch(o) {
					case "a":
						// To add the user specified file to the folder that has been created initially
						System.out.println("Type the name of the file that you want to add along with extension");
						Scanner a= new Scanner (System.in);
						String Filenamea= a.nextLine();
						String fnameinfoldera= Foldername + "/" + Filenamea;
						File file = new File(fnameinfoldera);
						file.createNewFile();
						operationMenu();
						String update1 = z.nextLine();
						o= update1;
						break;
					case "b":
						// To delete the file specified by the user
						System.out.println("Type the name of the file along that you want to delete");
						Scanner b= new Scanner (System.in);
						String Filenamed= b.nextLine();
						String fnameinfolderd= Foldername + "/" + Filenamed;
						File filed = new File(fnameinfolderd);
						String d= filed.getName();
						if(!filed.exists()) {System.out.println("File is not Found\n");}
						else {filed.delete();
						      System.out.println("Your file "+ d + " is deleted\n");}
						operationMenu();
						String update2 = z.nextLine();
						o= update2;
						break;
					case "c":
						// To retreive the files containing the user specified name
						System.out.println("Type the name of the file that you want to search");
						Scanner str = new Scanner (System.in);
						String searchword = str.nextLine();
						File B[]= F1.listFiles();
						int q=0;
						for (File j:B)
						
							if((j.getName()).contains(searchword)) {System.out.println(j.getName());
							q++;}
						if(q==0) {System.out.println("Files/file not found \n");}
						else {System.out.println("Your files are retreived \n");}
						operationMenu();
						String update3 = z.nextLine();
						o= update3;
						break;
					case "d":
						// To exit the operation menu and go back to the main menu
						o = "";
						break;
					default:
						// To get a valid input from the user
						System.out.println("Choose a valid input to perform");
						operationMenu();
						String update4 = z.nextLine();
						o= update4;
						break;
					}
					}
					break;
				case 3:
					// To terminate the program
					System.exit(0);
					break;
				default:
					// To input valid input using the main menu
					System.out.println("\nChoose a valid input");
					break;
				}
				choice =-1;
			}
		}
	
	}
	}