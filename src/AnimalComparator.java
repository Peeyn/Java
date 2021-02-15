import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalComparator implements Comparator<Animal>
{
    @Override
    public int compare(Animal animal1, Animal animal2)
    {
        return Integer.compare(animal1.ilosc, animal2.ilosc);
    }
    // todo {}
    List<Animal> sortByName()
    {
        System.out.println("Sortowaie A-Z: \n");
        Collections.sort(animalList);
        return animalList;
    }

    List<Animal> sortByAmount() {
        System.out.println("Sortowanie wg ilości: \n");
        Collections.sort(animalList, new AnimalComparator().reversed());
        return animalList;
    }

    Animal max() {
        System.out.println("Najwięcej: \n");
        return Collections.max(animalList, new AnimalComparator());
    }
}