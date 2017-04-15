package com.sprint.controller;

import com.sprint.dto.VideoDTO;
import com.sprint.redis.RedisSourceManager;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
@Controller
public class IndexController {

	private final static String[] TAGS = {"LETV", "QQ"};

	@Autowired
	private RedisSourceManager redisSourceManager;
	@RequestMapping(value="/", method = RequestMethod.GET) 
	public String redis(Model model) {
		List<VideoDTO> carouselPics = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_CAROUSEL_KEY, TAGS[0]);
		for (VideoDTO v : carouselPics) {
			System.out.println(v.getImage());
		}
		model.addAttribute("carouselPics", carouselPics);
		return "home";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
