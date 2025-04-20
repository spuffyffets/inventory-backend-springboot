package com.medistore.inventory.serviceImpl;

import com.medistore.inventory.model.Medicine;
import com.medistore.inventory.repository.MedicineRepository;
import com.medistore.inventory.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine updatedMedicine) {
        Optional<Medicine> existing = medicineRepository.findById(id);
        if (existing.isPresent()) {
            Medicine medicine = existing.get();
            medicine.setName(updatedMedicine.getName());
            medicine.setCompany(updatedMedicine.getCompany());
            medicine.setPrice(updatedMedicine.getPrice());
            medicine.setQuantity(updatedMedicine.getQuantity());
            medicine.setExpiryDate(updatedMedicine.getExpiryDate());
            return medicineRepository.save(medicine);
        }
        return null;
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
}
