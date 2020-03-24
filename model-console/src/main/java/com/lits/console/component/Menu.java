package com.lits.console.component;

import com.lits.api.dto.ProfileDTO;
import com.lits.api.service.ProfileService;

import java.util.Scanner;

public class Menu {
    private ProfileService profileService;
    ProfileDTO profileDTO = new ProfileDTO();

    private int id;
    private String name;
    private String lastName;
    private int age;

    public Menu(ProfileService profileService) {
        this.profileService = profileService;
    }

    public void show() {
        System.out.println("1. Find all");
        System.out.println("2. Find by id");
        System.out.println("3. Create");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Exit");
    }

    public void run(int command) {

        switch (command) {
            case 1:
                findAll();
                break;

            case 2:
                findById();
                break;

            case 3:
                createProfile();
                break;

            case 4:
                updateProfile();
                break;

            case 5:
                deleteProfile();
                break;

            case 6:
                exit();
                break;

            default:
                System.out.println("Wrong command");
        }
    }

    public int scanInt(String textInConsole) {
        System.out.print(textInConsole);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String scanStr(String textInConsole) {
        System.out.print(textInConsole);
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void printProfile(ProfileDTO profileDTO) {
        System.out.println("Profile:");
        System.out.println("ID = " + profileDTO.getId());
        System.out.println("Name = " + profileDTO.getName());
        System.out.println("LastName = " + profileDTO.getLastName());
        System.out.println("Age = " + profileDTO.getAge());
    }

    public void findAll() {
        profileService.findAll().forEach(profileDTO -> {
            printProfile(profileDTO);
            System.out.println("---------------");
        });
    }

    public void findById() {
        profileDTO = profileService.findById(scanInt("Enter id: "));
        printProfile(profileDTO);
        System.out.println("---------------");
    }

    public void createProfile() {
        name = scanStr("Enter name: ");
        lastName = scanStr("Enter last_name: ");
        age = scanInt("Enter age: ");
        profileDTO = profileService.create(new ProfileDTO(name, lastName, age));
        System.out.println("---------------");
        printProfile(profileDTO);

        System.out.println("created");
        System.out.println("---------------");
    }

    public void updateProfile() {
        id = scanInt("Enter id: ");
        profileDTO = profileService.findById(id);
        printProfile(profileDTO);
        System.out.println("---------------");

        name = scanStr("Enter new name: ");
        lastName = scanStr("Enter new last_name: ");
        age = scanInt("Enter new age: ");

        ProfileDTO updProfileDTO = new ProfileDTO();
        updProfileDTO.setId(id);
        updProfileDTO.setName(name);
        updProfileDTO.setLastName(lastName);
        updProfileDTO.setAge(age);
        profileDTO = profileService.update(updProfileDTO);
        System.out.println("---------------");

        printProfile(profileDTO);
        System.out.println("updated");
        System.out.println("---------------");
    }

    public void deleteProfile() {
        id = scanInt("Enter id: ");
        profileDTO = profileService.findById(id);
        printProfile(profileDTO);

        profileService.delete(id);
        System.out.println("Profile deleted");
        System.out.println("---------------");
    }

    public void exit() {
        System.out.println("Exit...");
        System.exit(0);
    }

}