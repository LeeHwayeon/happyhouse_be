package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.ParkDto;
import com.ssafy.happyhouse.model.mapper.ParkMapper;

@Service
public class ParkServiceImpl implements ParkService{

	@Autowired
	private ParkMapper mapper;
	
	@Override
	public List<ParkDto> selectList(String dong, double lat, double lng) throws Exception {
		List<ParkDto> Park =  mapper.selectList(dong) ;
		List<ParkDto> nearPark = new ArrayList<ParkDto>();
		
		for(int i=0; i<Park.size();i++) {
			String plat = Park.get(i).getPlat();
			String plng =  Park.get(i).getPlng();
			if(plng!=null &&plat!=null &&distance(lat, lng, Double.parseDouble(plat),Double.parseDouble(plng), "kilometer")<1)
				nearPark.add(Park.get(i));
		}
		return nearPark;
	}
	
    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
 
        return (dist);
    }
     
 
    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
