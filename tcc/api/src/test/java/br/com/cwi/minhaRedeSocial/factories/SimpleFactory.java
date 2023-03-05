package br.com.cwi.minhaRedeSocial.factories;

import java.util.Random;

public class SimpleFactory {

    public static Long getRandomLong() {
        return new Random().nextLong();
    }
}
