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
//		List<GymDto> gymList = mapper.selectList(dong);
//		List<GymDto> result = new ArrayList<GymDto>();
//
//		for (int i = 0; i < gymList.size(); i++) {
//			String location = gymList.get(i).getSjibun();
//			Float[] coords = findGeoPoint(location);
//
//			System.out.println(location + ": " + coords[0] + ", " + coords[1]);
//
//		}

		return mapper.selectList(dong);
	}

//	public static Float[] findGeoPoint(String location) {
//		  
//	    if (location == null)
//	      return null;
//
//	    // setAddress : 변환하려는 주소 (경기도 성남시 분당구 등)
//	    // setLanguate : 인코딩 설정
//	    GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(location).setLanguage("ko").getGeocoderRequest();
//
//	    try {
//	        Geocoder geocoder = new Geocoder();
//	        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
//
//	        if (geocoderResponse.getStatus() == GeocoderStatus.OK & !geocoderResponse.getResults().isEmpty()) {
//	            GeocoderResult geocoderResult=geocoderResponse.getResults().iterator().next();
//	            LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
//
//	            Float[] coords = new Float[2];
//	            coords[0] = latitudeLongitude.getLat().floatValue();
//	            coords[1] = latitudeLongitude.getLng().floatValue();
//	            ​return coords;
//	        }
//	    } catch (IOException ex) {
//	        ex.printStackTrace();
//	    }
//	    return null;
//	}

}
