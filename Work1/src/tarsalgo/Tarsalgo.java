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
 *
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
package tarsalgo;

import java.awt.BorderLayout;
import java.util.*;
import java.io.*;

/**
 *
 * @author Kovács Ferenc
 */
public class Tarsalgo {

    static RandomAccessFile f;
    static ArrayList<Emberek> tarsalgo = new ArrayList<>();
    static int be;

    static void adatokBe(String f_neve) {

        try {
            f = new RandomAccessFile(f_neve, "r");
            String sor = f.readLine();
            while (sor != null) {
                tarsalgo.add(new Emberek(sor));
                sor = f.readLine();

            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba a beolvasásnál!!!");
        }
        System.out.println("Fájl bebeolvasása...\n\t...sikeresen megtörtént");
    }

    static void kiir() {
        for (int i = 0; i < tarsalgo.size(); i++) {
            System.out.println(tarsalgo.get(i).getOra() + " "
                    + tarsalgo.get(i).getOra() + " "
                    + tarsalgo.get(i).getAzonosito() + " "
                    + tarsalgo.get(i).getIrany());
        }
    }

    static void f2() {
        System.out.println("\n2.Feladat");
        int be = 0, ki = 0;
        int i = 0;
        while (be == 0) {
            if (tarsalgo.get(i).isBe()) {
                be = tarsalgo.get(i).getAzonosito();
            }
            i++;
        }
        System.out.println("Az első belépő: " + be);
        for (int j = 0; j < tarsalgo.size(); j++) {

            if (!tarsalgo.get(j).isBe()) {
                ki = tarsalgo.get(j).getAzonosito();
            }
        }
        System.out.println("Az utolsó kilépő: " + ki);
    }

    static void f3(String f_neve) {
        System.out.println("\n3.Feladat");
        try {
            f = new RandomAccessFile(f_neve, "rw");
            int[] count = new int[100];
            for (int i = 0; i < tarsalgo.size(); i++) {
                count[tarsalgo.get(i).getAzonosito()]++;
            }
            for (int i = 1; i < count.length; i++) {
                f.writeBytes(i + " " + count[i] + "\n");
            }
        } catch (Exception e) {
            System.out.println("Hiba a fájl kiírása közben!");
        }
        System.out.println("Kiírás....\t...Sikeresen megtörtént!");
    }

    static void f4() {
        System.out.println("\n4.Feladat");
        int[] szemely = new int[100];
        for (int i = 0; i < tarsalgo.size(); i++) {
            if (tarsalgo.get(i).getIrany().equals("be")) {
                szemely[tarsalgo.get(i).getAzonosito()]++;
            }
            if (tarsalgo.get(i).getIrany().equals("ki")) {
                szemely[tarsalgo.get(i).getAzonosito()]--;
            }

        }
        System.out.print("A végéna társalgóban voltak: ");
        for (int j = 0; j < szemely.length; j++) {
            if (szemely[j] == 1) {
                System.out.print(j + " ");
            }
        }

    }

    static void f5() {
        System.out.println("\n\n5.Feladat");

    }

    static void f6() {
        System.out.println("\n6.Feladat");
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg a személy azonosítóját: ");
        be = sc.nextInt();
    }

    static void f7() {
        System.out.println("\n7.Feladat");
        for (int i = 0; i < tarsalgo.size(); i++) {
            if (tarsalgo.get(i).getAzonosito() == be && tarsalgo.get(i).isBe()) {
                System.out.print(tarsalgo.get(i).getOra() + ":"
                        + tarsalgo.get(i).getPerc() + "-");
            }

            if (tarsalgo.get(i).getAzonosito() == be && !tarsalgo.get(i).isBe()) {
                System.out.print(tarsalgo.get(i).getOra() + ":"
                        + tarsalgo.get(i).getPerc() + "\n");
            }

        }
        System.out.println("");
    }

    static void f8() {
        System.out.println("\n8.Feladat");
        boolean bentVolt=false;
        int bent=0, kint=0, osszido=0;
        for (int i = 0; i < tarsalgo.size(); i++) {
            if (tarsalgo.get(i).getAzonosito() == be && tarsalgo.get(i).isBe()) {
                bent = tarsalgo.get(i).getIdo();
                bentVolt=true;
            }

            if (tarsalgo.get(i).getAzonosito() == be && !tarsalgo.get(i).isBe()) {
                kint = tarsalgo.get(i).getIdo();
                osszido+=(kint-bent);
                bentVolt=false;
            }
        }
        if (bentVolt) {
           osszido+=(15*60)-bent; 
           System.out.println("A(z) "+be+". személy összesen "+osszido+
                   " percet volt bent, a megfigyelés végén a társalgóban tartózkodott.");
        }
        else{
            System.out.println("A(z) "+be+". személy összesen "+osszido+
                   " percet volt bent");
        }
        
        
    }

    public static void main(String[] args) {
        adatokBe("ajto.txt");
        //kiir();
        f2();
        f3("athaladas.txt");
        f4();
        f5();
        f6();
        f7();
        f8();

    }

}
