package ru.itpark.propertysearchweb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.itpark.propertysearchweb.domain.House;
import ru.itpark.propertysearchweb.repository.HouseRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service;

    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.addHouse(
                new House(1,  "Ново-Савиновский",9_000_000),
                new House(2,  "Вахитовский", 3_150_000),
                new House(3,  "Советский",4_005_000),
                new House(4,  "Московский",5_555_000)
        );
        service = new HouseService(repository);
    }

    @Test
    public void findByPriceWithZeroResults() {
        {
            List<House> result = service.findByPrice(10_000_000, 11_000_000);
            assertEquals(0, result.size());
        }
        {
            List<House> result = service.findByPrice(0, 1_500_000);
            assertEquals(0, result.size());
        }
    }

    @Test
    public void findByPriceWithOneResult() {
        int minPrice = 3_050_000;
        int maxPrice = 4_000_000;
        List<House> result = service.findByPrice(minPrice, maxPrice);
        assertEquals(1, result.size());

        int price = result.get(0).getPrice();
        assertTrue(price >= minPrice);
        assertTrue(price <= maxPrice);
    }

    @Test
    public void findByPriceWithMultipleResults() {
        int minPrice = 3_000_000;
        int maxPrice = 6_000_000;
        List<House> result = service.findByPrice(minPrice, maxPrice);
        assertEquals(3, result.size());

        // [0]
        // .get(0)

        for (House house : result) {
            int price = house.getPrice();
            assertTrue(price >= minPrice); // Ctrl + Alt + V
            assertTrue(price <= maxPrice);
        }

    }

    @Test
    public void findByDistrictsWithZeroResult() {
        List<House> result = service.findByArea("Вахитов", "Волга");

        assertEquals(0, result.size());
    }

    @Test
    public void findByDistrictsWithMultiplyResults() {
        List<House> result = service.findByArea("Московский", "Ново-Савиновский");

        assertEquals(2, result.size());
        //assertTrue(result.stream().allMatch(e -> List.of("М", "с").contains(e.getArea())));
    }

}