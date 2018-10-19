package com.sut.sa.g21;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import com.sut.sa.g21.Entity.*;
import com.sut.sa.g21.Repository.OrderProductRepository;
import com.sut.sa.g21.Repository.ProductRepository;
import com.sut.sa.g21.Repository.StockRepository;
import com.sut.sa.g21.Repository.WarehouseRepository;
import com.sut.sa.g21.Repository.GenderRepository;
import com.sut.sa.g21.Repository.UserRepository;
import com.sut.sa.g21.Repository.ProvinceRepository;
import com.sut.sa.g21.Repository.PreorderRepository;


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
	double productPrice[] = {2000000.0, 1500000.0, 35000000.0, 50000000.0, 18900000.0, 8900000.0, 15390000.0};

	String WarehouseNameList[] = {
		"เชียงใหม่", "ปทุมธานี", "นครราชสีมา", "ชลบุรี", "ประจวบคีรีขันธ์",
		"Los Angeles, CA", "Miami, FL", "New York, NY", "London, UK", "Berlin, Germany", 
		"Paris, France", "Tokyo, Japan", "Seoul, South Korea", "Taipei, Taiwan", "Singapore"};
	String WarehouseCodeList[] = {
		"CMI", "PTE", "NMA", "CBI", "PKN",
		"LOSANGELES", "MIAMI", "NEWYORK", "LONDON", "BERLIN", 
		"PARIS", "TOKYO", "SEOUL", "TAIPEI", "SINGAPORE"};
	String nameProvinceList[] = {
		"กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ",
		"ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์",
		"นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร",
		"พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง",
		"ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร",
		"สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ",
		"อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี"
	};
	
	public static void main(String[] args) {
		SpringApplication.run(StockDbApplication.class, args);
	}
	

	@Bean
	ApplicationRunner init(ProductRepository productRepository, StockRepository stockRepository,
						   WarehouseRepository warehouseRepository, OrderProductRepository orderProductRepository,
						   GenderRepository genderRepository, UserRepository userRepository,
						   ProvinceRepository provinceRepository, PreorderRepository preorderRepository) {

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
				warehouse.setWarehouseName(WarehouseNameList[i]);
				warehouse.setWarehouseCode(WarehouseCodeList[i]);
				if(i < 5) {
					warehouse.setWarehouseAddress("THAI");
				} else {
					warehouse.setWarehouseAddress("FOREIGN");
				}
				warehouseRepository.save(warehouse);
			}
			for(int i = 0; i < nameProvinceList.length; i++) {
				Province newProvince = new Province();
				newProvince.setProvinceName(nameProvinceList[i]);
				provinceRepository.save(newProvince);
			}
			provinceRepository.findAll().forEach(System.out::println);
			productRepository.findAll().forEach(System.out::println);
			warehouseRepository.findAll().forEach(System.out::println);

			Gender genderM = new Gender("ชาย");
			Gender genderF = new Gender("หญิง");
			genderRepository.save(genderM);
			genderRepository.save(genderF);

			User newUser = new User(1);
			newUser.setUserUsername("Test01");
			newUser.setUserPassword("1234");
			newUser.setUserFirstName("Test");
			newUser.setUserLastName("Test");
			newUser.setUserEmail("test@test.t");
			newUser.setUserTelephone("0999999999");
			userRepository.save(newUser);

			
			for(long i = 1; i <= 5; i++) {
				Preorder preTest = new Preorder();
				preorderRepository.save(preTest);
			}
			preorderRepository.findAll().forEach(System.out::println);
		};
	}
}
