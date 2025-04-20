package com.medistore.inventory.service;

import com.medistore.inventory.model.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine addMedicine(Medicine medicine);
    Medicine updateMedicine(Long id, Medicine medicine);
    void deleteMedicine(Long id);
    Medicine getMedicineById(Long id);
    List<Medicine> getAllMedicines();
}
