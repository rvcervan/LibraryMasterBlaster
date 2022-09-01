package com.project.demo.repositories;

import com.project.demo.entities.BookCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCatalogRepository extends JpaRepository<BookCatalog, String> {
}
