public class Animal
{
    String krolestwo;       // zwierzeta i rosliny
    String gromada;         //ryby, plazy, gady, ptaki, ssaki, owady, pajęczaki
    String gatunek;         //małpa, bocian, szczur, wieloryb, sosna, modrzew, glista ludzka, tasiemiec
    ItemCondition stan;
    double cena;
    int wiek;
    int ilosc;
    double kosztUtrzymania;

    Animal ()
    {
        krolestwo = "";
        gromada = "";
        gatunek = "";
        stan = null;
        cena = 0;
        wiek = 0;
        ilosc = 0;
        kosztUtrzymania = 0;
    }

    Animal (String krolestwo, String gromada, String gatunek, ItemCondition stan, double cena, int wiek, int ilosc, double kosztUtrzymania)
    {
        krolestwo = krolestwo;
        gromada = gromada;
        gatunek = gatunek;
        stan = stan;
        cena = cena;
        wiek = wiek;
        ilosc = ilosc;
        kosztUtrzymania = kosztUtrzymania;
    }

    //todo compareTo
    //@Override
    public int compareTo(Animal newAnimal)
    {
        return this.gatunek.compareTo(newAnimal.gatunek);
    }

    //wypisanie danych zwierzęcia
    void print()
    {
        System.out.println("Wypisuje dla: " + krolestwo + "\n");
        System.out.println("Gromada: " + gromada + "\n");
        System.out.println("Gatunek: " + gatunek + "\n");
        System.out.println("Stan: " + stan + "\n");
        System.out.println("Cena: " + cena + "\n");
        System.out.println("Wiek: " + wiek + "\n");
        System.out.println("Ilość: " + ilosc + "\n");
        System.out.println("Przewidywany koszt utrzymania: " + kosztUtrzymania);
    }
}
