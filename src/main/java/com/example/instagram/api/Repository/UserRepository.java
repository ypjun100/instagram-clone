package com.example.instagram.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.instagram.api.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
