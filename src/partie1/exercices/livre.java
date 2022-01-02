package partie1.exercices;

import java.util.Vector;

public class livre {
	//DATA
	private  String titre,ISBN;
	private  Vector <String> auteur; // liste auteurs (un livre => appartient à 1 ou plusieurs auteurs
	private  Double prix;
   
	//Methode
	public livre(String titre,Vector <String> Auteurs,String ISBN, double prix) {
		this.titre  = titre;
		this.auteur = Auteurs;
		this.ISBN   = ISBN;
		this.prix   = prix;
	}
	
	@Override 
	public String  toString()
	{
	    return "" + this.titre + "\t\t"+ auteur.toString() + "\t\t" + this.ISBN + "\t\t" + this.prix+"DH\n";			
	} 
	
	boolean chercher_Dans_AuteursLivre(String Auteur)
	{
		for(String valeur: this.auteur )
		{
	         if(valeur.equals(Auteur))return true;
		}
		return false;
	}
}
