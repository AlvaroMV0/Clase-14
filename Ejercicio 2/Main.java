import java.util.regex.Matcher;
import java.util.regex.Pattern ;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor introduzca la ruta del archivo a leer: ");
        String dir = sc.nextLine();
        Path path = Paths.get(dir);

        System.out.print("Por favor introduzca un regex válido para comparar el archivo a leer: ");
        final String regex = sc.nextLine();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher;

        for (String linea : Files.readAllLines(path)) {
            matcher = pattern.matcher(linea);
            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }
        }
    }
}