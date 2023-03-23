package com.iyzico.challenge.contoller;

import com.google.gson.Gson;
import com.iyzico.challenge.TestDataPool;
import com.iyzico.challenge.constant.EndPointConstant;
import com.iyzico.challenge.constant.FullType;
import com.iyzico.challenge.mapper.FlightMapper;
import com.iyzico.challenge.model.dto.FlightDto;
import com.iyzico.challenge.model.request.FlightInformationRequest;
import com.iyzico.challenge.model.request.FlightRequest;
import com.iyzico.challenge.model.response.FlightInformationResponse;
import com.iyzico.challenge.model.response.FlightResponse;
import com.iyzico.challenge.service.FlightService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlightControllerTest {

    private final FlightMapper flightMapper = FlightMapper.INSTANCE;
    private final Gson gson = new Gson();

    @InjectMocks
    private FlightController flightController;

    @Mock
    private FlightService flightService;

    @Mock
    private MessageSource messageSource;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addFlight() throws Exception {
        FlightRequest flightRequest = TestDataPool.createFlightRequest();
        FlightDto flightDto = TestDataPool.createFlightDto();
        String requestBodyJson = gson.toJson(flightRequest);
        String endPoint = EndPointConstant.FLIGHT_PREFIX+EndPointConstant.ADD;
        Mockito.when(flightService.addAndUpdateFlight(Mockito.any(FlightDto.class))).thenReturn(flightDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        FlightResponse flightResponse = gson.fromJson(responseMessage,FlightResponse.class);
        Assert.assertEquals(flightResponse.getName(),flightDto.getName());
    }

    @Test
    public void updateFlight() throws Exception {
        FlightRequest flightRequest = TestDataPool.createFlightRequest();
        FlightDto flightDto = TestDataPool.createFlightDto();
        String requestBodyJson = gson.toJson(flightRequest);
        String endPoint = EndPointConstant.FLIGHT_PREFIX+EndPointConstant.UPDATE;
        Mockito.when(flightService.addAndUpdateFlight(Mockito.any(FlightDto.class))).thenReturn(flightDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        FlightResponse flightResponse = gson.fromJson(responseMessage,FlightResponse.class);
        Assert.assertEquals(flightResponse.getName(),flightDto.getName());
    }

    @Test
    public void deleteFlight() throws Exception {
        String endPoint = EndPointConstant.FLIGHT_PREFIX+EndPointConstant.DELETE;
        Mockito.when(flightService.deleteFlight(Mockito.anyInt())).thenReturn(Boolean.TRUE);
        Mockito.when(messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-success");
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(endPoint,12).content(String.valueOf(1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);

        Mockito.when(flightService.deleteFlight(Mockito.anyInt())).thenReturn(Boolean.FALSE);
        result = mockMvc
                .perform(MockMvcRequestBuilders.delete(endPoint,12).content(String.valueOf(1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        response = result.getResponse();
        responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }


    @Test
    public void testGetFlightInformation() throws Exception {
        List<FlightInformationResponse> flightInformationResponseList = new ArrayList<>();
        FlightInformationResponse flightInformationResponse = new FlightInformationResponse();
        flightInformationResponse.setFlightName("test-flight-name");
        flightInformationResponse.setSeatTypeName("test-seat-type-name");
        flightInformationResponse.setPrice(BigDecimal.ONE);
        flightInformationResponse.setSeatNum(Integer.valueOf(1));
        flightInformationResponseList.add(flightInformationResponse);
        FlightInformationRequest flightInformationRequest = new FlightInformationRequest();
        flightInformationRequest.setStatus(FullType.HALF);
        String requestBodyJson = gson.toJson(flightInformationRequest);
        String endPoint = EndPointConstant.FLIGHT_PREFIX+EndPointConstant.FLIGHT_INFORMATION;
        Mockito.when(flightService.getFlightInformation(Mockito.any(),Mockito.any())).thenReturn(flightInformationResponseList);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        List<FlightInformationResponse> flightInformationResponse1 = (List<FlightInformationResponse>)gson.fromJson(responseMessage,List.class);
        Assert.assertFalse(flightInformationResponse1.isEmpty());
    }
}