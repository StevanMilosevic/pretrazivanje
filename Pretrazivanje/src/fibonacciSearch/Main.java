package fibonacciSearch;

/* Fibonacci Search koristi Fibonacijev niz brojeva da bi pretrazio elemente u nizu.
 * Slican je Binary pretrazi zato sto radi samo sa sortiranim nizovima. Spada u divide and conquer algoritme.
 * 
 *  Razlika u odnosu na binary pretragu je da fibonaci pretraga deli niz na nejednake delove, zatim Binary koristi 
 *  deljenje (/) da bi podelio niz na pola, kod Fibonaci pretrage se koriste + i -. 
 *  
 *  Fibonaci brojevi se rekurzivno definisu: F(n) = F(n-1) + F(n-2), F(0) = 0, F(1) = 1
 *  Fibonaci brojevi su: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89... 
 *  
 *  Kako Fibonaci search algoritam radi:
 *  Ideja je da se prvo nadje najmanji Fibonacijev broj koji JE VECI OD ili JEDNAK duzini zadatog niza.
 *  Ako taj pronadjeni Fibonacijev broj oznacimo sa M, onda su dva Fibonacijeva broja koja mu prethode M-1 i M-2.
 *  Sve dok niz ima elemenata koji mogu da se provere uporedjujemo broj koji trazimo sa poslednjim elementom u 
 *  rasponu koji pokriva M-2. Ukoliko dodje do poklapanja, vracamo polozaj tog indeksa.
 *  ElseIf grana ako je manji od trazenog, sva tri Fibonacijeva broja (M, M-2 i M-1) za 2 na dole
 *  Else trazeni broj je veci, pomeramo sva tri Fibonacijeva broja za jedan na dole. i vrsime resetovanje 
 *  OFFSET vrednosti na vrednost indeksa */

public class Main {

	public static void main(String[] args) {
		int[] niz = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		System.out.println(fibonacciSearch(niz, 10, niz.length));
		
	}

	private static int fibonacciSearch(int[] niz, int x, int n) {
		// Inicijalizujemo fibonacijeve brojeve 
		
		int fibM2 = 0; 				// (m-2)'th Fibonacci No.
		int fibM1 = 1; 				// (m-1)'th Fibonacci No.
		int fibM = fibM2 + fibM1; 	//  m'th Fibonacci

		// fibM ce sadrzati najmanji Fibonacijev broj koji je veci ili jednak duzini zadatog niza 
		
		while (fibM < n) {
			fibM2 = fibM1;
			fibM1 = fibM;
			fibM = fibM2 + fibM1;
		}

		// Oznacava eliminisani opseg sa prednje strane
		int offset = -1;

		/*
		 * Sve dok ima elemenata za pretragu, pretrazujemo  niz[fibM2] sa trazenim brojem. 
		 * Kada fibM postane 1, fibM2 postaje 0
		 */
		while (fibM > 1) {
			// Proveravamo da li fibM2 validan indeks
			int i = ((offset + fibM2) <= (n - 1)) ? (offset + fibM2) : (n - 1);
	
			// Ako je trazeni broj veci od vrednosti indeksa fibM2, secemo niz 
			
			if (niz[i] < x) {
				fibM = fibM1;
				fibM1 = fibM2;
				fibM2 = fibM - fibM1;
				offset = i;
			}

			// Ako je trazeni broj manji od vrednosti indeksa fibM2, secemo niz nakon i + 1
			
			else if (niz[i] > x) {
				fibM = fibM2;
				fibM1 = fibM1 - fibM2;
				fibM2 = fibM - fibM1;
			}

			// vracamo indeks
			else
				return i;
		}

		// uporedjujemo poslednji element sa trazenim
		
		if (fibM1 == 1 && niz[n - 1] == x)
			return n - 1;

		// element nije pronadjen
		return -1;
	}

}
