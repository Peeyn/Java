import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store implements Comparable<Animal>
{
    String nazwaSklepu;
    List<Animal> listaProduktow = new ArrayList<>(10);
    int maxPojemnosc = 20;
    static int iloscProduktow;

    Store()
    {
        this.nazwaSklepu = "";
        this.maxPojemnosc = 0;
    }

    Store(String nazwaSalonu, int maxPojemnosc)
    {
        this.nazwaSklepu = nazwaSalonu;
        this.maxPojemnosc = maxPojemnosc;
    }


    @Override
    public int compareTo(Animal o) {
        return 0;
    }

    int getSize()
    {
        return iloscProduktow;
    }


    void addProduct(Animal newAnimal)
    {
        if(iloscProduktow==maxPojemnosc)
        {
            System.out.println("Nie ma miejsca w sklepie: " + nazwaSklepu + "\n");
        }
        else
        {
            if (listaProduktow.contains(newAnimal))
            {
                newAnimal.ilosc++;
            }
            else
            {
                listaProduktow.add(newAnimal);
            }
            iloscProduktow++;
        }
    }

    void getProduct(Animal newAnimal)
    {
        if (listaProduktow.contains(newAnimal))
        {
            System.out.println("Sprzedano: " + newAnimal.krolestwo + newAnimal.gatunek + "\n");
            if (newAnimal.ilosc==1)
            {
                listaProduktow.remove(newAnimal);
            }
            else
            {
                newAnimal.ilosc--;
                iloscProduktow--;
            }
        }
        else
        {
            System.out.println("Brak takiego produktu w sklepie: " + nazwaSklepu + "\n");
        }
    }

    void removeProduct(Animal newAnimal)
    {
        if(listaProduktow.contains(newAnimal))
        {
            iloscProduktow -= newAnimal.ilosc;
            listaProduktow.remove(newAnimal);
        }
        else
            System.out.println("Brak takiego produktu w sklepie: " + nazwaSklepu + "\n");
    }

    Animal search(String gatunek)
    {
        for (Animal animal : listaProduktow)
        {
            if (animal.gatunek.compareTo(gatunek) == 0)
            {
                System.out.println("Znaleniono: " + gatunek + "\n");
                return animal;
            }
        }
        System.out.println("Nie znalezniono: " + gatunek + "\n");
        return null;
    }

    List<Animal> searchPartial(String gatunek)
    {
        List<Animal> allProducts = new ArrayList<>();
        for (Animal animal : listaProduktow)
        {
            if (animal.gatunek.contains(gatunek))
            {
                System.out.println("Znaleziono: " + animal.gatunek + "\n");
                allProducts.add(animal);
            }
        }
        if(allProducts.isEmpty())
            System.out.println("Nie znaleziono: " + gatunek + "\n");
        return allProducts;
    }

    int countByCondition(ItemCondition stan)
    {
        int counter = 0;
        for (Animal animal : listaProduktow)
        {
            if (animal.stan == stan)
                counter += animal.ilosc;
        }
        System.out.println("Znalezniono " + counter + " produktów w stanie: " + stan + "\n");
        return counter;
    }

    void summary()
    {
        for(Animal animal : listaProduktow)
            animal.print();
    }

    boolean isEmpty()
    {
        return this.listaProduktow.isEmpty();
    }

    //todo naprawic błędy
    List<Animal> sortByName()
    {
        Collections.sort(listaProduktow);
        return listaProduktow;
    }

    List<Animal> sortByAmount()
    {
        Collections.sort(listaProduktow, new AnimalComparator().reversed());
        return listaProduktow;
    }

    Animal max()
    {
        return Collections.max(listaProduktow, new AnimalComparator());
    }
}
