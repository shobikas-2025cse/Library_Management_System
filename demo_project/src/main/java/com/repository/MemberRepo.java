package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Member;
public interface MemberRepo extends JpaRepository<Member, Long> {
    
}
