package be.iccbxl.pid.reservationsSpringboot.controller;

import be.iccbxl.pid.reservationsSpringboot.model.Tag;
import be.iccbxl.pid.reservationsSpringboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAll();
        return ResponseEntity.ok(tags);
    }
}

