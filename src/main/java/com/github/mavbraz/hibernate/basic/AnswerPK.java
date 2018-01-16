package com.github.mavbraz.hibernate.basic;

import java.io.Serializable;

public class AnswerPK implements Serializable {

    private static final long serialVersionUID = 3031503601855075865L;

    protected int id;
    protected Question question;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
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
        if (!(obj instanceof AnswerPK)) {
            return false;
        }
        AnswerPK other = (AnswerPK) obj;
        if (id != other.id) {
            return false;
        }
        if (question == null) {
            if (other.question != null) {
                return false;
            }
        } else if (!question.equals(other.question)) {
            return false;
        }
        return true;
    }

}
