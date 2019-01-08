package ru.itpark.propertysearchweb.service;

import org.springframework.stereotype.Service;
import ru.itpark.propertysearchweb.domain.House;
import ru.itpark.propertysearchweb.repository.HouseRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class HouseService {
    private HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void add(House house){
        houseRepository.addHouse(house);
    }

    public List<House> getAllHouse(){
        return houseRepository.getAllHouse();
    }
    public List<House> getSorted(Comparator<House> comparator) {
        List<House> result = houseRepository.getAllHouse();
        result.sort(comparator);
        return result;
    }

    public List<House> findByArea(String... areas) {

        List<House> result = new ArrayList<>();
        List<String> areasList = Arrays.asList(areas);

        for (House house : houseRepository.getAllHouse()) {

            if (areasList.contains(house.getArea())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByPrice(int minPrice, int maxPrice) {
        List<House> result = new ArrayList<>();
        for (House house : houseRepository.getAllHouse()) {
            if (house.getPrice() >= minPrice && house.getPrice() <= maxPrice) {
                result.add(house);
            }
        }
        return result;
    }
}
