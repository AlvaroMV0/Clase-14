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
        int i = 0;

        for (String linea : Files.readAllLines(path)) {
            i ++;
            matcher = pattern.matcher(linea);
            if (matcher.matches())System.out.println("Linea n°" + i + ": Coincide");
            else System.out.println("Linea n°" + i + ": No coincide");
        }
    }
}
