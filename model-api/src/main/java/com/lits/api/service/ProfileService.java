package com.lits.api.service;

import com.lits.api.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {

    List<ProfileDTO> findAll();

    ProfileDTO findById(int id);

    ProfileDTO create(ProfileDTO profileDTO);

    ProfileDTO update(ProfileDTO profileDTO);

    void delete(int id);
}
