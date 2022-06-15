package jp.te4a.spring.boot.myapp13.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, String>{
}
