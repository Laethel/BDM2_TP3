package app;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
	
	static MongoClient mongoClient;
	static MongoDatabase database;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*String uri = "mongodb://192.168.56.50:27017";
		MongoClientURI connectionString = new MongoClientURI(uri);*/
		mongoClient = new MongoClient("192.168.56.50");
		
		displayMenu();
	}

	private static void displayMenu() {
		System.out.println("---------- MONGO APP ----------");
		System.out.println("1 - Sélectionner une base de données MongoDB");
		System.out.println("2 - Sélectionner une collection dans une BD");
		System.out.println("3 - Lister les documents disponibles");
		System.out.println("4 - Rechercher un document à partir d'un nom");
		System.out.println("0 - Quitter l'application");
		System.out.println("-------------------------------");
		switch(sc.nextInt()) {
		case 1 :
			selectBase();
			break;
		case 2 :
			if(database != null) {
				selectCollection();
			} else {
				System.out.println("Attention, vous devez d'abord sélectionner une base de données");
			}
			break;
		case 3 :
			listerDocs();
			break;
		case 4 :
			searchDoc();
			break;
		case 0 :
			System.out.println("Bye bye");
			sc.close();
			mongoClient.close();
			break;
		}
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
		System.out.println("Entrez le nom de la collection souhaitée : ");
		String coll = sc.next();
		MongoCollection<Document> collection = database.getCollection(coll);
		System.out.println("Collection \"" + collection + "\" sélectionée.");
		displayMenu();
		
	}

	private static void selectBase() {
		// TODO Auto-generated method stub
		System.out.println("Entrez le nom de la base de données souhaitée : ");
		String db = sc.next();
		database = mongoClient.getDatabase(db);
		System.out.println("Base de données \"" + db + "\" sélectionée.");
		displayMenu();
		
	}
	

}
