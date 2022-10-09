class Main {

  public static boolean WildcardCharacters(String str) {
   
  boolean sonuc=true;
  int sayac=0;

  int a= str.indexOf(" ");  // boşluk olan yeri bulurum
  String str1 = str.substring(0,a);  // kelimeleri ayırırım
  String str2 = str.substring(a+1,str.length());
 

  
  for ( int i =0 ; i<str1.length(); i++){  // 1. kelime uzunluğuna kadar döngü kurarım
    String ifade=String.valueOf(str1.charAt(i));
  
    
    if (ifade.equals("+")){  // karekterimi kontrol ederim eğer + ise 
      if (Character.isAlphabetic(str2.charAt(sayac)) ){  // str2 de ki character alfabetik ise 
        sayac++;  // str2 de index sıramı takip edebilmek için elle 2. sayac kurar 1 artırırım
        sonuc=true;
      }else{
        sonuc = false;   // str2 de alfabetik karekter yok ise sonuç false
      }  // + ifadesinin kapanış yeri 

    }else if (ifade.equals("*")){  // karekterim eğer * ise 
      if ( (i+2) < str1.length()) {  // döngüyü bozmamak için str1 de +2 fazlası var mı diye kontrol
           if (Character.isDigit(str1.charAt(i+2)) ){ // +2 fazlas {5} şeklinde int bir ifademi diye bakarım
              String b = String.valueOf(str1.charAt(i+2)); // karakteri önce stringe 
             int tekrar = Integer.valueOf(b);  // sonra int değere çeviririm

              for ( int j =sayac ; j < ((sayac+tekrar)-1) ; j++){ // istenilen adet kadar var mı diye döngü kurarım
                  
                if ( j+1 < str2.length()){  // döngü bozulmasın diye uzunluk kontrolü 
                if (str2.charAt(j)==str2.charAt(j+1)){  // karekterler aynı mı diye kontrol ederim
                  sonuc = true;
                }else{  // karekterler aynı değilse sonuç false olur 
                  sonuc= false;
                }
                  }else{  // eğer döngü uzunluğum str2 uzunluğu arasında sorun varsa sonuç false olur
                    sonuc =false;
                  }
              }
              sayac+=tekrar;  // elle kurduğum sayacımı str1 ve str2 index takip edebilmek için istenilen tekrar kadar artırırım
           }
            // eğer istenilen bir adet sayısı yok ise {8} ifadesi yok ise random 3 tekrar kısmına geçerim  ............
          else {         

      if (sayac+2<str2.length()){ /* eğer 3 adet random konması gerekir iken eksik tekrar konuldu ise 
                                  örnek "+++++* abcdemm" gibi o zaman sonuc false olmalı */

      if ( (str2.charAt(sayac)==str2.charAt(sayac+1)) &&  (str2.charAt(sayac)== str2.charAt(sayac+2))){
        sayac=sayac+3;   // kontrollerde sorun yok ise elle kurulan sayac 3 artırılmalı
        sonuc=true;

    }else{
              // karekterler aynı değilse ise sonuc false
      sonuc=false;   
    }
           
      }else {  // 3 adet random adetinde sorun var ise sonuc false 

        sonuc=false;
      }

           }


      }  /*  eğer {5} şeklinde bir sayı belirtilmemiş ise ve yukarıda döngü kontrol amaçlı koyduğum
      (if ( (i+2) < str1.length())) kodu atlamak için içerde kurduğum random 3 kısmına programı 
      sokamadığım için yeniden aynı işlemleri yazdım */

      else {     
     if (sayac+2<str2.length()){ /* eğer 3 adet random konması gerekir iken eksik tekrar konuldu ise 
                                  örnek "+++++* abcdemm" gibi o zaman sonuc false olmalı */
      if ( (str2.charAt(sayac)==str2.charAt(sayac+1)) &&  (str2.charAt(sayac)== str2.charAt(sayac+2))){
        sayac=sayac+3;   // kontrollerde sorun yok ise elle kurulan sayac 3 artırılmalı
        sonuc=true;

      }else{
              // karekterler aynı değilse ise sonuc false
      sonuc=false;   
    }
           
      }else {  // 3 adet random adetinde sorun var ise sonuc false 

        sonuc=false;
      }
           
       }

  } // * sorgusunun süslü parantez kapanış yeri

  }  // for döngüsü kapanış yeri 

  if (str2.length()>sayac){   /* str1 deki karekter bitmesine rağmen str2 de karekter elle kurduğum 
  sayactan hala uzun ise fazlaadan karekter var demektir buda sonucu false yapar */

    sonuc=false;

  }

return sonuc ? true : false;  // ne programdı ama :)) 

  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(WildcardCharacters(s.nextLine())); 
  }

}
