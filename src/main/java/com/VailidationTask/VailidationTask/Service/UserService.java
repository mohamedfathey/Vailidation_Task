package com.VailidationTask.VailidationTask.Service;

import com.VailidationTask.VailidationTask.Entity.User;
import com.VailidationTask.VailidationTask.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ;

    public User insert (User user){
        return  userRepo.save(user);
    }

    public User findById(long id) {
        return userRepo.findById(id).get();
    }

    public List<User>findAllUser (){
        return  userRepo.findAll();
    }

}
