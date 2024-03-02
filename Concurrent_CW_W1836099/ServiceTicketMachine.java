public interface ServiceTicketMachine extends Machine{

    int FULL_PAPER_TRAY = 20;
    int SHEETS_PER_PACK = 5;

    int FULL_TONER_LEVEL = 10;
    int MINIMUM_TONER_LEVEL = 10;

    // Technician methods

    void replaceTonerCartridge();

    void refillPaper();

    int getPaperLevel();
    int getTonerLevel();
}
