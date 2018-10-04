package sut.sa.g21;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

import sut.sa.g21.Entity.*;
import sut.sa.g21.Repository.*;
import sut.sa.g21.Entity.Product;
import sut.sa.g21.Entity.Warehouse;
import sut.sa.g21.Repository.OrderProductRepository;
import sut.sa.g21.Repository.ProductRepository;
import sut.sa.g21.Repository.StockRepository;
import sut.sa.g21.Repository.WarehouseRepository;


@SpringBootApplication
public class StockDbApplication {

	String productList[] = {"Ferrari", "Porsche", "Lamborghini", "Bugatti",
	"Audi", "Ford", "Nissan"};
	String detailProduc[] = {"Ferrari 488", "Porsche 911", "Lamborghini Aventador", "Bugatti Chiron", 
	"Audi R8", "Ford Mustang", "Nissan GTR R35"};
	String imgUrl[] = {
		"https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/488-spieder-web-024.jpg?itok=RU9katpv",
		"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Porsche_918_Spyder_SAO_2014_0281.JPG/1200px-Porsche_918_Spyder_SAO_2014_0281.JPG",
		"https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/16q2/667349/2016-lamborghini-aventador-lp750-4-superveloce-test-review-car-and-driver-photo-667354-s-original.jpg",
		"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Bugatti_Chiron_IMG_0087.jpg/1200px-Bugatti_Chiron_IMG_0087.jpg",
		"https://s.aolcdn.com/commerce/autodata/images/USC70AUC171B021001.jpg",
		"https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/mustang-wc-3966.jpg?itok=5fOhpOXz",
		"https://cdn.shopify.com/s/files/1/0747/3829/products/mQ0326_1024x1024.jpeg?v=1485014085"
	};
	double productPrice[] = {599.0, 650.0, 789.0, 669.0, 889.0, 999.0, 556.0};

	String WarehouseNameList[] = {
		"เชียงใหม่", "ปทุมธานี", "นครราชสีมา", "ชลบุรี", "ประจวบคีรีขันธ์",
		"Los Angeles, CA", "Miami, FL", "New York, NY", "London, UK", "Berlin, Germany", 
		"Paris, France", "Tokyo, Japan", "Seoul, South Korea", "Taipei, Taiwan", "Singapore"};
	String WarehouseCodeList[] = {
		"CMI", "PTE", "NMA", "CBI", "PKN",
		"LOSANGELES", "MIAMI", "NEWYORK", "LONDON", "BERLIN", 
		"PARIS", "TOKYO", "SEOUL", "TAIPEI", "SINGAPORE"};

	
	public static void main(String[] args) {
		SpringApplication.run(StockDbApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository productRepository, StockRepository stockRepository,
						   WarehouseRepository warehouseRepository, OrderProductRepository orderProductRepository) {
		return args -> {
			for(int i = 0; i < productList.length; i++) {
				Product goods = new Product();
				goods.setProductName(productList[i]);
				goods.setProductDetail(detailProduc[i]);
				goods.setProductImgUrl(imgUrl[i]);
				goods.setProductPrice(productPrice[i]);
				productRepository.save(goods);
			}
			for(int i = 0; i < WarehouseCodeList.length; i++) {
				Warehouse warehouse = new Warehouse();
				warehouse.setWHName(WarehouseNameList[i]);
				warehouse.setWHCode(WarehouseCodeList[i]);
				if(i < 5) {
					warehouse.setWHAddress("THAI");
				} else {
					warehouse.setWHAddress("FOREIGN");
				}
				warehouseRepository.save(warehouse);
			}
			productRepository.findAll().forEach(System.out::println);
			warehouseRepository.findAll().forEach(System.out::println);
		};
	}
}
