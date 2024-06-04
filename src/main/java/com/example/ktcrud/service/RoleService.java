package com.example.ktcrud.service;

import com.example.ktcrud.entity.Role;
import com.example.ktcrud.repository.RoleRepository;
import com.example.ktcrud.request.dto.RoleCreate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@NoArgsConstructor
@AllArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> findAll() {
        try {
            return roleRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Role addRole(RoleCreate roleCreate) {
        try {
            Role role = new Role();
            role.setRole_name(role.getRole_name());
            return roleRepository.save(role);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Role updateRole(Role role) {
        try {
            Role existingRole = roleRepository.findById(role.getRole_id())
                    .orElseThrow(() -> new RuntimeException("Role Not Found"));
            existingRole.setRole_name(role.getRole_name());
            return roleRepository.save(existingRole);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
