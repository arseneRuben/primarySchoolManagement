package com.primaryschools.api.service;

import com.primaryschools.api.domain.Student;
import com.primaryschools.api.repo.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.primaryschools.api.constants.Constant.PHOTO_DIRECTORY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    public Page<Student> getAll(int page, int size){
        return studentRepo.findAll( PageRequest.of(page, size, Sort.by("lastname")));
    }

    public Student getStudent(String id){
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student create(Student std){
        return studentRepo.save(std);
    }

    public void delete(Student std){
         studentRepo.delete(std);
    }

    public String uploadPhoto(String id, MultipartFile file){
        log.info("Upload photo for student {}",id);
        Student std = getStudent(id);
        String photoUrl = photoFunction.apply(id, file);
        std.setPhotoUrl(photoUrl);
        studentRepo.save(std);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = fileName -> Optional.of(fileName).filter(name->name.contains("."))
            .map(name -> name.substring(fileName.lastIndexOf(".")+1)).orElse(".png");


    private final BiFunction<String, MultipartFile, String> photoFunction=(id, image)->{
        String fileName = id+"_"+fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStoageAllocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if(Files.exists(fileStoageAllocation)){
                Files.createDirectories(fileStoageAllocation);
                Files.copy(image.getInputStream(), fileStoageAllocation.resolve(fileName),REPLACE_EXISTING );
                return ServletUriComponentsBuilder.fromCurrentContextPath().path("/contacts/image/" +fileName).toUriString();
            }
        } catch (Exception e){
            throw new RuntimeException("Unable to save image");
        }
        return null;
    };





}
