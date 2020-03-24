package com.lits.model.service;

import com.lits.api.dto.ProfileDTO;
import com.lits.api.service.ProfileService;
import com.lits.model.dao.ProfileDao;
import com.lits.model.entity.Profile;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileServiceImpl implements ProfileService {
    private ProfileDao repo;

    public ProfileServiceImpl(ProfileDao repo) {
        this.repo = repo;
    }

    public List<ProfileDTO> findAll() {
        return repo.findAll().stream().map(this::profileToDTO).collect(Collectors.toList());
    }

    public ProfileDTO findById(int id) {
        return profileToDTO(repo.findById(id));
    }

    public ProfileDTO create(String name, String lastName, int age) {
        return profileToDTO(repo.create(name, lastName, age));
    }

    public ProfileDTO update(int id, String name, String lastName, int age) {
        return profileToDTO(repo.update(id, name, lastName, age));
    }

    public void delete(int id) {
        repo.delete(id);
    }

    private ProfileDTO profileToDTO(Profile profile) {
        ProfileDTO p = new ProfileDTO();
        p.setAge(profile.getAge());
        p.setId(profile.getId());
        p.setName(profile.getName());
        p.setLastName(profile.getLastName());
        return p;
    }
}
