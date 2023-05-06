package dev.erudayu.contentcalender.repository;

import dev.erudayu.contentcalender.model.Content;
import dev.erudayu.contentcalender.model.Status;
import dev.erudayu.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRespository {
     private final List<Content> contentList = new ArrayList<>();
     public ContentCollectionRespository(){}

     public List<Content> findAll(){
          return contentList;
     }

     public Optional<Content> findById(Integer id){
          return contentList.stream().filter(c->c.id().equals(id)).findFirst();
     }

     public void save(Content content){
          contentList.add(content);
     }

     @PostConstruct
     private void init(){
          Content c = new Content(1,"Tamil", "Article about tamil", Status.PUBLISHED, Type.ARTICLE, LocalDateTime.now(),null,"");
          contentList.add(c);
     }
}
