package br.com.beachtennisbrazil.api.app.entities.validation.interfaces;

import java.util.Random;

public interface GameCodeGeneratorInterface {
    static int getUniqueRandomGameCode() {
            Random random = new Random();
            return random.ints(1015,9099)
                    .findFirst()
                    .getAsInt();
        }
    }


