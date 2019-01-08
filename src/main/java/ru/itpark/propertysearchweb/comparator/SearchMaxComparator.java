package ru.itpark.propertysearchweb.comparator;


import ru.itpark.propertysearchweb.domain.House;
import java.util.Comparator;

public class SearchMaxComparator implements Comparator<House> {

    @Override
    public int compare(House o1, House o2) {
        return   -(o1.getPrice() - o2.getPrice());
    }
}
