package be.iccbxl.pid.reservationsSpringboot.service;

import be.iccbxl.pid.reservationsSpringboot.model.Tag;
import be.iccbxl.pid.reservationsSpringboot.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public List<Tag> getAll() {
        // Utiliser StreamSupport pour convertir Iterable en List
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Tag get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Tag> tag = repository.findById(indice);
        return tag.orElse(null);
    }

    public Tag get(long id) {
        Optional<Tag> tag = repository.findById(id);
        return tag.orElse(null);
    }

    public void add(Tag tag) {
        repository.save(tag);
    }

    public void update(long id, Tag tag) {
        Optional<Tag> optionalExistingTag = repository.findById(id);
        if (optionalExistingTag.isPresent()) {
            Tag existingTag = optionalExistingTag.get();
            existingTag.setTag(tag.getTag());
            repository.save(existingTag);
        }
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}

