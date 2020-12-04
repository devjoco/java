/**
 * TestScores Class -- Programming Challenge 7 p179
 *
 * Design a TestScores class that has fields to hold three test scores. 
 *
 * The class should have accessor and mutator methods for the test score 
 * fields, and a method that returns the average of the test scores. 
 */
public class TestScores {
    private double score1;
    private double score2;
    private double score3;

    public double getScore1() { return score1; }
    public double getScore2() { return score2; }
    public double getScore3() { return score3; }
    public double getAverage() { return (score1 + score2 + score3) / 3; }

    public void setScore1(double sc1) { score1 = sc1; }
    public void setScore2(double sc2) { score2 = sc2; }
    public void setScore3(double sc3) { score3 = sc3; }
}
