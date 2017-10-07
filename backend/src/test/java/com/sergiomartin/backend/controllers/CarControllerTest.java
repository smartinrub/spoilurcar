package com.sergiomartin.backend.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergiomartin.backend.models.Car;
import com.sergiomartin.backend.repositories.CarRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

	private Car car;
	private Car secondCar;
	private List<Car> cars;
	
	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private CarRepository repository;
	 
	@Before
	public void setUp() {
		 car = new Car();
		 car.setId("MA4886");
		 car.setModel("Seat Toledo");
		 car.setYear(1999);
		 car.setColor("maroon");
		 car.setParts(null);
		 secondCar = new Car();
		 secondCar.setId("1234ABC");
		 secondCar.setModel("BMW M3");
		 secondCar.setYear(2005);
		 secondCar.setColor("silver");
		 secondCar.setParts(null);
		 
		 cars = new ArrayList<Car>();
		 cars.add(car);
		 cars.add(secondCar);
	}
	
	@After
	public void tearDown() {
		this.car = null;
		this.cars = null;
	}

	@Test
	public void getAllCarsByidShouldReturnCarsJSONFromRespository() throws Exception {
		when(repository.findAll()).thenReturn(cars);
        this.mockMvc.perform(get("/api/cars")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("BMW M3")));
	}
	
	@Test
	public void createCarShouldReturnCarJSONFromRespository() throws Exception {
		repository.save(car);
        this.mockMvc.perform(post("/api/cars").content(asJsonString(car))
        		  .contentType(MediaType.APPLICATION_JSON)
        		  .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated())
                .andExpect(content().string(containsString("Seat Toledo")));
	}
	
	@Test
	public void getCarByidShouldReturnCarJSONFromRespository() throws Exception {
		when(repository.findOne("MA4886CX")).thenReturn(car);
        this.mockMvc.perform(get("/api/cars/MA4886CX")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Seat Toledo")));
	}
	
	@Test
	public void deleteCarByidShouldReturnOkStatus() throws Exception {
		repository.delete("MA4886CX");
        this.mockMvc.perform(delete("/api/cars/MA4886CX")).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  

}
