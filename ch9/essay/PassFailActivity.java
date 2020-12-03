public class PassFailActivity extends GradedActivity {
    private double minPassingScore;

    /** Constructor */
    public PassFailActivity(double mps) {
        minPassingScore = mps;
    }

    /** Return P if passing score, F otherwise */
    @Override
    public char getGrade() {
        return getScore() >= minPassingScore? 'P' : 'F';
    }

    @Override
    public String toString() {
        return super.toString()
            + "\nPassFailActivity Details:"
            + "\n\tminPassingScore: "       + minPassingScore;
    }
}
