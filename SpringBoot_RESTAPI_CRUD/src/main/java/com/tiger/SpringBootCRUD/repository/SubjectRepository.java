package com.tiger.SpringBootCRUD.repository;

import org.springframework.data.repository.CrudRepository;

import com.tiger.SpringBootCRUD.bean.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String> 
{

}
