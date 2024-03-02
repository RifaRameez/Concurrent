public class LaserPrinter implements ServicePrinter {

    private final Document document;
    private final String printerID;
    private int tonerLevel;
    private int paperLevel;
    private final int printedDocuments;
    private int tries = 0;
    private final int MAX_TRY = 3;


    public LaserPrinter(Document document, String printerID, int tonerLevel, int paperLevel, int printedDocuments) {
        this.document = document;
        this.printerID = printerID;
        this.tonerLevel = tonerLevel;
        this.paperLevel = paperLevel;
        this.printedDocuments = printedDocuments;
    }

    @Override
    public synchronized void printDocument(Document document) {
        while (document.getNumberOfPages() > paperLevel || tonerLevel < Minimum_Toner_Level) {
            try {
                if (tries == MAX_TRY){
                    System.out.println("Maximum tries reached...");
                    break;
                }
                System.out.println("Waiting for paper or toner to be refilled...");
                wait();
                tries++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tonerLevel -= tonerLevel;
        paperLevel -= paperLevel;
        notifyAll();
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        while(tonerLevel > Minimum_Toner_Level) {
            try {
                System.out.println("Toner cannot be replaced now...");
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tonerLevel += PagesPerTonerCartridge;
        notifyAll();
    }

    @Override
    public synchronized void refillPaper() {
        while (paperLevel > Full_Paper_Tray) {
            try {
                System.out.println("Paper cannot be refilled now...");
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        paperLevel += SheetsPerPack;
        notifyAll();
    }

    @Override
    public String toString() {
        return "LaserPrinter{" +
                "document=" + document +
                ", printerID='" + printerID + '\'' +
                ", tonerLevel=" + tonerLevel +
                ", paperLevel=" + paperLevel +
                ", printedDocuments=" + printedDocuments +
                '}';
    }
}
