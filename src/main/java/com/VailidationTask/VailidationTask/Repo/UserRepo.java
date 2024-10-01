package com.VailidationTask.VailidationTask.Repo;

import com.VailidationTask.VailidationTask.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
