package com.epsilon.training.dao;

import java.util.ResourceBundle;

public final class DaoFactory {

	private static final String discriminator;

	private DaoFactory() {
	}

	static {
		// gets executed only once when the class is loaded into JVM

		String envVal = System.getenv("DAO_IMPL");
		if (envVal == null) {
			ResourceBundle rb = ResourceBundle.getBundle("dao");
			discriminator = rb.getString("dao.impl");
		} else {
			discriminator = envVal;
		}
	}

	public static ProductDao getProductDao() {
		switch (discriminator.toUpperCase()) {
		case "DUMMY":
			return new DummyProductDao();
		case "ARRAY":
			return new ArrayProductDao();
		case "ARRAYLIST":
			return new ArrayListProductDao();
		case "MONGODB":
		case "CSV":
			throw new RuntimeException("Requested implementation of ProductDao not available yet.");
		default:
			throw new RuntimeException("Invalid discriminator");
		}
	}
}
