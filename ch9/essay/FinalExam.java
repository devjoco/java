public class FinalExam extends GradedActivity {
    private int    numQuestions;
    private int    numMissed;
    private double pointsEach;

    /** Constructor */
    public FinalExam(int questions, int missed) {
        numQuestions = questions;
        numMissed    = missed;
        pointsEach   = 100.0 / numQuestions;
        setScore(100.0 - pointsEach * numMissed);
    }

    /** Getters */
    public double getPointsEach() { return pointsEach; }
    public int    getNumMissed()  { return numMissed;  }

    @Override
    public String toString() {
        return super.toString()
            + "\nFinalExam Details:"
            + "\n\tQuestions:   "    + numQuestions
            + "\n\tPoints Each: "    + pointsEach
            + "\n\tMisses:      "    + numMissed;
    }

}
