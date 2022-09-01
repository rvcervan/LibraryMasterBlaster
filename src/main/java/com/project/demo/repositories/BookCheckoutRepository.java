package com.project.demo.repositories;

import com.project.demo.entities.BookCheckout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCheckoutRepository extends JpaRepository<BookCheckout, String> {
}
