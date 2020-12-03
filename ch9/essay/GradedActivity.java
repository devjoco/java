public class GradedActivity {
    private double score;

    /** Set the GA's score to the given grade.  */
    public void setScore(double s) {
        score = s;
    }

    /** Return the GA's score.  */
    public double getScore() {
        return score;
    }

    /** Convert the GA's numeric score into a letter grade.  */
    public char getGrade() {
        return score >= 90? 'A':
               score >= 80? 'B':
               score >= 70? 'C':
               score >= 60? 'D': 'F';
    }

    @Override
    public String toString() {
        return super.toString()
            + "\nGradedActivity Details:"
            + "\n\tScore: "               + score
            + "\n\tGrade: "               + getGrade();
    }
}
