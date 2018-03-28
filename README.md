# lotto-kata
A command-line lottery prize finder

### To build the project

1. Clone this repository
1. In the repository root, run `./build.sh`

### To run the application

Run the following in the root of this repository:
```
java -cp TicketPrizeCalculator/build/classes/java/main TicketPrizeCalculator
```

Or alternatively:

```
export CLASSPATH="TicketPrizeCalculator/build/classes/java/main:${CLASSPATH}"
  
java TicketPrizeCalculator
```