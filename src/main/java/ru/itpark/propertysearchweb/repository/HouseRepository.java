package ru.itpark.propertysearchweb.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.propertysearchweb.domain.House;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class HouseRepository {
    private List<House> houses = new ArrayList<>();

    public void addHouse(House... houses){
        this.houses.addAll(Arrays.asList(houses));
    }
    public List<House> getAllHouse(){
        return houses;
    }
}
