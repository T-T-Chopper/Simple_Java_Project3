import java.util.Scanner;
public class Q2{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.print("Lutfen bir cumle giriniz: ");
    String girilen = scanner.nextLine();
    int max = 0;
    int min = 0;
    int karsilastir = 0;
    for (int i = 0; i < (girilen.length()-2); i++) { // Sınır aşımını engellemek icin.

      if ((int) girilen.charAt(i) == 55 && (int) girilen.charAt(i + 2) == 49 && (int) girilen.charAt(i + 1) != 32) { //Kontrol edilen karakter 7'den sonra bosluk var mi kontrol eder eger bosluk yoksa 7den sonra gelen karakter bir harf olmalidir ancak 7 den 2 sonra gelen karakter de 1 olmalidir.
        girilen = girilen.substring(0, i + 1) + " " + girilen.substring(i + 2, girilen.length());
        i = 0; //Cumle degistigi icin donguyu sifirladik.
      }
      // ilk dongu verilen ozel durumu duzeltir. 7'den sonra 1 gelmisse arada mutlaka bosluk olmalidir.
    }

    for (int j = 0; j < (girilen.length()); j++) { // Cumle icerisinde kelimeler arasindaki harfleri siler.
      if ((int) girilen.charAt(j) > 57) {
        girilen = girilen.substring(0, j) + girilen.substring(j + 1, girilen.length());
        j = 0;
      }
    }
    System.out.println();
    System.out.println("Girilen sayilar: " + girilen);
    int boslukyeri = girilen.indexOf(" ");
    int sayac = 0;
    int dongusayisi = 0;
    String girilen2 = girilen;

    for (int p = 0; p < 99; p++) // Fazla donguyu engeller.
    {
      int c = girilen2.indexOf(" ");
      if (c == -1) {
        dongusayisi++;
        break;

      }
      dongusayisi++;
      girilen2 = girilen2.substring(c).trim();

    }


    for (int a = 0; a <= dongusayisi - 1; a++) // Dongu sayisi yeterli olmasi icin
    {

      for (int c = boslukyeri; 0 < c; c--) {
        karsilastir = karsilastir + ((int) girilen.charAt(sayac++) - 48) * (int) Math.pow(10, c - 1);

      }

      if (karsilastir > max) {
        max = karsilastir;
      }
      if (karsilastir < min || min == 0) {
        min = karsilastir;
      }

      girilen = girilen.substring(boslukyeri).trim();

      boslukyeri = girilen.indexOf(" ");
      /*if(boslukyeri==girilen.length())
      break;*/

      if (boslukyeri == -1)
        boslukyeri = girilen.length();

      sayac = 0;

      karsilastir = 0;
    }
    System.out.println("En buyuk sayi: " + max);
    System.out.println("En kucuk sayi: " + min);

  }

}
