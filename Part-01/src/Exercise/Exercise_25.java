package Exercise;

// Exercise 25 - Encapsulation
class Printer {
    private int tonerLevel, pagesPrinted = 0;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if ((tonerAmount + this.tonerLevel) > 100) return -1;
            else this.tonerLevel += tonerAmount;
        }
        return -1;
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (duplex) return pagesToPrint = ((pagesToPrint / 2) + pagesPrinted);
        else return pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}

public class Exercise_25 {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);

        System.out.println(printer.addToner(50));
        System.out.println("Initial Page Count: " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(4);

        System.out.println("Pages Printed: " + pagesPrinted + " - " + "Total print count: " + printer.getPagesPrinted());

        pagesPrinted = printer.printPages(2);

        System.out.println("Pages Printed: " + pagesPrinted + " - " + "Total print count: " + printer.getPagesPrinted());
    }
}
