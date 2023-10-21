import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadData implements DownloadDataInterface {
    private static DownloadData instance;
    private DownloadData() {}
    public static DownloadData getInstance() {
        if (instance == null) {
            instance = new DownloadData();
        }
        return instance;
    }
    @Override
    public String downloadXML(String url) {
        try {
            URL xmlUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) xmlUrl.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder xmlData = new StringBuilder();
                String inputLine;

                while ((inputLine = reader.readLine()) != null) {
                    xmlData.append(inputLine);
                }

                reader.close();
                return xmlData.toString();
            } else {
                System.err.println("Error while downloading XML file. Response code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}