package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	public static HouseDeal[] tmp;

	@Autowired
	private HouseDealMapper mapper;

	@Override
	public List<HouseDeal> selectDongDeal(String dongName) throws Exception {
		// 동만 선택시
		int mapper_size = mapper.selectAptDeal(dongName).size();
		HouseDeal arr[] = new HouseDeal[mapper_size];
		for (int i = 0; i < mapper_size; i++) {
			arr[i] = mapper.selectAptDeal(dongName).get(i);
			System.out.println(arr[i]);
		}
		
		mergeSort(arr);

		List<HouseDeal> final_tmp = new ArrayList<HouseDeal>();
		for (int i = 0; i < mapper_size; i++) {
			final_tmp.add(arr[i]);
		}

		return final_tmp;
	}

	@Override
	public List<HouseDeal> selectAptDeal(String aptName) throws Exception {
		// 아파트만 검색결과
		int mapper_size = mapper.selectAptDeal(aptName).size();
		HouseDeal arr[] = new HouseDeal[mapper_size];
		for (int i = 0; i < mapper_size; i++) {
			arr[i] = mapper.selectAptDeal(aptName).get(i);
			System.out.println(arr[i]);
		}
		
		mergeSort(arr);

		List<HouseDeal> final_tmp = new ArrayList<HouseDeal>();
		for (int i = 0; i < mapper_size; i++) {
			final_tmp.add(arr[i]);
		}

		return final_tmp;
	}

	@Override
	public List<HouseDeal> selectDongAptName(String dongName, String aptName) throws Exception {
		int mapper_size = mapper.selectDongAptName(dongName, aptName).size();
		HouseDeal arr[] = new HouseDeal[mapper_size];
		for (int i = 0; i < mapper_size; i++) {
			arr[i] = mapper.selectDongAptName(dongName, aptName).get(i);
			System.out.println(arr[i]);
		}
		
		mergeSort(arr);

		List<HouseDeal> final_tmp = new ArrayList<HouseDeal>();
		for (int i = 0; i < mapper_size; i++) {
			final_tmp.add(arr[i]);
		}

		return final_tmp;
	}

	//////////////////////////////////////////////////////
	public static void mergeSort(HouseDeal[] arr) {
		tmp = new HouseDeal[arr.length];
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(HouseDeal[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(HouseDeal[] arr, int start, int mid, int end) {
//		tmp = arr.clone();
		
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
		}

		int part1 = start;
		int part2 = mid + 1;
		int index = start;

		// 두 그룹중 한쪽의 원소가 오링날때까지 반복 (정렬 & 합병)
		while (part1 <= mid && part2 <= end) {
			String Deal_p = tmp[part1].getDealAmount().replace(",", "").trim();
			String Deal_q = tmp[part2].getDealAmount().replace(",", "").trim();

			if (Integer.parseInt(Deal_p) <= Integer.parseInt(Deal_q)) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}

		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
	//////////////////////////////////////////////////////
}
