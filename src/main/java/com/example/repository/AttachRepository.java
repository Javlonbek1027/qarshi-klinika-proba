package com.example.repository;

import com.example.entity.Attach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AttachRepository extends CrudRepository<Attach,String> {
    Page<Attach> findAll(Pageable paging);

}
