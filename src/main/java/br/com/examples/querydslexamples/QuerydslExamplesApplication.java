package br.com.examples.querydslexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
public class QuerydslExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuerydslExamplesApplication.class, args);
	}

}
