package com.ssafy.happyhouse.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.service.UserService;

@Controller
@RequestMapping("/user")
public class Usercontroller {
	
	private static final Logger logger = LoggerFactory.getLogger(Usercontroller.class);

	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("/idcheck")
//	@ResponseBody
	public @ResponseBody String idCheck(@RequestParam("ckid") String checkId) throws Exception {
		int idCount = userService.idCheck(checkId);
		JSONObject json = new JSONObject();
		json.put("idcount", idCount);
		return json.toString();
	}
	
	@PostMapping("/sign")
	public String register(UserDto userDto, Model model) throws Exception {
		logger.debug("memberDto info : {}", userDto);
		userService.registerMember(userDto);
		return "redirect:/user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) throws Exception {
		logger.debug("map : {}", map.get("uid"));
		System.out.println(map.keySet());
		UserDto userDto = userService.login(map);
		if (userDto != null) {
			session.setAttribute("userinfo", userDto);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "Login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "MyPage";
	}
	
	@GetMapping("/delete")
	public String delete(HttpSession session) throws Exception{
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		userService.userDelete(userDto.getUid());
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/update")
	public String update(UserDto userDto, HttpSession session) throws Exception {
		userService.userUpdate(userDto);
		session.setAttribute("userinfo", userDto);
		return "MyPage";
	}
	
	
	
}