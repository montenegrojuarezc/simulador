package com.proyecto.simulador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SimuladorApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(SimuladorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		template.execute("DROP TABLE datos IF EXISTS");
		template.execute("CREATE TABLE datos (id INT AUTO_INCREMENT  PRIMARY KEY,descripcion VARCHAR(250) NOT NULL,tipo VARCHAR(250) NOT NULL)");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('Clásica', 'Tarjeta')");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('Oro', 'Tarjeta')");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('Black', 'Tarjeta')");

		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('5', 'Día de Pago')");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('20', 'Día de Pago')");

		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('99.90%', 'TEA')");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('95.90%', 'TEA')");
		template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('90.90%', 'TEA')");

		for (int i=1; i<=36;i++){
			template.execute("INSERT INTO datos (descripcion, tipo) VALUES ('"+i+"', 'Cuotas')");
		}

		template.execute("DROP TABLE Cliente IF EXISTS");
		template.execute("CREATE TABLE Cliente (id INT AUTO_INCREMENT  PRIMARY KEY,dni VARCHAR(8) NOT NULL,nombres VARCHAR(250) NOT NULL,tarjeta VARCHAR(250) NOT NULL)");
		template.execute("INSERT INTO Cliente (dni, nombres, tarjeta) VALUES ('46296018', 'Carlos Montenegro','Clásica')");
		template.execute("INSERT INTO Cliente (dni, nombres, tarjeta) VALUES ('45213233', 'Jose Perez','Oro')");
	}
}
