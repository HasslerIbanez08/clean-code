package com.co.personalsoft.examenreactive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Mono;

@DataR2dbcTest
@TestInstance(Lifecycle.PER_CLASS)
class ExamenReactiveApplicationTests {
	ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///testdb");

	private List<String> querysInit = new ArrayList<>();

	private static final int quantity = 30;

	@BeforeAll
	public void init() {
		querysInit.add(" DROP TABLE IF EXISTS PRODUCTS; ");
		querysInit.add(" CREATE table PRODUCTS (" + " id INT AUTO_INCREMENT NOT NULL, " + " name VARCHAR2, "
				+ " price number); ");
		querysInit.add(" DROP TABLE IF EXISTS categorys; ");
		querysInit.add(" CREATE table categorys (" + "	id INT AUTO_INCREMENT NOT NULL, " + "	name VARCHAR2, "
				+ "	product_fk int NOT NULL, " + "	FOREIGN KEY (product_fk) REFERENCES products(id)) ");
		Stream.iterate(0, (i) -> i + 1).limit(quantity).forEach(i -> {
			querysInit.add("Insert into products values (" + i + ",'Producto " + i + "'," + i * 30 + ");");
			querysInit.add("Insert into categorys values (" + i + ",'Categoria " + i + "'," + i + ");");
		});
		querysInit.forEach(query -> {
			Mono.from(connectionFactory.create())
					.flatMapMany(connectionFactory -> connectionFactory.createStatement(query).execute()).subscribe();
		});

	}

	@Test
	public void validCreateProductsTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection
						.createStatement("SELECT count(name) as countProduct FROM products ").execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("countProduct"))).doOnNext(count -> {
					assertEquals(Integer.parseInt(count.toString()), quantity-1);
				}).subscribe();
	}

	@Test
	public void validCreateCategorysTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection
						.createStatement("SELECT count(name) as countCategorys FROM categorys ").execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("countCategorys"))).doOnNext(count -> {
					assertEquals(Integer.parseInt(count.toString()), quantity-2);
				}).subscribe();
	}

	@Test
	public void validProductByIdTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection.createStatement("SELECT name FROM products where name=$1")
						.bind("$1", "Producto 1").execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("name")))
				.doOnNext(name -> assertEquals("Producto 1", name.toString())).subscribe();
	}

	@Test
	public void validCategoryByIdTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection.createStatement("SELECT name FROM categorys where name=$1")
						.bind("$1", "Categoria 1").execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("name")))
				.doOnNext(name -> assertEquals("Categoria 1", name.toString())).subscribe();
	}

	@Test
	public void updateProductByIdTest() {
		String nameProductUpdate = "ProductoUpdate1";
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection.createStatement("update products set name=$2 where name=$1")
						.bind("$1", "Producto 1").bind("$2", nameProductUpdate).execute())
				.subscribe();
		Mono.from(connectionFactory.create())
				.flatMapMany(connectionFactory -> connectionFactory
						.createStatement("SELECT name FROM products where name=$1").bind("$1", nameProductUpdate)
						.execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("name")))
				.subscribe(name -> assertEquals(nameProductUpdate, name.toString()));

	}

	@Test
	public void updateCategoryByIdTest() {
		String nameProductUpdate = "CategoriaUpdate1";
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection.createStatement("update categorys set name=$2 where name=$1")
						.bind("$1", "Categoria 1").bind("$2", nameProductUpdate).execute())
				.subscribe();
		Mono.from(connectionFactory.create())
				.flatMapMany(connectionFactory -> connectionFactory
						.createStatement("SELECT name FROM categorys where name=$1").bind("$1", nameProductUpdate)
						.execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("name")))
				.subscribe(name -> assertEquals(nameProductUpdate, name.toString()));

	}

	@Test
	public void deleteProductTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection
						.createStatement(
								" delete categorys where id = 1;"
							  + " delete products where id = 1;").execute())
				.subscribe();
		Mono.from(connectionFactory.create())
				.flatMapMany(connectionFactory -> connectionFactory
						.createStatement("SELECT count(name) as countProduct FROM products ")

						.execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("countProduct")))
				.subscribe(contador -> assertEquals(Integer.parseInt(contador.toString()),quantity-1 ));

	}
	@Test
	public void deleteCategoryTest() {
		Mono.from(connectionFactory.create())
				.flatMapMany(connection -> connection
						.createStatement(
								" delete categorys where id = 2;"
								).execute())
				.subscribe();
		Mono.from(connectionFactory.create())
				.flatMapMany(connectionFactory -> connectionFactory
						.createStatement("SELECT count(name) as countProduct FROM products ")

						.execute())
				.flatMap(result -> result.map((row, rowMetadata) -> row.get("countProduct")))
				.subscribe(contador -> assertEquals(Integer.parseInt(contador.toString()),quantity-1 ));

	}

}
