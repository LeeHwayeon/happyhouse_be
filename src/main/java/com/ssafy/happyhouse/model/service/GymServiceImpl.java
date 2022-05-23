package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.google.code.geocoder.Geocoder;
//import com.google.code.geocoder.GeocoderRequestBuilder;
//import com.google.code.geocoder.model.GeocodeResponse;
//import com.google.code.geocoder.model.GeocoderRequest;
//import com.google.code.geocoder.model.GeocoderResult;
//import com.google.code.geocoder.model.GeocoderStatus;
//import com.google.code.geocoder.model.LatLng;
import com.ssafy.happyhouse.model.dto.GymDto;
import com.ssafy.happyhouse.model.mapper.GymMapper;

@Service
public class GymServiceImpl implements GymService {

	@Autowired
	private GymMapper mapper;

	@Override
	public List<GymDto> selectList(String dong) throws Exception {
		return mapper.selectList(dong);
	}


}
