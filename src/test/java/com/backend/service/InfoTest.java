package com.backend.service;

import com.backend.business.service.Info.InfoService;
import com.backend.domain.model.Info;
import com.backend.infrastructure.controller.InfoController;
import com.backend.infrastructure.repositories.InfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class InfoTest {
    @WebMvcTest(InfoController.class)
    static
    class UserControllerTest {

        @ExtendWith(MockitoExtension.class)
        public class InfoServiceTest {
            @Mock
            private InfoRepository infoRepository;

            @InjectMocks
            private InfoService infoService;

            @Test
            public void testGetAllInfos() {
                // Arrange
                List<Info> expectedInfos = Arrays.asList(new Info(1l,"Info_test1","Descrip_test1",20241110), new Info(2l,"Info2_test","Descrip_test1",20241110));

                // Mock the UserRepository to return the expected users
                when(infoRepository.findAll()).thenReturn(expectedInfos);

                // Act
                List<Info> actualInfos = infoService.findAll();

                // Assert
                assertEquals(expectedInfos, actualInfos);
            }
        }
    }
}
