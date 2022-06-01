package jp.te4a.spring.boot.myapp7;


import org.springframework.boot.SpringApplication;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookBean {
	Integer id;
	String title;
	String writer;
	String publisher;
	Integer price;
}
