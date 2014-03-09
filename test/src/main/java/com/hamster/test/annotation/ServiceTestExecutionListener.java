package com.hamster.test.annotation;

import org.apache.commons.lang3.StringUtils;
import org.dbunit.IDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class ServiceTestExecutionListener implements TestExecutionListener {

	public static final String DATABASE_TESTER_BEAN = "databaseTester",
								XLS_DATA_FILE_LOADER_BEAN = "xlsDataFileLoader";
	
	private IDatabaseTester databaseTester;
	
	@Override
	public void afterTestClass(TestContext arg0) throws Exception {
	}

	@Override
	public void afterTestMethod(TestContext testContext) throws Exception {
		if(databaseTester != null) {
			databaseTester.onTearDown();
		}
	}

	@Override
	public void beforeTestClass(TestContext arg0) throws Exception {
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		DataSets dataSets = testContext.getTestMethod().getAnnotation(DataSets.class);
		if(dataSets == null || StringUtils.isEmpty(dataSets.setUpDataSet())) {
			return;
		}
		databaseTester = testContext.getApplicationContext().getBean(DATABASE_TESTER_BEAN, IDatabaseTester.class);
		XlsDataFileLoader loader = testContext.getApplicationContext().getBean(XLS_DATA_FILE_LOADER_BEAN, XlsDataFileLoader.class);
		databaseTester.setDataSet(loader.load(dataSets.setUpDataSet()));
		databaseTester.onSetup();
	}

	@Override
	public void prepareTestInstance(TestContext arg0) throws Exception {
	}

}
