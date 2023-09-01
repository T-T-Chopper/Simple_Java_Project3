import java.util.Scanner;
public class Q1{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Bir metin giriniz:");
    String girilen = scanner.nextLine();
    girilen = girilen.toLowerCase();

    int palsayisi = 0;
    for (int x = 0; x < girilen.length() - 2; x++) { // istenen durum tek tek kontrol edildi.
      if (((girilen.charAt(x) == 'a' ||
            girilen.charAt(x) == 'e' ||
            girilen.charAt(x) == 'i' ||
            girilen.charAt(x) == 'o' ||
            girilen.charAt(x) == 'u') &&
          (girilen.charAt(x + 1) == '0' ||
            girilen.charAt(x + 1) == '1' ||
            girilen.charAt(x + 1) == '2' ||
            girilen.charAt(x + 1) == '3' ||
            girilen.charAt(x + 1) == '4' ||
            girilen.charAt(x + 1) == '5' ||
            girilen.charAt(x + 1) == '6' ||
            girilen.charAt(x + 1) == '7' ||
            girilen.charAt(x + 1) == '8' ||
            girilen.charAt(x + 1) == '9')) &&
        (((int) girilen.charAt(x + 2) > 97 && (int) girilen.charAt(x + 2) < 122) || ((int) girilen.charAt(x + 2) == 32) || ((int) girilen.charAt(x + 2) == 33) || ((int) girilen.charAt(x + 2) == 46) || ((int) girilen.charAt(x + 2) == 63))) {
        girilen = girilen.substring(0, x + 1) + girilen.substring(x + 2, girilen.length());

      }
    }
    System.out.println();

    for (int y = 0; y < girilen.length() - 2; y++) { //Fazla bosluklar silindi.
      if ((int) girilen.charAt(y) == 32 && (int) girilen.charAt(y + 1) == 32) {
        girilen = girilen.substring(0, y + 1) + girilen.substring(y + 2, girilen.length());
        y = 0;
      }
    }

    for (int y = 0; y < girilen.length() - 1; y++) { //nokta, unlem, soru isareti silindş
      if ((int) girilen.charAt(y) == 33 || (int) girilen.charAt(y) == 46 || (int) girilen.charAt(y) == 63) {
        girilen = girilen.substring(0, y) + girilen.substring(y + 1, girilen.length());
        y = 0;
      }
    }

    girilen = girilen.substring(0, (girilen.length()) - 1); // Cumle sonu silindi.

    String girilen2 = "";
    String girilen3 = "";
    String girilen5 = "";
    String girilenvirgulsuz = "";
    int boslukyeri = girilen.indexOf(" ");

    int dongusayisi = 0;
    String girilen4 = girilen;

    for (int p = 0; p < 99; p++) // Fazla donguyu engeller.
    {
      int c = girilen4.indexOf(" ");
      if (c == -1) {
        dongusayisi++;
        break;

      }
      dongusayisi++;
      girilen4 = girilen4.substring(c).trim();

    }

    for (int i = 0; i < dongusayisi; i++) { //Girilen kelimeler palindrom mu kontrolu yapilir.
      girilen2 = girilen.substring(0, boslukyeri).trim();
      boolean isPalindrome = true;
      int a = 0;
      int b = girilen2.length() - 1;

      while (a < b) {
        if (girilen2.charAt(a) != girilen2.charAt(b)) {
          isPalindrome = false; //ilk ve son krakter kontrol edilir aynı degilse polindrom degildir.
          break;
        }

        a++;
        b--;
      }

      if (isPalindrome) {
        if (girilen5.contains(girilen2)) //Ayni kelime varsa palindrom sayisi 1 dusurulur.
          palsayisi--;
        else
          girilen5 = girilen2 + ", " + girilen5;
        girilenvirgulsuz = girilen2 + " " + girilenvirgulsuz;
        palsayisi++;
      }

      girilen = girilen.substring(boslukyeri).trim();
      boslukyeri = girilen.indexOf(" ");
      if (boslukyeri == -1)
        boslukyeri = girilen.length();

    }

    System.out.println("Palindrom sayisi: " + palsayisi);
    girilen5 = girilen5.substring(0, girilen5.length() - 2);
    System.out.println("Palindromlar: " + girilen5);

    String uzun = "";
    String kısa = "";
    int uzunuzunluk = 0;
    int kisauzunluk = Integer.MAX_VALUE;

    int i = 0;

    //İlk while döngüsü, her bir kelimeye geçmek için kullanılır. İçteki while döngüsü ise, bir kelimenin uzunluğunu belirlemek için kullanılır. İçteki döngü, boşluk karakterine (' ') veya cümle sonuna kadar karakterleri tarar.
    while (i < girilenvirgulsuz.length()) {
      int j = i;
      while (j < girilenvirgulsuz.length() && girilenvirgulsuz.charAt(j) != ' ') {
        j++;
      }

      String word = girilenvirgulsuz.substring(i, j);
      int wordLength = word.length();

      if (wordLength > uzunuzunluk) {
        uzunuzunluk = wordLength;
        uzun = word;
      }

      if (wordLength < kisauzunluk) {
        kisauzunluk = wordLength;
        kısa = word;
      }

      i = j + 1;
    }

    System.out.println("En uzun palindrom: " + uzun);
    System.out.println("En kisa palindrom: " + kısa);

  }
}
