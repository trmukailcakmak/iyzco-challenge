package com.iyzico.challenge.contoller;

import com.google.gson.Gson;
import com.iyzico.challenge.TestDataPool;
import com.iyzico.challenge.constant.EndPointConstant;
import com.iyzico.challenge.mapper.SeatMapper;
import com.iyzico.challenge.model.dto.SeatDto;
import com.iyzico.challenge.model.request.SeatRequest;
import com.iyzico.challenge.model.response.SeatResponse;
import com.iyzico.challenge.service.SeatService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SeatControllerTest {

    private final SeatMapper seatMapper = SeatMapper.INSTANCE;
    private final Gson gson = new Gson();

    @InjectMocks
    private SeatController seatController;

    @Mock
    private SeatService seatService;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(seatController).build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addSeat() throws Exception {
        SeatRequest seatRequest = TestDataPool.createSeatRequest();
        SeatDto seatDto = TestDataPool.createSeatDto();
        String requestBodyJson = gson.toJson(seatRequest);
        String endPoint = EndPointConstant.SEAT_PREFIX+EndPointConstant.ADD;
        Mockito.when(seatService.addAndUpdateSeat(Mockito.any(SeatDto.class))).thenReturn(seatDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        SeatResponse seatResponse = gson.fromJson(responseMessage,SeatResponse.class);
        Assert.assertEquals(seatResponse.getSeatNum(),seatDto.getSeatNum());
    }

    @Test
    public void updateSeat() throws Exception {
        SeatRequest seatRequest = TestDataPool.createSeatRequest();
        SeatDto seatDto = TestDataPool.createSeatDto();
        String requestBodyJson = gson.toJson(seatRequest);
        String endPoint = EndPointConstant.SEAT_PREFIX+EndPointConstant.UPDATE;
        Mockito.when(seatService.addAndUpdateSeat(Mockito.any(SeatDto.class))).thenReturn(seatDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        SeatResponse seatResponse = gson.fromJson(responseMessage,SeatResponse.class);
        Assert.assertEquals(seatResponse.getSeatNum(),seatDto.getSeatNum());
    }

    @Test
    public void deleteSeat() throws Exception {
        String endPoint = EndPointConstant.SEAT_PREFIX+EndPointConstant.DELETE;
        Mockito.when(seatService.deleteSeat(Mockito.anyInt())).thenReturn(Boolean.TRUE);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(endPoint,12).content(String.valueOf(1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertTrue(responseMessage.contains("Basarili"));

        Mockito.when(seatService.deleteSeat(Mockito.anyInt())).thenReturn(Boolean.FALSE);
        result = mockMvc
                .perform(MockMvcRequestBuilders.delete(endPoint,12).content(String.valueOf(1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        response = result.getResponse();
        responseMessage = response.getContentAsString();
        Assert.assertTrue(responseMessage.contains("Silme"));
    }
}