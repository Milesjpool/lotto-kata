import calculation.results.CalculationResult;
import calculation.results.UnsuccessfulResult;
import io.ResultPrinter;
import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        CalculationResult result = new UnsuccessfulResult();

        Printable resultPrinter = new ResultPrinter(result);
        resultPrinter.print(System.out);
    }
}
