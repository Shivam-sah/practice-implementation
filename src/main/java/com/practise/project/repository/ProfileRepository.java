package com.practise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.project.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Integer>{

}
