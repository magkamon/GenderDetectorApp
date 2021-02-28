package detector.domain;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TokenProvider {

    BufferedReader reader;
    String femaleJar = "src/female_tokens.jar";
    String femaleTxt = "female_tokens.txt";

    TokenProvider(String jarFilePath, String tokenFile) throws IOException {
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(jarFilePath);
        }catch (IOException ioException){
            System.out.println(ioException.getCause());
            return ;
        }

        JarEntry entry = jarFile.getJarEntry(tokenFile);
        InputStream inputStream = jarFile.getInputStream(entry);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        reader = new BufferedReader(inputStreamReader);
    }


    public Optional<String> getNextToken(){
            String line = "";
            try {
                if ((line = reader.readLine()) == null) {
                    return  Optional.empty();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return Optional.empty();
            }
//            reader.close();
            return Optional.of(line);
    }

}
