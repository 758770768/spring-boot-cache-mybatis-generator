package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.UserMapper;
import com.example.pojo.User;

@Controller
public class TestController {

	@Resource
	private UserMapper ud;

	@RequestMapping("/")
	public String fn(Model model) {
		System.out.println("helo");
	//	Integer id = 2;
		User user = ud.selectByPrimaryKey(1);
		model.addAttribute("user", user);
		return "view";
	}

	@RequestMapping("/clearCache")
	@CacheEvict(value = "users", key = "#id")
	public String fn(Integer id) {
		System.out.println("clear oks");
		return "view";
	}

}
