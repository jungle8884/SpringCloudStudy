package com.test.service.client;

import com.test.entity.Book;
import org.springframework.stereotype.Component;

/**
 *  
 * @author Jungle 
 * @version 2023/09/24 00:30
**/
@Component
public class BookFallbackClient implements BookClient{
    @Override
    public Book getBookById(int bid) {
        Book book = new Book();
        book.setBid(bid);
        book.setDesc("我是替代方案");
        return book;
    }
}
