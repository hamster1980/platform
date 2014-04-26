package com.hamster.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hamster.model.Confirmation;

@ContextConfiguration(classes = { TestConfig.class })
@DataSets(setUpDataSet= "/com/hamster/service/TestData.xls")
public class ConfirmationServiceTest extends AServiceTest {

    @Autowired
    private ConfirmationService service;
    
    @Test
    @DataSets(setUpDataSet= "/com/hamster/service/ConfirmationServiceGetConfirmationByCode.xls")
    public void testGetConfirmationByCode() {
        Confirmation confirmation = service.getConfirmationByCode("UNEXISTED_CODE");
        assertNull(confirmation);
        confirmation = service.getConfirmationByCode("EXISTED_CODE");
        assertNotNull(confirmation);
    }

 /*
  * send
  * 1. check creation new entity after method invocation
  * 2. check person contact for null, for each value, for each value when contact is not existed
  */
}
