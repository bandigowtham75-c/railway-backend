package com.example.railway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntelligentRailwayMonitoringApplication {

	public static void main(String[] args) {
		normalizeRenderPostgresUrl();
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

}
