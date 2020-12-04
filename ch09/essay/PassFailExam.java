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
        setScore(100.0 - numMissed * pointsEach);
    }

    /** Copy Constructor */
    public PassFailExam(PassFailExam pfe) {
        this(pfe.getNumQuestions(), pfe.getNumMissed(), 
                pfe.getMinPassingScore());
    }

    /** Getters */
    public double getPointsEach()   { return pointsEach;   }
    public int    getNumQuestions() { return numQuestions; }
    public int    getNumMissed()    { return numMissed;    }

    @Override
    public String toString() {
        return super.toString()
            + "\nPassFailExam Details: "
            + "\n\tQuestions:   "        + numQuestions
            + "\n\tPoints Each: "        + pointsEach
            + "\n\tMisses:      "        + numMissed;
    }
}
