package com.lits.api.service;

import com.lits.api.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {

    List<ProfileDTO> findAll();
    ProfileDTO findById(int id);
    ProfileDTO create(String name, String lastName, int age);
    ProfileDTO update(int id, String name, String lastName, int age);
    void delete(int id);
}
