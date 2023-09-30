package seminars.first.hw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StoreTest {

		/**
        1. Тест проверки списка продуктов (количество продуктов и содержимое корзины).
        */
		@Test
		public void testGetProducts() {
			Store store = new Store();
			List<Product> products = new ArrayList<>();  // Тестовый список продуктов
			products.add(new Product("Пицца с сыром", 599.99));
			products.add(new Product("Напиток Фанта", 85.59));
			products.add(new Product("Десерт Праздник", 178.99));

			products.add(new Product("Картошка Фри", 149.99));

			store.setProducts(products);

			List<Product> realProducts = store.getProducts();
			assertEquals(products.size(), realProducts.size());
			assertTrue(realProducts.containsAll(products));
			System.out.println(products);

		}

		/**
        2. Тест проверки метода вывода продукта с максимальной ценой getMostExpensiveProduct.
        */
		@Test
		public void testGetMostExpensiveProduct() {
			Store store = new Store();
			List<Product> products = new ArrayList<>();  // Тестовый список продуктов
			products.add(new Product("Пицца с сыром", 599.99));
			products.add(new Product("Напиток Фанта", 85.59));
			products.add(new Product("Десерт Праздник", 178.99));
			products.add(new Product("Картошка Фри", 149.99));

			store.setProducts(products);



			Product mostExpensiveProduct = store.getMostExpensiveProduct();
			System.out.println(mostExpensiveProduct.getCost());

			assertEquals("Пицца с сыром", mostExpensiveProduct.getTitle());
			Assertions.assertThat(599.99).isEqualTo(mostExpensiveProduct.getCost());
		}

		/**
        3. Тест проверки метода сортировки продуктов по стоимости sortProductsByPrice
        */
		@Test
		public void testSortProductsByPrice() {
			Store store = new Store();
			List<Product> products = new ArrayList<>();  // Тестовый список продуктов
			products.add(new Product("Пицца с сыром", 599.99));
			products.add(new Product("Напиток Фанта", 85.59));
			products.add(new Product("Десерт Праздник", 178.99));
			products.add(new Product("Картошка Фри", 149.99));

			store.setProducts(products);

			List<Product> sortedProducts = store.getSortedListProducts();  // Тестовый отсортированный список продуктов

			// Тест по всем эл-там списка

			Assertions.assertThat(85.59).isEqualTo(sortedProducts.get(0).getCost());
			Assertions.assertThat(149.99).isEqualTo(sortedProducts.get(1).getCost());
			Assertions.assertThat(178.99).isEqualTo(sortedProducts.get(2).getCost());
			Assertions.assertThat(599.99).isEqualTo(sortedProducts.get(3).getCost());

			// Тест по цене последнего продукта в отсортированном списке

	 		Assertions.assertThat(599.99).isEqualTo(sortedProducts.get(products.size()-1).getCost());
		}

	}





