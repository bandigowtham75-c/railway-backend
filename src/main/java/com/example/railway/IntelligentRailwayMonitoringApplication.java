package com.example.railway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntelligentRailwayMonitoringApplication {

	public static void main(String[] args) {
		normalizeRenderPostgresUrl();
		normalizeHibernateDdlAuto();
		SpringApplication.run(IntelligentRailwayMonitoringApplication.class, args);
	}

	private static void normalizeRenderPostgresUrl() {
		String rawUrl = System.getenv("SPRING_DATASOURCE_URL");
		if (rawUrl == null || rawUrl.isBlank()) {
			rawUrl = System.getenv("DATABASE_URL");
		}

		if (rawUrl == null || rawUrl.isBlank()) {
			return;
		}

		String normalizedUrl = rawUrl;
		if (normalizedUrl.startsWith("postgres://")) {
			normalizedUrl = "postgresql://" + normalizedUrl.substring("postgres://".length());
		}
		if (normalizedUrl.startsWith("postgresql://")) {
			normalizedUrl = "jdbc:" + normalizedUrl;
		}

		if (normalizedUrl.startsWith("jdbc:postgresql://")) {
			System.setProperty("spring.datasource.url", normalizedUrl);
		}
	}

	private static void normalizeHibernateDdlAuto() {
		String ddlAuto = System.getenv("SPRING_JPA_HIBERNATE_DDL_AUTO");
		if (ddlAuto == null || ddlAuto.isBlank()) {
			ddlAuto = System.getenv("HIBERNATE_HBM2DDL_AUTO");
		}

		String normalized = normalizeDdlAutoValue(ddlAuto);
		if (normalized != null) {
			System.setProperty("spring.jpa.hibernate.ddl-auto", normalized);
			System.setProperty("spring.jpa.properties.hibernate.hbm2ddl.auto", normalized);
		}
	}

	private static String normalizeDdlAutoValue(String value) {
		if (value == null || value.isBlank()) {
			return "update";
		}

		String cleaned = value.trim().toLowerCase();
		if (cleaned.contains("update")) {
			return "update";
		}
		if (cleaned.equals("validate") || cleaned.equals("none") || cleaned.equals("create")
				|| cleaned.equals("create-drop")) {
			return cleaned;
		}
		return "update";
	}

}
