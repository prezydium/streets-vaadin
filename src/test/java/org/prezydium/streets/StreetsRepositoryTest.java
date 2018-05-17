package org.prezydium.streets;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.prezydium.streets.repository.StreetsRepository;

import java.util.List;

public class StreetsRepositoryTest {

    private List<String> listOfStreets;
    int sizeOfRepository;

    @Before
    public void setUp(){
        listOfStreets = new StreetsRepository().getStreets();
        sizeOfRepository = listOfStreets.size();
    }

    @Test
    public void shouldNotThrowException() throws Exception {
        Assertions.assertThat(listOfStreets.get(sizeOfRepository - 1)).isNotNull();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowNPEWhenStreetsIndexEqualToStreetsSize(){
        listOfStreets.get(sizeOfRepository);
    }

}