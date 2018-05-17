package org.prezydium.streets;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.prezydium.streets.logic.RandomStreet;

public class RandomStreetTest {

    @Test
    public void shouldReturnNonEmptyString() throws Exception {
        RandomStreet randomStreet = new RandomStreet();
        Assertions.assertThat(randomStreet.getRandomStreet()).isNotEmpty();
    }

}