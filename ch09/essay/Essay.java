/**
 * Determines the grade a student receives on an essay.
 */
public class Essay extends GradedActivity { 
    private double contentPts;  /* 30pts */
    private double grammarPts;  /* 30pts */
    private double lengthPts;   /* 20pts */
    private double spellingPts; /* 20pts */

    /** Constructs an Essay with given pts for each section */
    public Essay(double c, double g, double l, double s) {
        contentPts  = c;
        grammarPts  = g;
        lengthPts   = l;
        spellingPts = s;
        setScore(c + g + l + s);
    } 

    /** Copy Constructor */
    public Essay(Essay e) {
        this(e.getContentPts(), e.getGrammarPts(), 
                e.getLengthPts(), e.getSpellingPts());
    }

    /** Getters */
    public double getContentPts()  { return contentPts;  }
    public double getGrammarPts()  { return grammarPts;  }
    public double getLengthPts()   { return lengthPts;   }
    public double getSpellingPts() { return spellingPts; }

    /** Setters */
    public void setContentPts(double pts)  { contentPts  = pts; }
    public void setGrammarPts(double pts)  { grammarPts  = pts; }
    public void setLengthPts(double pts)   { lengthPts   = pts; }
    public void setSpellingPts(double pts) { spellingPts = pts; }

    @Override
    public String toString() {
        return super.toString() 
            + "\nEssay Details:"
            + "\n\tContent:  "   + contentPts
            + "\n\tGrammar:  "   + grammarPts
            + "\n\tLength:   "   + lengthPts
            + "\n\tSpelling: "   + spellingPts;
    }
}
