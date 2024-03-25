package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemove() {
        ShopRepository shop = new ShopRepository();
        Product fish = new Product(1, "Fish", 1000);
        Product milk = new Product(2, "Milk", 50);
        Product fruts = new Product(3, "Fruts", 500);

        shop.add(fish);
        shop.add(milk);
        shop.add(fruts);
        shop.remove(2);
        Product[] actual = shop.findAll();
        Product[] expected = {fish, fruts};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testNotFound() {
        ShopRepository shop = new ShopRepository();
        Product fish = new Product(1, "Fish", 1000);
        Product milk = new Product(2, "Milk", 50);
        Product fruts = new Product(3, "Fruts", 500);

        shop.add(fish);
        shop.add(milk);
        shop.add(fruts);


        Assertions.assertThrows(NotFoundException.class,
                () -> shop.remove(55)
        );
    }
    @Test
    public void testRemoveOver() {
        ShopRepository shop = new ShopRepository();
        Product fish = new Product(1, "Fish", 1000);
        Product milk = new Product(2, "Milk", 50);
        Product fruts = new Product(3, "Fruts", 500);

        shop.add(fish);
        shop.add(milk);
        shop.add(fruts);
        shop.remove(35);

        Product[] actual = shop.findAll();
        Product[] expected = {fish, milk, fruts};
        Assertions.assertArrayEquals(expected, actual);
    }


}