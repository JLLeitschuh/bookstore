package com.bk.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bk.model.Book;
import com.bk.model.Customer;
import com.bk.model.Review;

/**
 * @author Andrei Petraru
 * Date: 3/13/13
 */
@Transactional(readOnly = true)
public interface ReviewRepository extends Repository<Review, Long>, Serializable {

    @Transactional
    Review save(Review review);

    @Query("select AVG(r.rating) from Review r where r.book = :book")
    Double getBookRating(@Param("book") Book book);

    @Query("select r from Review r where r.book = :book and r.customer = :customer")
    Review getCustomerRating(@Param("book")Book book, @Param("customer") Customer customer);

	@Query("select count(r) from Review r where r.book = :book and r.rating <> null")
	Long getNumberOfBookRatings(@Param("book") Book book);

    @Query("select r from Review r where r.customer = :customer")
    List<Review> getCustomerRatings(@Param("customer") Customer customer);

    @Query("select r from Review r where r.book = :book and r.comment <> null and r.comment <> ''")
	Page<Review> findByBook(@Param("book") Book book, Pageable pageable);

    @Query("select AVG(r.rating) from Review r where r.customer = :customer")
    Double getAverageRatingForCustomer(@Param("customer") Customer customer);

    @Query("select count(r) from Review r where r.customer = :customer")
    Long getNumberOfCustomerRatings(@Param("customer") Customer customer);
}
