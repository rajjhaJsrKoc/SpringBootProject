package com.interviewPrep.Project.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Disabled
    @Test
    public void getTest(){
        Assertions.assertEquals(1,1);
        Assertions.assertNotNull(1);
    }
    @ParameterizedTest
    @CsvSource({
            "1,2,3"
    })
    public void parameterizedTest(int a,int b ,int expected){
        Assertions.assertEquals(expected,a+b);
    }

}
