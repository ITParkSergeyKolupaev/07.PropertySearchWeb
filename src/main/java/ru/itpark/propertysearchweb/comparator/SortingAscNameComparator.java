package ru.itpark.propertysearchweb.comparator;

import ru.itpark.propertysearchweb.domain.House;

import java.io.Serializable;
import java.util.Comparator;

public class SortingAscNameComparator implements Comparator<House>, Serializable {

    @Override
    public int compare(House o1, House o2) {
        return o1.getArea().compareTo(o2.getArea());
    }
}
