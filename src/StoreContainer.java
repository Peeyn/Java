import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreContainer
{
    Map<String,Store> mapaSklepow = new HashMap<>();
    void addNewStore(String nazwaSklepu, int maxPojemnosc)
    {
     Store newStore = new Store(nazwaSklepu, maxPojemnosc);
     mapaSklepow.put(nazwaSklepu,newStore);
    }

    Store getStore(String nazwaSklepu)
    {
        Store sklep = mapaSklepow.get(nazwaSklepu);
        return sklep;
    }

    List<Store> findEmpty()
    {
        List<Store> listaPustychSklepow = new ArrayList<>();
        Store newStore = new Store();
        for(Map.Entry sklepzMapy : mapaSklepow.entrySet())
        {
            newStore = (Store)sklepzMapy.getValue();
            if (newStore.isEmpty())
                listaPustychSklepow.add(newStore);
        }
        System.out.println("Liczba pustych sklepów: " + listaPustychSklepow.size() + "\n");
        return listaPustychSklepow;
    }

    void summary()
    {
        Store newStore = new Store();
        for (Map.Entry sklepzMapy : mapaSklepow.entrySet())
        {
            newStore = (Store)sklepzMapy.getValue();
            if(newStore.isEmpty())
                System.out.println(newStore.nazwaSklepu + " jest pusty.");
            else
                System.out.println(newStore.nazwaSklepu + " jest zapełniony w " + ((double)newStore.getSize() / ((double)newStore.maxPojemnosc) * 100) + "%. \n");
        }
    }
}
