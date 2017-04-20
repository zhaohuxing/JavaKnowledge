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
		List<VideoDTO> recommends = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_RECOMMEND_KEY, TAGS[0]);
		List<VideoDTO> tvHots = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_TV_KEY, TAGS[0]);
		List<VideoDTO> tvTops = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_TV_HOT_KEY, TAGS[0]);	
		List<VideoDTO> movies = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_MOVIE_KEY, TAGS[0]);
		List<VideoDTO> animeHots = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_CARTOON_KEY, TAGS[0]);
		List<VideoDTO> animeNews = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_CARTOON_HOT_KEY, TAGS[1]);
		
		model.addAttribute("carouselPics", carouselPics);
		model.addAttribute("recommends", recommends);
		model.addAttribute("tvHots", tvHots);
		model.addAttribute("tvTops", tvTops);
		model.addAttribute("movies", movies);
		model.addAttribute("animeHots", animeHots);
		model.addAttribute("animeNews", animeNews);
		model.addAttribute("navIndex", 0);
		return "home";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
