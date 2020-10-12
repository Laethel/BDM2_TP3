package app;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Main {
	
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Document> collection;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		mongoClient = new MongoClient("192.168.56.50");	
		displayMenu();
	}

	private static void displayMenu() {
		System.out.println("---------- MONGO APP ----------");
		System.out.println("1 - S�lectionner une base de donn�es MongoDB");
		System.out.println("2 - S�lectionner une collection dans une BD");
		System.out.println("3 - Lister les documents disponibles");
		System.out.println("4 - Rechercher un document � partir d'un nom");
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
				System.err.println("Attention, vous devez d'abord s�lectionner une base de donn�es");
				displayMenu();
			}
			break;
		case 3 :
			if(collection != null) {
				listerDocs();
			} else {
				System.err.println("Attention, vous devez d'abord s�lectionner une collection");
				displayMenu();
			}
			break;
		case 4 :
			if(collection != null) {
				searchDoc();
			} else {
				System.err.println("Attention, vous devez d'abord s�lectionner une collection");
				displayMenu();
			}
			break;
		case 0 :
			System.out.println("Bye bye");
			sc.close();
			mongoClient.close();
			break;
		default :
			System.out.println("Choix non reconnu.");
			displayMenu();
		}
	}

	private static void searchDoc() {
		// TODO Auto-generated method stub
		System.out.println("Entrez le nom du document recherch� : ");
		String nomDoc = sc.next();
		Document document = collection.find(Filters.eq("name", nomDoc)).first();
		if(document != null) {
	        String res = document.toJson();
	        System.out.println("Document trouv� : " + res);
		} else {
			System.out.println("Document \"" + nomDoc +"\" non trouv�.");
		}
        String res = document.toJson();
        System.out.println("Document trouv� : " + res);
		displayMenu();
	}

	private static void listerDocs() {
		// TODO Auto-generated method stub
		System.out.println("listerDocs");
		FindIterable<Document> documents = collection.find();
		for (MongoCursor<Document> it = documents.iterator(); it.hasNext();) {
			Document doc = it.next();
			System.out.println(doc.toJson());
			System.out.println();
		}
		displayMenu();
	}

	private static void selectCollection() {
		// TODO Auto-generated method stub
		System.out.println("Entrez le nom de la collection souhait�e : ");
		String coll = sc.next();
		collection = database.getCollection(coll);
		System.out.println("Collection \"" + collection + "\" s�lectionn�e.");
		displayMenu();
		
	}

	private static void selectBase() {
		// TODO Auto-generated method stub
		System.out.println("Entrez le nom de la base de donn�es souhait�e : ");
		String db = sc.next();
		database = mongoClient.getDatabase(db);
		System.out.println("Base de donn�es \"" + db + "\" s�lectionn�e.");
		displayMenu();
	}
}
