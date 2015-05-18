package com.bk.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bk.model.Author;
import com.bk.model.Book;

/**
 * @author Andrei Petraru
 * Date: 28 Jan 2013
 */

@Transactional(readOnly = true)
public interface BookRepository extends Repository<Book, Long>, QueryDslPredicateExecutor<Book>, Serializable {

	Book findByIsbn(String isbn);

	@Transactional
	Book save(Book book);

	Book findById(Long id);

	Long count();

	Page<Book> findByAuthor(Author author, Pageable pageable);

	@Query("select b from Book b where b.id in :ids")
	List<Book> findByIDs(@Param("ids") List<Long> ids);

	@Query(value = "SELECT * FROM BOOK WHERE id in (SELECT book_id FROM REVIEW WHERE customer_id = ?1)", nativeQuery = true)
	List<Book> findByCustomerId(Long customerId);

}
