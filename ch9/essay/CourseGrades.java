public class CourseGrades implements Analyzable {
    private GradedActivity[] grades = new GradedActivity[4];

    /** Constructor */
    public CourseGrades(GradedActivity ga, PassFailExam pfe,
            Essay e, FinalExam fe) {
        setLab(ga);
        setPassFailExam(pfe);
        setEssay(e);
        setFinalExam(fe);
    }

    /** Returns the average score of the GAs in grades. 
     * Needed for Analyzable interface */
    public double getAverage() {
        double total = 0;
        for(GradedActivity ga : grades)
            total += ga.getScore();
        return total / grades.length;
    }

    /** Returns the highest scoring GA in grades. 
     * Needed for Analyzable interface */
    public GradedActivity getHighest() {
        double highScore = 0;
        int    highIdx = 0;
        for(int i=0; i<grades.length; i++) {
            double thisScore = grades[i].getScore();
            if (thisScore > highScore) {
                highScore = thisScore;
                highIdx = i;
            }
        }
        return new GradedActivity(grades[highIdx]);
    }

    /** Returns the lowest scoring GA in grades. 
     * Needed for Analyzable interface */
    public GradedActivity getLowest() {
        double lowScore = 100;
        int    lowIdx = 0;
        for(int i=0; i<grades.length; i++) {
            double thisScore = grades[i].getScore();
            if (thisScore < lowScore) {
                lowScore = thisScore;
                lowIdx = i;
            }
        }
        return new GradedActivity(grades[lowIdx]);
    }

    /** Setters */
    public void setLab(GradedActivity ga) {
        grades[0] = new GradedActivity(ga);
    }

    public void setPassFailExam(PassFailExam pfe) {
        grades[1] = new PassFailExam(pfe);
    }

    public void setEssay(Essay e) {
        grades[2] = new Essay(e);
    }

    public void setFinalExam(FinalExam fe) {
        grades[3] = new FinalExam(fe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nCourseGrades Details:");
        for(GradedActivity ga : grades)
            sb.append("\n" + ga);
        return sb.toString();
    }
}
