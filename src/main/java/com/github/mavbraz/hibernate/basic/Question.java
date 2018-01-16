package com.github.mavbraz.hibernate.basic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question implements Serializable {

    @Id
    private int id;
    private String question;
    private int answer;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    private String image;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question other = (Question) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        String message = String.format("Id: %d%n", this.id);
        message += String.format("Question: %s%n", this.question);
        message += String.format("Answer: %d%n", this.answer);
        message += String.format("Category: %s%n", this.category);
        message += String.format("Image: %s%n", this.image);
        message += "Answers:";
        if (message.length() > 0) {
            message += "\n";
            message = answers.stream().map((a) -> String.format("[%d] %s%n", a.getId(), a.getAnswer())).reduce(message, String::concat);
        } else {
            message += "Not found%n";
        }

        return message;
    }
}
