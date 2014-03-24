package com.hamster.service;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hamster.model.Enums;
import com.hamster.model.ErrorCode;
import com.hamster.model.ErrorCodeType;

@ContextConfiguration(classes={TestConfig.class})
public class ErrorCodeServiceTest extends AServiceTest {

	@Autowired
	private ErrorCodeService service;
	
	@Test
	@DataSets(setUpDataSet="/com/hamster/service/ErrorCodeServiceGetByType.xls")
	public void testGetByType() {
		assertNull(service.getByType(Type.UNEXISTED));
		ErrorCode code = service.getByType(Type.EXISTED);
		assertNotNull(code);
		assertEquals(1, code.getId().longValue());
		assertEquals("Test error code", code.getDefautMessage());
	}
	
	private enum Type implements ErrorCodeType{
		EXISTED,
		UNEXISTED,
		;
		@Override
		public Serializable getId() {
			return Enums.getKey(this);
		}
		@Override
		public boolean isNew() {
			return false;
		}
	}
}
