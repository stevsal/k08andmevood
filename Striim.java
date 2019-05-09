import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;


public class Striim {
  public static void main(String[] args) throws Exception{
    PrintWriter printerBoy = new PrintWriter(new FileWriter("v2ljund.txt"));
    printerBoy.println("Autod millel on 2.0 või suuremad mootorid.");

    Files.readAllLines(Paths.get("cars.txt")).stream().
    filter(x -> Double.parseDouble(x.split(" ")[1]) >=2.0)
    .sorted(Comparator.comparing(x -> x.split(" ")[0]))
    .map(x -> "Autol " + x.split(" ")[0] + " on " + x.split(" ")[1] + " Liitrine mootor.")
    .collect(Collectors.toList()).forEach(printerBoy::println);
    System.out.println("Esimene striim tehtud.");
    printerBoy.println("Autod mis on kohvimasinad on...");

    Files.readAllLines(Paths.get("cars.txt")).stream().
    filter(x1 -> Double.parseDouble(x1.split(" ")[1]) < 2.0)
    .sorted(Comparator.comparing(x1 -> x1.split(" ")[0]))
    .map(x1 -> x1.split(" ")[0] + " millel on "+ x1.split(" ")[1] + " liitrine mootor.").
    collect(Collectors.toList()).forEach(printerBoy::println);

    printerBoy.close();
  }
}
