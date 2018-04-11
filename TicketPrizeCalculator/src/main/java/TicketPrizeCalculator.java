import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        Printable calculationResult = new TicketPrizeCalculation(args).execute();

        calculationResult.print(System.out);
    }

}
