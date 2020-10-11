package app;
import java.util.Scanner;

public class Main {

	private static void displayMenu() {
		System.out.println("---------- MONGO APP ----------");
		System.out.println("1 - S�lectionner une base de donn�es MongoDB");
		System.out.println("2 - S�lectionner une collection dans une BD");
		System.out.println("3 - Lister les documents disponibles");
		System.out.println("4 - Rechercher un document � partir d'un nom");
		System.out.println("0 - Quitter l'application");
		System.out.println("-------------------------------");
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1 :
			selectBase();
			break;
		case 2 :
			selectCollection();
			break;
		case 3 :
			listerDocs();
			break;
		case 4 :
			searchDoc();
			break;
		case 0 :
			System.out.println("Bye bye");
			break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayMenu();
	}

	private static void searchDoc() {
		// TODO Auto-generated method stub
		System.out.println("searchDoc");
		displayMenu();
		
	}

	private static void listerDocs() {
		// TODO Auto-generated method stub
		System.out.println("listerDocs");
		displayMenu();
		
	}

	private static void selectCollection() {
		// TODO Auto-generated method stub
		System.out.println("selectCollection");
		displayMenu();
		
	}

	private static void selectBase() {
		// TODO Auto-generated method stub
		System.out.println("selectBase");
		displayMenu();
		
	}
	

}
