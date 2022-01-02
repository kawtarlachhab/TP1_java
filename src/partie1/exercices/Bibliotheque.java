package partie1.exercices;

import java.util.Vector;

public class Bibliotheque {
 
 //DATA
  private Vector <livre> livres;    /**List des livres*/
  private int maxLivres;            /** le nombre maximal de livres que peut supporter la bibliothèque*/
  
  //Method
  public Bibliotheque(int nombreLivres)
  {
	  this.maxLivres =nombreLivres;
	  this.livres = new Vector<livre> (nombreLivres);
	  System.out.println("");
  }
  public int size()
  {
	  return (this.livres.size());
  }
  //capacite => le nombre max de livre que peut supporter la bibliothèque 
  public int capacite()
  {	  
	 return (this.maxLivres);
  }
  public void ajouteLivre(livre L) {this.livres.addElement(L);}
  @Override
  public String toString()
  {
	  String MesLivres =" ";
	  for(livre valeur: livres)
	  {
		  MesLivres += valeur.toString()+"\n";
	  }
	  return MesLivres;
  }
  public Vector chercherLivre(String Auteur)
  {
	  Vector <livre> SesOvrages = new Vector <livre>();
	   for(livre valeur : livres)
	   {
		   if(valeur.chercher_Dans_AuteursLivre(Auteur)) {SesOvrages.add(valeur);}
	   }
	   return SesOvrages; 
  }
}
 

