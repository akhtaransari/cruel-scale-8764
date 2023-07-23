package com.TheVeggieCart.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.TheVeggieCart.Exception.AdminNotFoundException;
import com.TheVeggieCart.Model.Admin;
import com.TheVeggieCart.Repository.AdminRepository;
import com.TheVeggieCart.Service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        if (!adminRepository.existsById(admin.getCustomerId())) {
            throw new AdminNotFoundException("Admin not found with ID: " + admin.getCustomerId());
        }
        Optional<Admin> a = adminRepository.findById(admin.getCustomerId());
        Admin a1 = a.get();
        a1.setContactNumber(a1.getContactNumber());
        a1.setCustomerId(a1.getCustomerId());
        a1.setEmail(a1.getEmail());
        a1.setName(a1.getName());
		
        return adminRepository.save(admin);
    }

    @Override
    public Admin removeAdmin(Integer adminId) {
    	Optional<Admin> findById = adminRepository.findById(adminId);
        if (findById.isEmpty()) {
            throw new AdminNotFoundException("Admin not found with ID: " + adminId);
        }
        adminRepository.deleteById(adminId);
        return findById.get();
    }

    @Override
    public Admin viewAdmin(Admin admin) {
        return adminRepository.findById(admin.getCustomerId())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with ID: " + admin.getCustomerId()));
    }

	@Override
	public List<Admin> viewAdmins() {
		List<Admin> findAll = adminRepository.findAll();
		if (findAll.isEmpty()) throw new NotFoundException("no admin here");
		return findAll;
	}
}
