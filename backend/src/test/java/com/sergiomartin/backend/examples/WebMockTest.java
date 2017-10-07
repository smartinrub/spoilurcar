package com.sergiomartin.backend.examples;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sergiomartin.backend.controllers.CarController;
import com.sergiomartin.backend.models.Car;
import com.sergiomartin.backend.repositories.CarRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class WebMockTest {
	
	private Car car;
	
	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private CarRepository repository;
	 
	@Before
	public void setUp() {
		 this.car = new Car();
		 car.setId("MA4886");
		 car.setModel("Seat Toledo");
		 car.setYear(1999);
		 car.setColor("maroon");
		 car.setParts(null);
	}

	@Test
	public void getCarByidShouldReturnCarFromRespository() throws Exception {
		when(repository.findOne("MA4886CX")).thenReturn(car);
        this.mockMvc.perform(get("/api/cars/MA4886CX")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Seat Toledo")));
	}

}
