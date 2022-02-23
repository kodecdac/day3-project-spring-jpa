package in.cdac;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.cdac.models.OrderModel;
import in.cdac.repository.OrderModelRepository;

@SpringBootApplication
public class Day3Project2Application {
	
	@Autowired
	private OrderModelRepository orderModelRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(Day3Project2Application.class, args);
	}
	
	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void mymain() {
		
		OrderModel orderModel = new OrderModel();
		orderModel.setProductName("ABCD");
		orderModel.setProductId("ABCD001");
		orderModel.setProductQty(2);
		orderModel.setProductPrice(199.99);
		orderModel.setOffer(false);
		orderModel.setPurchaseDate(LocalDate.now());
		
		
		// ONE STEP SOLUTION BY SPRING JPA
		orderModelRepository.save(orderModel);
		
		System.out.println("Order Created!!");
	}

}
