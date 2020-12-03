public class PassFailExam extends PassFailActivity {
    private int    numQuestions;
    private int    numMissed;
    private double pointsEach;

    /** Constructs PFE with given number of questions, misses, and min score */
    public PassFailExam(int questions, int missed, double minPassing) {
        super(minPassing);
        numQuestions = questions;
        numMissed    = missed;
        pointsEach   = 100.0 / numQuestions;
    }

    /** Getters */
    public double getPointsEach() { return pointsEach; }
    public int    getNumMissed()  { return numMissed;  }

    @Override
    public String toString() {
        return super.toString()
            + "\nPassFailExam Details: "
            + "\n\tQuestions:   "        + numQuestions
            + "\n\tPoints Each: "        + pointsEach
            + "\n\tMisses:      "        + numMisses
    }
}
