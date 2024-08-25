package com.example.lib.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lib.model.Book;
public interface BookRepository extends JpaRepository<Book,Long> {

}
