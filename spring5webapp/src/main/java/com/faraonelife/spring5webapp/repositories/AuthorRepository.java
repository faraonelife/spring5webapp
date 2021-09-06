package com.faraonelife.spring5webapp.repositories;
import com.faraonelife.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author,Long> {
}
