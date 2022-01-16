package com.emma.app.rest.Repo;




import com.emma.app.rest.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <Users, Long> {


}
