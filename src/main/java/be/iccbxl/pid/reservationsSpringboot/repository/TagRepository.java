package be.iccbxl.pid.reservationsSpringboot.repository;

import be.iccbxl.pid.reservationsSpringboot.model.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByTag(String tag);
}
