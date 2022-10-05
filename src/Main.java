/*
1 För de här uppgifterna kommer du att behöva en List<> (generisk lista) med objekt.
Skapa objekt som innehåller följande information om länder. Poängen med de här uppgifterna är att lösa dem med java Streams.
 Jämför dina lösningar med en studiekamrat.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //TODO
        //need to do task eight and nine is not finish it.


        List<Lista> streams = new ArrayList<>();

        streams.add(0, new Lista<>("Sverige", "Stockholm",10.07,450_295));
        streams.add(1, new Lista("Norge","Oslo", 5.27, 323_802));
        streams.add(2, new Lista("Island", "Reykjavik", 0.33, 102_775));
        streams.add(3, new Lista("Danmark", "Köpenhamn", 5.75, 42_931));
        streams.add(4, new Lista<>( "Finland", "Helsinki", 5.51, 338_424));
        streams.add(5, new Lista<>("Belgien", "Bryssel", 11.30, 30_528));
        streams.add(6, new Lista<>("Tyskland", "Berlin", 82.18, 357_168));
        streams.add(7, new Lista<>("Frankrike", "Paris", 66.99, 640_679));
        streams.add(8, new Lista<>("Storbritannien", "London", 60.80, 209_331));
        streams.add(9, new Lista<>("Niue", "Alofi", 0.0016, 261));
        streams.add(10, new Lista("Mongoliet", "Ulan Batar", 3.08, 1_566_000));
        streams.add(11, new Lista<>("Polen", "Warszawa", 38.63, 312_679));
        streams.add(12, new Lista("Spanien", "Madrid", 46.5, 505_990));
        streams.add(13, new Lista("Portugal", "Lissabon", 10.31, 92_212));
        streams.add(14, new Lista<>("Italien", "Rom", 60.59, 301_338));
        streams.add(15, new Lista("Grekland", "Aten", 11.18, 131_957));
        streams.add(16, new Lista("Luxemburg", "Luxemburg", 0.58, 2_586));
        streams.add(17, new Lista<>("Liechtenstein", "Vaduz", 0.038, 160));



        //secondTask(streams);
        //thirdTask(streams);
        //fourth(streams);
        //fifth(streams);
        //sixth(streams);
        //seventh(streams);
        //eighth(streams);
        //ninth(streams);   it is not finish it
        //tenth(streams);
        //eleventh(streams);
        //twelfth(streams);
        //thirteenthTask(streams);
        //fourteenthTask();  it is not finish it
        //fifteenthTask(streams);
        //sixteenthTaskA(streams); it is not finish it
        //sixteenthTaskB(streams); it is not finish it
        //seventeenthTaks(streams); it is not finish it
        //eighteenthTask(streams);
        //nineteenthTask(streams);


    }

    private static void nineteenthTask(List<Lista> streams) {
        /*
        19 Skriv ut hur stor befolkning alla länder vars namn är 7 tecken långt har tillsammans.
         */
        streams.stream()
                .filter(e -> (e.getName().length() >7))
                .forEach(System.out::println);

    }

    private static void eighteenthTask(List<Lista> streams) {
        /*
        18 Skriv ut hur stor befolkning de 6 minsta länderna har tillsammans. Skriv också ut hur stor befolkning de 3 största länderna har tillsammans.
         */
        Double sum = streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .limit(6)
                .mapToDouble(Lista::getPopulation)
                .sum();

        streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .limit(6)
                .forEach(System.out::println);

        System.out.println("Den här är sum : " + sum);

        streams.stream()
                .filter(x -> x.getPopulation() > 0)
                .sorted(Comparator.comparing(Lista::getPopulation,Comparator.reverseOrder()))
                .limit(3)
                .forEach(System.out::println);


    }

    private static void seventeenthTaks(List<Lista> streams) {
        /*
        17 Skriv ut namnet på alla länder, sorterat fallande efter deras huvudstäders namn baklänges.
        Till exempel kommer Tyskland före Niue, eftersom Alofi → ifola kommer före Berlin → nilreB.
         */
    }

    private static void sixteenthTaskB(List<Lista> streams) {
        /*
        16b Skriv ut namnet på alla länder och hur trångbodda de är. Trångboddheten räknar du ut genom att
        ta befolkningsmängden delat med arean. Räkna om befolkningsmängden till faktiska tal som i 16a först.
         */
    }

    private static void sixteenthTaskA(List<Lista> streams) {
        /*
        16a Skriv ut namnet och befolkningsmängden för alla länder, men räkna om befolkningsmängden till faktiska tal.
        Alltså ska till exempel 1.5 miljoner skrivas ut som 1500000.
         */
        streams.stream()
                .filter(x -> x.getPopulation() > 0)
                .sorted(Comparator.comparing(Lista::getName))
                .mapToInt(i -> (int) i.getPopulation())
                .forEach(System.out::println);


    }
    private static void fifteenthTask(List<Lista> streams) {
        /*
        15 Skriv ut hur många länder det finns som har en befolkning på X miljoner och deras namn.
        Sortera dem i bokstavsordning på namnet. Befolkningsmängden ska avrundas nedåt till ett heltal.
         Utskriften ska se ut ungefär så här:
            Länder med 0 miljoner invånare:
            - Island
            - Niue
            Länder med 3 miljoner invånare:
            - Mongoliet
            osv.
         */
        System.out.println("Länd med 0 miljoner invånare");
        streams.stream()
                .filter(i ->  i.getPopulation() > 0 )
                .filter(i -> i.getPopulation() < 3)
                .sorted(Comparator.comparing(Lista::getName))
                .forEach(System.out::println);

        System.out.println("\nLänd med 3 miljoner invånare till 10 miljoner");
        streams.stream()
                .filter(i ->  i.getPopulation() > 3 )
                .filter(i -> i.getPopulation() < 10)
                .sorted(Comparator.comparing(Lista::getName))
                .forEach(System.out::println);

        System.out.println("\nLänd över 10 miljoner invånare");
        streams.stream()
                .filter(i ->  i.getPopulation() > 10 )
                .sorted(Comparator.comparing(Lista::getName))
                .forEach(System.out::println);
    }

    private static void fourteenthTask() {
        /*
        14 Skriv ut hur många länder det finns som börjar på varje bokstav som finns i listan.
        Exempelvis så finns det två länder vars namn börjar på S, ett som börjar på D och två som börjar på F.
         */
    }

    private static void thirteenthTask(List<Lista> streams) {
        /*
        13 Skriv ut namnen på upp till tre länder som har en area på minst 500 000 km2, sorterade fallande efter namn.
         */

        streams.stream()
                .filter(i -> i.getArea() < 500_000)
                .limit(3)
                .sorted(Comparator.comparing(Lista::getName))
                .forEach(System.out::println);
    }

    private static void twelfth(List<Lista> streams) {
        /*
         Skriv ut de tre första länderna som har minst folkmängd och över 7 miljoner.
        Exempelvis kommer Norge inte med för det har bara 5 miljoner, men Sverige har 10 miljoner så det kommer med.
         */
        streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .forEach(System.out::println);

        /*
            randomNumber.ints(0,100)
                .distinct()
                .limit(2)
                .forEach(System.out::println);

        System.out.println(randomNumber);
         */
    }

    private static void eleventh(List<Lista> streams) {
        /*
        11 Skriv ut de fem första länderna som har minst folkmängd.
         */
        streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .limit(5)
                .forEach(System.out::println);
    }

    private static void tenth(List<Lista> streams) {
        /*
        Skriv ut alla land vars namn är längre än namnet på deras huvudstad.
         */
        streams.stream()
                .filter((o1-> o1.getName().length() > o1.getCapital().length()))
                .forEach(System.out::println);
    }

    private static void ninth(List<Lista> streams) {
        /*
        9 Skriv ut namn och huvudstad för alla länder vars huvudstad börjar på samma bokstav som landets namn.
         */
        streams.stream()
                .filter(i -> i.getName().equals(i.getCapital()))
                .forEach(System.out::println);


        // .equals(i.getCapital()))
    }

    private static void eighth(List<Lista> streams) {
        /*
        Använd tre queries för att skriva ut hur många länder som har en area över 10 000, över 100 000 och över 1 000 000 respektive.
         */

        System.out.println("This is area over 10 000km ");
        streams.stream()
                .filter(i -> i.getArea() > 10_000)
                .filter(i -> i.getArea() < 100_000)
                .forEach(System.out::println);

        System.out.println("This is area over 100 000km ");
        streams.stream()
                .filter(i -> i.getArea() > 100_000)
                .filter(i -> i.getArea() < 100_000_0)
                .forEach(System.out::println);

        System.out.println("This is area over 1 000 000 km ");
        streams.stream()
                .filter(i -> i.getArea() > 1_000_000)
                .forEach(System.out::println);

    }

    private static void seventh(List<Lista> streams) {
        /*
        7 Skriv ut namnen på alla länder som har en befolkning som är mindre än 5 miljoner.
         */

        streams.stream()
                .filter(i-> i.getPopulation() < 5.0)
                .forEach(System.out::println);
    }

    private static void sixth(List<Lista> streams) {
        /*
        6 Skriv ut genomsnittsarean och hur många länder som har en mindre area än genomsnittet.
         */
        IntSummaryStatistics stats = streams.stream()
                .mapToInt(Lista::getArea)
                .summaryStatistics();

        System.out.println("Den här är genomsnitt: " + stats.getAverage());

        streams.stream()
                .filter(i-> i.getArea() < stats.getAverage())
                .forEach(System.out::println);

    }

    private static void fifth(List<Lista> streams) {
        /*
        5 Skriv ut vilken den största befolkningsmängden är.
         */
        streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .reduce((first,second)-> second)
                .ifPresent(System.out::println);
    }

    private static void fourth(List<Lista> streams) {
    /*
    4 Skriv ut namnen på alla länder i listan, sorterade efter befolkning, med den högsta befolkningen först.
     */
        streams.stream()
                .sorted(Comparator.comparing(Lista::getPopulation))
                .forEach(System.out::println);
    }

    private static void thirdTask(List<Lista> streams) {
        /*
        Skriv ut namnen på alla länder i listan, sorterade i bokstavsordning.
         */

        streams.stream()
                .sorted(Comparator.comparing(Lista::getName))
                .forEach(System.out::println);
        //.sorted((i,a)-> i.getName().compareTo(a.getName()))

    }

    public static void secondTask(List<Lista> streams){
        /*
        Skriv ut namnet på det första och det sista landet i listan på konsolen.
         */

        streams.stream()
                .findFirst().ifPresent(System.out::println);

        streams.stream()
                //.peek((num -> System.out.println("will filter " + num)))
                .reduce((first,second) -> second)
                .ifPresent(System.out::println);



    }
}