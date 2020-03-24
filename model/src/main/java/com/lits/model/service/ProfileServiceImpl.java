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

    public ProfileDTO create(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setName(profileDTO.getName());
        profile.setLastName(profileDTO.getLastName());
        profile.setAge(profileDTO.getAge());
        return profileToDTO(repo.create(profile));
    }

    public ProfileDTO update(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setId(profileDTO.getId());
        profile.setName(profileDTO.getName());
        profile.setLastName(profileDTO.getLastName());
        profile.setAge(profileDTO.getAge());
        return profileToDTO(repo.update(profile));
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
