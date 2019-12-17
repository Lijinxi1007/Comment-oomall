package com.example.demo.feign;

import com.example.demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "UserInfo" )
/**
 * @author
 */
@RequestMapping("/userService")//还不知道叫什么
public interface UserServiceApi {


    /**
     * * 根据用户id获得用户信息
     * @param id
     * @return User
     */
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id);

}
