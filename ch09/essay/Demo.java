public class Demo {
    public static void main(String[] args) {
        /** Test GradedActivity */
        System.out.println();
        GradedActivity myGA = new GradedActivity();
        myGA.setScore(87);
        System.out.println(myGA);

        /** Test Essay */
        System.out.println();
        Essay myE = new Essay(23, 29, 15, 10);
        System.out.println(myE);

        /** Test FinalExam */
        System.out.println();
        FinalExam myFE = new FinalExam(50, 7);
        System.out.println(myFE);

        /** Test PassFailActivity */
        System.out.println();
        PassFailActivity myPFA = new PassFailActivity(85);
        myPFA.setScore(84);
        System.out.println(myPFA);

        /** Test PassFailExam */
        System.out.println();
        PassFailExam myPFE = new PassFailExam(50, 7, 70);
        System.out.println(myPFE);

        /** Test CourseGrades */
        System.out.println();
        CourseGrades myCG = new CourseGrades(myGA, myPFE, myE, myFE);
        System.out.println(myCG);
        System.out.println(myCG.getAverage());
        System.out.println(myCG.getHighest());
        System.out.println(myCG.getLowest());
    }
}
