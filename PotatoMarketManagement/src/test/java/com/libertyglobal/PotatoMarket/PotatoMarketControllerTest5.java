package com.libertyglobal.PotatoMarket;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libertyglobal.PotatoMarket.ExceptionHandler.ExceptionThrower;
import com.libertyglobal.PotatoMarket.controllers.PotatoMarketController;
import com.libertyglobal.PotatoMarket.model.CustomException;
import com.libertyglobal.PotatoMarket.model.ErrorResponse;
import com.libertyglobal.PotatoMarket.model.PotatoBag;
import com.libertyglobal.PotatoMarket.model.PotatoBags;
import com.libertyglobal.PotatoMarket.service.PotatoMarketService;

@RunWith(SpringRunner.class)
@WebMvcTest(PotatoMarketController.class)

/**
 * Test for checking valid supplier while inserting new Potato Bags
 * 
 * @author Rabindra Rakshit
 *
 */

public class PotatoMarketControllerTest5 {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private PotatoMarketService service;

	@TestConfiguration
	static class ContextConfiguration {
		@Bean
		public PotatoBags getPotatoBagsBean() {
			return new PotatoBags();
		}
		@Bean
		public ErrorResponse getErrorResponseBean() {
			return new ErrorResponse();
		}
		@Bean
		public CustomException getCustomExceptionBean() {
			return new CustomException();
		}
		@Bean
		public ExceptionThrower getExceptionThrowerBean() {
			return new ExceptionThrower();
		}
		
	}

	@Autowired
	private PotatoBags potatoBags;
	@Autowired
	private ErrorResponse errorResponse;
	@Autowired
	private CustomException customException;
	@Autowired
	private ExceptionThrower exceptionThrower;


	@Test 
	public void addPotatoBag_validateSupplierList() throws Exception {
        PotatoBag potatoBag = new PotatoBag(Long.parseLong("1"),5,"Owel123",LocalDateTime.now(),34);
        mvc.perform(post("/PotatoBag/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(potatoBag)))
                .andExpect(status().isBadRequest());
    }
}
