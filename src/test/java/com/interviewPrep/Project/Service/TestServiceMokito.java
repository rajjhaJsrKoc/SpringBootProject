package com.interviewPrep.Project.Service;

import com.interviewPrep.Project.NeDetailsDto.ModelMapperNetworkElement;
import com.interviewPrep.Project.NeDetailsDto.NetworkElementsDto;
import com.interviewPrep.Project.Repository.NeRepository;
import com.interviewPrep.Project.Service.impl.NeElementImpl;
import com.interviewPrep.Project.entities.NetworkElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestServiceMokito {

    @Mock
    private NeRepository neRepository;

    @Mock
    private ModelMapperNetworkElement mapper;

    @InjectMocks
    private NeElementImpl neElementImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetenNetworkElement(){
        NetworkElement ne1 = new NetworkElement();
        NetworkElement ne2 = new NetworkElement();
        List<NetworkElement> mockNeList = Arrays.asList(ne1, ne2);

        when(neRepository.findTop10()).thenReturn(mockNeList);

        // Mock mapper behavior
        // Don’t stub mapper — just call the real static method
        // Don't stub the mock data when it is static
        /*
        1. you stub either of: final/private/native/equals()/hashCode() methods. Those methods *cannot* be stubbed/verified.
        Mocking methods declared on non-public parent classes is not supported.
         2. inside when() you don't call method on mock but on some other object.
         */
        List<NetworkElementsDto> result = neElementImpl.getenNetworkElement();

        verify(neRepository).findTop10();
        assertEquals(2, result.size());
    }
    /*| Annotation / Call                    | What it does                                       |
            | ------------------------------------ | -------------------------------------------------- |
            | `@Mock`                              | Marks a field to be mocked                         |
            | `@InjectMocks`                       | Creates the class under test and injects the mocks |
            | `MockitoAnnotations.openMocks(this)` | Initializes the mocks & performs the injection     |
*/

}
