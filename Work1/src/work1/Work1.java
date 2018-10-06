/**
 * Egy színház társalgójában még a délelőtti próbák alatt is nagy a forgalom. A színészek
 * hosszabb-rövidebb beszélgetésekre térnek be ide, vagy éppen csak keresnek valakit.
 * A feladatban a társalgó ajtajánál !!9 és 15!! óra között felvett adatokat kell feldolgoznia.
 * Az ajto.txt fájlban időrendben rögzítették, hogy ki és mikor lépett be vagy ki a társalgó
 * egyetlen ajtaján. A fájl soraiban négy, szóközzel elválasztott érték található. Az első két szám
 * az áthaladás időpontja (óra, perc), a harmadik a személy azonosítója, az utolsó az áthaladás
 * iránya (be/ki). A sorok száma legfeljebb 1000, a személyek azonosítója egy 1 és 100 közötti
 * egész szám. Biztosan tudjuk, hogy a megfigyelés kezdetén (9 órakor) a társalgó üres volt, de
 * a megfigyelés végén (15 órakor) még lehettek benn a társalgóban. A társalgóba be- és
 * kilépéseket azok sorrendjében tartalmazza az állomány, még akkor is, ha a perc pontossággal
 * rögzített adatok alapján egyezőség áll fenn.
 *
 * A fenti példában a szürke mintázatú részen a bemeneti fájl első néhány sora látható.
 * A második sora azt mutatja, hogy a 9-es azonosítójú személy 9 óra 1 perckor lépett be
 * a társalgóba. A negyedik sorban olvasható, hogy 9 óra 5 perckor már ki is ment, tehát ekkor
 * összesen 4 percet töltött bent. A szürke rész sorai mellett olvasható számok azt mutatják, hogy
 * a be- vagy kilépést követően hányan vannak bent a társalgóban. Ez a szám egy percen belül
 * akár többször is változhat.
 * Készítsen programot, amely az ajto.txt állomány adatait felhasználva az alábbi
 * kérdésekre válaszol! A program forráskódját mentse tarsalgo néven! (A program
 * megírásakor a felhasználó által megadott adatok helyességét, érvényességét nem kell
 * ellenőriznie, feltételezheti, hogy a rendelkezésre álló adatok a leírtaknak megfelelnek.)
 * A képernyőre írást igénylő részfeladatok eredményének megjelenítése előtt írja a képernyőre
 * a feladat sorszámát (például: 4. feladat:)! Ha a felhasználótól kér be adatot, jelenítse meg
 * a képernyőn, hogy milyen értéket vár! Az ékezetmentes kiírás is elfogadott.

 * Feladatok
 *
 * 1. Olvassa be és tárolja el az ajto.txt fájl tartalmát!
 * 2. Írja a képernyőre annak a személynek az azonosítóját, aki a vizsgált időszakon belül először
 * lépett be az ajtón, és azét, aki utoljára távozott a megfigyelési időszakban!
 * 3. Határozza meg a fájlban szereplő személyek közül, ki hányszor haladt át a társalgó ajtaján!
 * A meghatározott értékeket azonosító szerint növekvő sorrendben írja az athaladas.txt
 * fájlba! Soronként egy személy azonosítója, és tőle egy szóközzel elválasztva az áthaladások
 * száma szerepeljen!
 * 4. Írja a képernyőre azon személyek azonosítóját, akik a vizsgált időszak végén a társalgóban
 * tartózkodtak!
 * 5. Hányan voltak legtöbben egyszerre a társalgóban? Írjon a képernyőre egy olyan időpontot
 * (óra:perc), amikor a legtöbben voltak bent!
 * 6. Kérje be a felhasználótól egy személy azonosítóját! A további feladatok megoldásánál ezt
 * használja fel!
 * Feltételezheti, hogy a megadott azonosítóhoz tartozik adat a forrásfájlban.
 * 7. Írja a képernyőre, hogy a beolvasott azonosítóhoz tartozó személy mettől meddig
 * tartózkodott a társalgóban!
 * A kiírást az alábbi, 22-es személyhez tartozó példának megfelelően alakítsa ki!
 * 8. Határozza meg, hogy a megfigyelt időszakban a beolvasott azonosítójú személy összesen
 * hány percet töltött a társalgóban! Az előző feladatban példaként szereplő 22-es személy
 * 5 alkalommal járt bent, a megfigyelés végén még bent volt. Róla azt tudjuk, hogy 18 percet
 * töltött bent a megfigyelés végéig. A 39-es személy 6 alkalommal járt bent, a vizsgált időszak
 * végén nem tartózkodott a helyiségben. Róla azt tudjuk, hogy 39 percet töltött ott. Írja ki,
 * hogy a beolvasott azonosítójú személy mennyi időt volt a társalgóban, és a megfigyelési
 * időszak végén bent volt-e még!
 */

package work1;

import java.util.*;
import java.io.*;
import java.nio.*;

/**
 *
 * @author Kovács Ferenc
 */
public class Work1 {
    static RandomAccessFile f;
    
    static void adatokBe(String f_neve)
    {
        try{
        f=new RandomAccessFile(f_neve, "r");
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    

    public static void main(String[] args) {
        adatokBe("ajto.txt");
    }

}
