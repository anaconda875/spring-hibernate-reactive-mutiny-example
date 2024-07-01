package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@Table(name = "posts")
@NamedQueries(
    value = {
      @NamedQuery(
          name = "Post.testNamed",
          query = "SELECT p FROM Post p WHERE p.content = :content")
    })
@NamedEntityGraphs({
  @NamedEntityGraph(
      name = "Post.testNamed",
      attributeNodes = {@NamedAttributeNode("title")})
})
public class Post {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  UUID id;

  String title;
  String content;

  @Column(name = "created_at")
  //  @CreationTimestamp
  @CreatedDate
  LocalDateTime createdAt;

  @Column(name = "last_modified_at")
  @LastModifiedDate
  LocalDateTime lastModifiedAt;

  @Column(name = "created_by")
  @CreatedBy
  String createdBy;

  @Column(name = "last_modified_by")
  @LastModifiedBy
  String lastModifiedBy;
}
