package com.senaadso.crud.springbootpatitapp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senaadso.crud.springbootpatitapp.modelos.User;

public interface UsersRepository extends JpaRepository<User,Integer>{
}
