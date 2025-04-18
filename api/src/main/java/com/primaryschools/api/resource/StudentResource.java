package com.primaryschools.api.resource;

import com.primaryschools.api.domain.Student;
import com.primaryschools.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.primaryschools.api.constants.Constant.PHOTO_DIRECTORY;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentResource {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.created(URI.create("/students/<user IO>")).body(studentService.create(student));
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(studentService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(studentService.getStudent(id));
    }

    @PutMapping("/photo")
    public ResponseEntity<String> updatePhoto(@RequestParam("id") String id, @RequestParam("file")MultipartFile file) {
        return ResponseEntity.ok().body(studentService.uploadPhoto(id, file));
    }

    @GetMapping(path="image/{filename}")
    public byte[] getPhoto(@PathVariable( "filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(PHOTO_DIRECTORY + filename));
    }
}
