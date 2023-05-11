package linearSearch;

/* Linear search je iteracija kroz niz jedan po jedan element, poznat je i pod imenom 
 * Sequential search
 * 
 * Vreme potrebno da se izvrsi linear search je: O(n), sto znaci: sto se vise podataka pretrazuje,
 *  to ce vreme potrebno da se izvrsi pretrazivanje proporcionalno da raste.
 *  
 * Prednosti su mu da je brz kada je rec o malim grupama podataka, ne zahteva da se niz sortira, 
 * veoma je koristan za strukture podataka koje nemaju random access kao sto je LinkedList
 * 
 * Mana: spor je za velike grupe/nizove podataka  */

public class Main {
	
	// metoda koja ce da vrsi linear search u nizu i trazi odredjen element u njumu
	public static int linearSearch(int[] niz, int element) {
		for(int i = 0; i < niz.length; i++) {
			if(niz[i] == element)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] agrs) {
		int[] niz = {2, 14, 15, 3, 7, 9, 10, 18, 20, 6, 19, 15, 4};
		
		int index = linearSearch(niz, 9);
		// posto metoda linearSearch() ako ne pronadje element u nizu, vraca -1
		if(index != -1) {
			System.out.println("Element je pronadjen na indeksu: " + index);
		}else {
			System.out.println("Niz ne sadrzi zadati element");
		}
	}
}
