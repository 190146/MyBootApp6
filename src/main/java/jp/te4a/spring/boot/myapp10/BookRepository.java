package jp.te4a.spring.boot.myapp10;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
public interface BookRepository extends JpaRepository<BookBean, Integer>{
	@Query("SELECT X FROM BookBean X ORDER BY X.title")
	List<BookBean> findAllOrderByTitle();
}

