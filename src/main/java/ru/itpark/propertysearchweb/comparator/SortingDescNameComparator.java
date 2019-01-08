package ru.itpark.propertysearchweb.comparator;

import ru.itpark.propertysearchweb.domain.House;
import java.util.Comparator;

public class SortingDescNameComparator implements Comparator<House> {

    @Override
    public int compare(House o1, House o2) {
        return -(o1.getArea().compareTo(o2.getArea()));
    }
}
