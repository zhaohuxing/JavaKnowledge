package com.sprint.ctrls;

import java.util.*;
import java.io.*;
import com.sprint.service.UserService;
import com.sprint.models.domain.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserCtrl {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userService.findAll();	
	}

	@RequestMapping("/test")
	public void test() {
		userService.getAllByExcel("慧推移动-笔试题目-v1.1.xls");
	}

	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
 	public String handleFileUpload(@RequestParam("file") MultipartFile file){  
        if (!file.isEmpty()) {  
            try {  
                byte[] bytes = file.getBytes();  
                BufferedOutputStream stream =  
                        new BufferedOutputStream(new FileOutputStream(new File("慧推移动-笔试题目-v1.1.xls")));  
                stream.write(bytes);  
                stream.close();  
                return "You successfully uploaded";  
            } catch (Exception e) {  
                return "You failed to upload " + e.getMessage();  
            }  
        } else {  
            return "You failed to upload " + " because the file was empty.";  
        }  
	
    }	
}
