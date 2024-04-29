package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@Table(name = "posts")
/*@NamedQueries(
    value = {@NamedQuery(name = "Post.testNamedQuery", query = "SELECT p FROM Post p WHERE p.content = ?1")}
)*/
public class Post {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  UUID id;

  String title;
  String content;

  @Builder.Default
  @Column(name = "created_at")
  @CreationTimestamp
  LocalDateTime createdAt = LocalDateTime.now();
}
