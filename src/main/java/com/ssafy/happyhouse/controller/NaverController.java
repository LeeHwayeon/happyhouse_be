package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(origins = { "*" }, maxAge = 6000)
@CrossOrigin("*") // vscode 에서 테스트하는 localhost:8080같은 애가 요청해도 응답하겠음 이라는 설정
@RequestMapping("/naver")
public class NaverController {
	private static String clientId = "kIis_Z3HUgtghhxsg7QC"; // 애플리케이션 클라이언트 아이디값"
	private static String clientSecret = "gp_ujZP8vU"; // 애플리케이션 클라이언트 시크릿값"

	@ApiOperation(value = "네이버 뉴스검색 결과를 반환한다.", response = List.class)
	@GetMapping("/news/{keyword}")
	public String shop(@PathVariable("keyword") String keyword, HttpServletResponse response)
			throws UnsupportedEncodingException { // 네이버 쇼핑검색 요청
		String text = null;
		text = URLEncoder.encode(keyword, "UTF-8");

		String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text; // json 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		response.setContentType("text/json;charset=UTF-8");
		System.out.println(responseBody);

		return responseBody;
	}

	@ApiOperation(value = "네이버 블로그검색 결과를 반환한다.", response = List.class)
	@GetMapping("/blog/{keyword}")
	public String blog(@PathVariable("keyword") String keyword) throws UnsupportedEncodingException { // 네이버 쇼핑검색 요청
		String text = null;
		text = URLEncoder.encode(keyword, "UTF-8");

		String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println(responseBody);
		return responseBody;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

}