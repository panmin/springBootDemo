package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by PanMin on 2017/5/10.
 */
@RestController//等同于@Controller和@ResponseBody
public class UserController {
    @Autowired
    private UserDB mUserDB;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return mUserDB.findAll();
    }

    @PostMapping("/addUser")
    public void addUser(User user){
        mUserDB.save(user);
    }

    @GetMapping("/getUserByAge/{age}")
    public  List<User> getUserByAge(@PathVariable("age") int age){
        return mUserDB.findByAge(age);
    }


    @GetMapping("/insertTwo")
    //@Transactional
    public void insertTwo(){
        User u1 = new User();
        u1.setName("aaa");
        u1.setAge(15);
        mUserDB.save(u1);

        User u2 = new User();
        u2.setName("bbb2222");
        u2.setAge(16);
        mUserDB.save(u2);
    }
}
