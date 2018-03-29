import calculation.results.UnsuccessfulResult;
import io.Printable;
import metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        Printable result = new UnsuccessfulResult();
        result.print(System.out);
    }
}
