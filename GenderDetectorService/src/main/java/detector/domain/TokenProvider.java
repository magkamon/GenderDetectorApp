package detector.domain;

import java.io.*;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TokenProvider {

    private BufferedReader reader;

    public TokenProvider(String jarFilePath, String tokenFile) throws IOException {
        JarFile jarFile = new JarFile(jarFilePath);
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
            return Optional.of(line);
    }

    public void closeReader(){
        try {
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
