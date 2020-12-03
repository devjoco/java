public class CourseGrades {
    private GradedActivity[] grades = GradedActivity[4];

    public void setLab(GradedActivity ga) {
        grades[0] = new GradedACtivity(ga);
    }
}
