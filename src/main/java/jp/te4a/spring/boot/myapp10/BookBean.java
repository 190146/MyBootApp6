package jp.te4a.spring.boot.myapp10;


import org.springframework.boot.SpringApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// table class
@Entity
@Table(name = "book")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
	// データベースのID列を使用して主キー値を生成する
	// デフォルトのシーケンスを参照すると存在しないのでエラーとなる。
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@Column(nullable = false)
	private String title;
	private String writter;
	private String publisher;
	private Integer price;
}
