package com.guessinggame.infrastructure;

import com.guessinggame.domain.*;
import java.util.Random;

public class RandomSecretNumberGenerator implements SecretNumberGenerator{
    private Random random;

    @Override
    public int generateSecretNumber(int start, int end) {
        random = new Random();
        return random.nextInt((end - start + 1) + start);
    }

    

}
