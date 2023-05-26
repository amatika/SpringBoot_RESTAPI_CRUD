package com.tiger.SpringBootCRUD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.SpringBootCRUD.bean.Subject;
import com.tiger.SpringBootCRUD.service.SubjectService;

@RestController
public class SubjectController 
{
	@Autowired
	private SubjectService serv;
	
	//this url mapping will fetch all the subjects from the database
	@RequestMapping("/subjects")
	List<Subject> getAllSubjects()
	{
		return serv.getAllSubjects();		
	}	
	
	//this request deletes a subject from the database
	@RequestMapping(method=RequestMethod.DELETE,value="/subjects/delete/{id}")
	public void deleteSubject(@PathVariable String id)
	{
		serv.deleteSubject(id);
	}
	
	//this request will update the user information in the database
	@PutMapping(value="/subjects/update/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String id, @RequestBody Subject sub) 
	{
        try 
        {
           Subject updatedSubject = serv.updateSubject(id, sub);            		
           return ResponseEntity.ok(updatedSubject);
        } 
        catch (NoSuchElementException e) 
        {
            return ResponseEntity.notFound().build();
        }
    }

	//this request will add the subject to the database
	 @PostMapping(value="/subjects/add",consumes =MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ResponseEntity<Subject> createSubject(@RequestBody Subject s) 
	 {
	      Subject sub = serv.createSubject(s);
	      return ResponseEntity.status(HttpStatus.CREATED).body(sub);
	 }
	
}
