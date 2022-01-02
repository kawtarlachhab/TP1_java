package partie1.exercices;

public class som {
public static void main(String[] args) {

	int sum = 0;
	for (String s: args) {
		try {
			sum += Integer.parseInt(s); 
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("le format saisi est incompatible!!");
		}
	}
	System.out.println("la somme est: "+sum);
}
}
