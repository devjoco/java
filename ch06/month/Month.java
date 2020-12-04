public class Month {
    private int monthNumber;

    public Month() {
        monthNumber = 1;
    }
    public Month(int num) {
        monthNumber = num;
    }
    public Month(String name) {
        monthNumber = swapMonthRepr(name);
    }

    public void setMonthNumber(int num) {
        if(num < 1 || 12 < num) {
            monthNumber = 1;
        } else {
            monthNumber = num;
        }
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName() {
        return swapMonthRepr(monthNumber);
    }

    public String toString() {
        return getMonthName();
    }

    public boolean equals(Month obj) {
        return this.monthNumber == obj.monthNumber;
    }

    public boolean greaterThan(Month obj) {
        return this.monthNumber > obj.monthNumber;
    }

    public boolean lessThan(Month obj) {
        return this.monthNumber < obj.monthNumber;
    }

    private int swapMonthRepr(String name) {
        int ans;
        switch(name.toLowerCase()) {
            case "january":
                ans = 1;
                break;
            case "february":
                ans = 2;
                break;
            case "march":
                ans = 3;
                break;
            case "april":
                ans = 4;
                break;
            case "may":
                ans = 5;
                break;
            case "june":
                ans = 6;
                break;
            case "july":
                ans = 7;
                break;
            case "august":
                ans = 8;
                break;
            case "september":
                ans = 9;
                break;
            case "october":
                ans = 10;
                break;
            case "november":
                ans = 11;
                break;
            case "december":
                ans = 12;
                break;
            default:
                ans = 1;
                break;
        }
        return ans;
    }

    private String swapMonthRepr(int ord) {
        String ans;
        switch(ord) {
            case 1:
                ans = "January";
                break;
            case 2:
                ans = "February";
                break;
            case 3:
                ans = "March";
                break;
            case 4:
                ans = "April";
                break;
            case 5:
                ans = "May";
                break;
            case 6:
                ans = "June";
                break;
            case 7:
                ans = "July";
                break;
            case 8:
                ans = "August";
                break;
            case 9:
                ans = "September";
                break;
            case 10:
                ans = "October";
                break;
            case 11:
                ans = "November";
                break;
            case 12:
                ans = "December";
                break;
            default:
                ans = "January";
                break;
        }
        return ans;
    }
}
