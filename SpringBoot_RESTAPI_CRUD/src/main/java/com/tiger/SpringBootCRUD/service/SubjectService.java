package com.tiger.SpringBootCRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiger.SpringBootCRUD.bean.Subject;
import com.tiger.SpringBootCRUD.repository.SubjectRepository;

@Service
public class SubjectService 
{
	@Autowired
	SubjectRepository repo;		
	
	//this method fetches all the subjects from the database
	public List<Subject> getAllSubjects()
	{
		List<Subject> subs = new ArrayList<>();
		repo.findAll().forEach(subs::add);
		return subs;
	}
	
	//this method adds the subjects to the database
	public Subject createSubject(Subject sub)
      {
	        Subject s = new Subject();
	        s.setId(sub.getId());
	        s.setName(sub.getName());
	        return repo.save(s);
	  }	
	
	//this method updates the subjects in the database
	public Subject updateSubject(String id,Subject s)
	{
		 Optional<Subject> optionalSubject = repo.findById(id);	        
	     if (optionalSubject.isPresent()) 
	        {
	            Subject sub = optionalSubject.get();
	            sub.setName(s.getName());	            
	            return repo.save(sub);
	        } 
	       else 
	        {
	            throw new NoSuchElementException("Subject not found with ID: " + id);
	        }		
	}
	
	//this method updates the subjects in the database
	public void deleteSubject(String id)
	{
		repo.deleteById(id);
	}
}
