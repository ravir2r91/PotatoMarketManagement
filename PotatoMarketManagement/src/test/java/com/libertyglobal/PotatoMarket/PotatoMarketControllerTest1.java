package com.libertyglobal.PotatoMarket;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
 * Test for checking happy path flow of GET method.
 * @author Rabindra Rakshit
 *
 */

public class PotatoMarketControllerTest1 {
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
	public void givenPotatoBags_whenGetPotatoBags_thenReturnJsonArray() throws Exception {
		
		PotatoBag potatoBag1 = new PotatoBag(Long.parseLong("1"),5,"Owel",LocalDateTime.now(),34);
		PotatoBag potatoBag2 = new PotatoBag(Long.parseLong("2"),5,"Owel",LocalDateTime.now(),34);
		PotatoBag potatoBag3 = new PotatoBag(Long.parseLong("3"),5,"Owel",LocalDateTime.now(),34);
		
		List<PotatoBag> potatoBagList = new ArrayList<PotatoBag>();
		// Collection<PotatoBag> allPotatoBags = new Collection<PotatoBag>();
		potatoBagList.add(potatoBag1);
		potatoBagList.add(potatoBag2);
		potatoBagList.add(potatoBag3);

		Collection<PotatoBag> allPotatoBags = potatoBagList;

		given(service.getPotatoBagList((Pageable) PageRequest.of(0, 3))).willReturn(allPotatoBags);

		mvc.perform(get("/PotatoBag?itemCount=3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
}
