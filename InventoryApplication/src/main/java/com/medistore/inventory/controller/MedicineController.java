package com.medistore.inventory.controller;

import com.medistore.inventory.model.Medicine;
import com.medistore.inventory.service.MedicineService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping("/api/medicines")
	public ResponseEntity<Medicine> addMedicine(@Valid @RequestBody Medicine medicine) {
	    return new ResponseEntity<>(medicineService.addMedicine(medicine), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
		return medicineService.updateMedicine(id, medicine);
	}

	@DeleteMapping("/{id}")
	public void deleteMedicine(@PathVariable Long id) {
		medicineService.deleteMedicine(id);
	}

	@GetMapping("/{id}")
	public Medicine getMedicine(@PathVariable Long id) {
		return medicineService.getMedicineById(id);
	}

	@GetMapping
	public List<Medicine> getAllMedicines() {
		return medicineService.getAllMedicines();
	}
}
