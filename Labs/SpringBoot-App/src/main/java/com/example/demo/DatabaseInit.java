package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Component
public class DatabaseInit implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;

	@Autowired
	private ProduceRepository produceRepository;

	@Autowired
	private SellerProduceRepository sellerProduceRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	
	@Override
	 public void run(String... args) throws Exception {
		sellerProduceRepository.deleteAll();
		produceRepository.deleteAll();
		userRepository.deleteAll();
		orderItemsRepository.deleteAll();
		orderRepository.deleteAll();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User Bob = new User("Bob","bob@sample.com", encoder.encode("bob_pass"), UserType.BUYER);
		userRepository.save(Bob);
		
		User Alice = new User("Alice", "alice@sample.com", encoder.encode("alice_pass"), UserType.SELLER);
		userRepository.save(Alice);
		
		User Carol = new User("Carol", "carol@sample.com", encoder.encode("carol_pass"), UserType.BOTH);
		userRepository.save(Carol);		

		User Altti = new User("Altti", "altti@sample.com", encoder.encode("altti_pass"), UserType.BUYER);
		userRepository.save(Altti);

		//print all users
		for (User user : userRepository.findAll()) {
            System.out.println(user.toString());
        }
		
		Produce apple = new Produce("apple");
		Produce lettuce = new Produce("lettuce");
		Produce potato = new Produce("potato");

		produceRepository.saveAll(Arrays.asList(apple,lettuce,potato));

		SellerProduce Alice_apple = new SellerProduce(Alice,apple,0.15,100);
		SellerProduce Alice_lettuce = new SellerProduce(Alice, lettuce, 0.25, 20);
		SellerProduce Carol_apple = new SellerProduce(Carol, apple, 0.3, 50 );
		SellerProduce Carol_potato = new SellerProduce(Carol, potato, 0.05, 30);

		sellerProduceRepository.saveAll(Arrays.asList(Alice_apple, Alice_lettuce, Carol_apple, Carol_potato));

		Order Bob_order = new Order(Bob);
		OrderItem Bob_apple = new OrderItem(Carol_apple,2,0.3);
		OrderItem Bob_lettuce = new OrderItem(Alice_lettuce, 1, 0.25);
		Bob_apple.setOrder(Bob_order);
		Bob_lettuce.setOrder(Bob_order);
		orderRepository.save(Bob_order);
		orderItemsRepository.saveAll(Arrays.asList(Bob_apple, Bob_lettuce));

		SellerProduce Carol_apple_InDB = sellerProduceRepository.findById(Carol_apple.getId()).get();
		Carol_apple_InDB.setQuantity(Carol_apple_InDB.getQuantity()-2);
		sellerProduceRepository.save(Carol_apple_InDB);
		SellerProduce Alice_lettuce_InDB = sellerProduceRepository.findById(Alice_lettuce.getId()).get();
		Alice_lettuce_InDB.setQuantity(Alice_lettuce_InDB.getQuantity()-1);
		sellerProduceRepository.save(Alice_lettuce_InDB);
		
		Order Altti_order = new Order(Altti);		
		OrderItem Altti_apple = new OrderItem(Alice_apple,10, 0.15);
		OrderItem Altti_potato = new OrderItem(Carol_potato, 15, 0.05);
		Altti_apple.setOrder(Altti_order);
		Altti_potato.setOrder(Altti_order);
		orderRepository.save(Altti_order);
		orderItemsRepository.saveAll(Arrays.asList(Altti_apple,Altti_potato));

		SellerProduce Alice_Apple_InDB = sellerProduceRepository.findById(Alice_apple.getId()).get();
		Alice_Apple_InDB.setQuantity(Alice_Apple_InDB.getQuantity()-10);
		sellerProduceRepository.save(Alice_Apple_InDB);
		SellerProduce Carol_potato_InDB = sellerProduceRepository.findById(Carol_potato.getId()).get();
		Carol_potato_InDB.setQuantity(Carol_potato_InDB.getQuantity()-15);
		sellerProduceRepository.save(Carol_potato_InDB);



		//print all produce Carol sells with updated quantities
		for (SellerProduce produce : sellerProduceRepository.findBySeller(Carol)) {
            System.out.println(produce.toString());
        }

		System.out.println("Bob spent £" + orderItemsRepository.sumOrderItemsByOrderIdParams(Bob_order.getId()));



	}
}
