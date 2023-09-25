package com.test.service.client;

import com.test.entity.Book;
import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author Jungle 
 * @version 2023/09/23 23:45
**/
//@FeignClient("bookservice")
@FeignClient(value = "bookservice", fallback = BookFallbackClient.class)
public interface BookClient {

    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/book/{bid}")
    Book getBookById(@PathVariable("bid") int bid);  //参数和返回值也保持一致
}
