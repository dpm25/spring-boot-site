package com.mahoney.repository;

import com.mahoney.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactInfo, Long> {
}
