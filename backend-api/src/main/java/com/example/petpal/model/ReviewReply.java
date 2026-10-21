package com.example.petpal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "review_replies")
@Data
public class ReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String replyText;
    
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
