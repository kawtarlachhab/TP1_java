package partie1.exercices;
import java.io.Console;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.lang.System.*;

public class Menu_Bibliotheque {

	public static void Menu()
	{
		System.out.println("\t--------------------Menu------------------------");
		System.out.println("\t1> Afficher livres");
		System.out.println("\t2> Ajouter livre");
		System.out.println("\t3> Capacite de la Bibliothèque");
		System.out.println("\t4> Nombre de livre disponibles");
		System.out.println("\t5> Chercher les ouvrages d' un auteur" );
		System.out.println("\t6> Quitter");
		System.out.println("\t------------------------------------------------");
		System.out.print("\n\tVeuiller saisir votre choix: ");
	}
	public static void cls()
	{
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			
		} catch (Exception e) {
			System.out.println("e");
		}
	}
	public static void main(String[] args) {
		
		int option;
		double prix;
		String titre,ISBN;
	    Vector <String> Auteurs;
	    String auteur;
	    
		Scanner sclivre = new Scanner(System.in);
	    Scanner scAuteur= new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
	    
	
		Bibliotheque bibliotheque =  new Bibliotheque(2);
		
		Vector <String> Auteurslivre1 = new Vector<String>(1);
		Vector <String> Auteurslivre2 = new Vector<String>(1);
		Vector <String> Auteurslivre3 = new Vector<String>(1);
		
		Auteurslivre1.add("Shakspear");
		Auteurslivre2.add("Platon");
		Auteurslivre2.add("Victor hugo");
		
		livre MonLivre1 = new livre("Le songe", Auteurslivre2, "I458", 100);
		livre MonLivre2 = new livre("Le Banquet", Auteurslivre2, " AER2091M", 150.9);
		livre MonLivre3 = new livre("Les mésirables", Auteurslivre3, "13IS458", 400);
		
		bibliotheque.ajouteLivre(MonLivre1);
		bibliotheque.ajouteLivre(MonLivre2);
	    bibliotheque.ajouteLivre(MonLivre3);
		do {
			do {
				Menu();
				option = sc.nextInt();
				cls();
				//cls(); A revoir!!!
			} while (option>6 || option <0);
			switch(option)
			{
			case 1 : {
				System.out.println("Listes ouvrages: \n");
				System.out.println("Titre: \t\t  Auteur:   \t\t  ISBN  \t\t  Prix \t\t");
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println(bibliotheque);
				break;
			}
			case 2:{
				if(bibliotheque.size()<bibliotheque.capacite())
				{
					 System.out.print("Saisir le titre: ");
					 titre = sclivre.nextLine();
					 
					 System.out.print("\nSaisir le ISBN: ");
					 ISBN =sc.next();
		
					 System.out.print("\nSaisir le prix: ");
					 prix = sc.nextDouble();
					 
					 System.out.print("\nSaisir le nombre d' auteurs:  ");
					 option = sc.nextInt();
					 
					 Auteurs = new Vector <String> (option);
				   	for (int j = 1; j <= option; j++) {
					    System.out.printf("Saisir Auteur numero: ",j);
					    Auteurs.add(scAuteur.nextLine());
					    
					    bibliotheque.ajouteLivre(new livre(titre, Auteurs, ISBN, prix)) ;
					    System.out.print("le livre est ajoute avec sucssè!");
					} 
			  }//fin if
			  else System.out.println("Désolé, La bibliothèque est saturée!");
			  break;
			}
			case 3: {System.out.println("la bibliothèque peut supporter "+bibliotheque.capacite()+" ouvrages");break;}	
			case 4: {System.out.println("Votre bibliothèque dispose de "+bibliotheque.size()+" ouvrages");break;}
			case 5:{
				   System.out.print("Saisir le Non et le prenom de l auteur:");
				   auteur  = sc.next();
				   Vector  <livre> ouvrages = new Vector <livre> ();
				   ouvrages = bibliotheque.chercherLivre(auteur);
				   if(ouvrages.size()==0) {System.out.println("Aucun ouvrage associe à cet auteur");}
				   else {
						System.out.println("Titre: \t\t  Auteur:   \t\t  ISBN  \t\t  Prix \t\t");
						System.out.println("---------------------------------------------------------------------------------------------");
					    System.out.println(ouvrages);}
				   break;
			}
			case 6:{ System.exit(1);break;}
			default: {System.out.println("\nCHOIX INCORRECT");break;}
			}
		
		} while (option!=6);
	}
}	


