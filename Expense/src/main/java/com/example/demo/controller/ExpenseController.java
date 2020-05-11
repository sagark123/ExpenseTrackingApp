package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepo;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	private ExpenseRepo expenseRepo;
	
	@GetMapping("/expenses")
	List<Expense> getExpense()
	{
		return expenseRepo.findAll();
	}
	
	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable int id)
	{
		expenseRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException
	{
		Expense result = expenseRepo.save(expense);
		return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
	}
	
	@PutMapping("/expenses")
	ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense) throws URISyntaxException
	{
		Expense result = expenseRepo.save(expense);
		return ResponseEntity.ok().body(result);
	}	
}
