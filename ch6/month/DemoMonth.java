public class DemoMonth {
    public static void main(String[] args) {
        Month m1 = new Month();
        Month m2 = new Month(3);
        Month m3 = new Month("may");
        Month m4 = new Month("July");
        Month m5 = new Month();
        Month m6 = new Month();
        Month m7 = new Month();
        m5.setMonthNumber(10);
        m6.setMonthNumber(19);
        m7.setMonthNumber(-19);

        System.out.printf("m1(%s) == m2(%s): %b\n", m1, m2, m1.equals(m2));
        System.out.printf("m1(%s) == m5(%s): %b\n", m1, m5, m1.equals(m5));
        System.out.printf("m1(%s) == m6(%s): %b\n", m1, m6, m1.equals(m6));
        System.out.printf("m1(%s) == m7(%s): %b\n", m1, m7, m1.equals(m7));

        System.out.println();
        System.out.printf("m2(%s) > m2(%s): %b\n", m2, m2, m2.greaterThan(m2));
        System.out.printf("m2(%s) > m3(%s): %b\n", m2, m3, m2.greaterThan(m3));
        System.out.printf("m2(%s) > m7(%s): %b\n", m2, m7, m2.greaterThan(m7));

        System.out.println();
        System.out.printf("m3(%s) < m4(%s): %b\n", m3, m4, m3.lessThan(m4));
        System.out.printf("m3(%s) < m5(%s): %b\n", m3, m5, m3.lessThan(m5));
        System.out.printf("m3(%s) < m7(%s): %b\n", m3, m7, m3.lessThan(m7));
    }
}
