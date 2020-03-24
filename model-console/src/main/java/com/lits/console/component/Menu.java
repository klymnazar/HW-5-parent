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
                profileService.findAll().forEach(profileDTO -> {
                    printProfile(profileDTO);
                });
                break;

            case 2:
                profileDTO = profileService.findById(scanInt("Enter id: "));

                printProfile(profileDTO);
                break;

            case 3:
                name = scanStr("Enter name: ");
                lastName = scanStr("Enter last_name: ");
                age = scanInt("Enter age: ");
                profileDTO = profileService.create(name, lastName, age);
                printProfile(profileDTO);

                System.out.println("created");
                break;

            case 4:
                id = scanInt("Enter id: ");
                profileDTO = profileService.findById(id);
                printProfile(profileDTO);

                name = scanStr("Enter new name: ");
                lastName = scanStr("Enter new last_name: ");
                age = scanInt("Enter new age: ");
                profileDTO = profileService.update(id, name, lastName, age);
                printProfile(profileDTO);

                System.out.println("updated");
                break;

            case 5:
                id = scanInt("Enter id: ");
                profileDTO = profileService.findById(id);
                printProfile(profileDTO);

                profileService.delete(id);
                System.out.println("Profile deleted");
                break;

            case 6:
                System.out.println("Exit...");
                System.exit(0);
                break;

            default:
                System.out.println("Wrong command");
        }
    }

    public int scanInt(String textInConsol) {
        System.out.print(textInConsol);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String scanStr(String textInConsol) {
        System.out.print(textInConsol);
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
}
