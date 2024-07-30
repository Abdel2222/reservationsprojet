package be.iccbxl.pid.reservationsSpringboot.config;

import be.iccbxl.pid.reservationsSpringboot.model.Show;
import be.iccbxl.pid.reservationsSpringboot.model.Tag;
import be.iccbxl.pid.reservationsSpringboot.repository.ShowRepository;
import be.iccbxl.pid.reservationsSpringboot.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class DataInitializer {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TagRepository tagRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Créer des shows
       // Show show1 = new Show("Show 1", "Description 1", "posterUrl1", null, true, 100);
       // Show show2 = new Show("Show 2", "Description 2", "posterUrl2", null, true, 150);
       // showRepository.save(show1);


        // Créer des tags
        Tag tag1 = new Tag();
      //  tag1.setTag("Comedy");
      //  tagRepository.save(tag1);



        // Associer des tags aux shows
      //  show1.addTag(tag1);

      //  showRepository.save(show1);

    }
}

