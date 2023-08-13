package com.quiz.together.entity;

import com.quiz.together.Enum.QuestionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue()
    private long id;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


    private String question;

    private List<String> answers;

    private List<String> correctAnswer;

    private String explanation;

    @ManyToMany(mappedBy = "questions")
    private List<Topic> topics;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

}