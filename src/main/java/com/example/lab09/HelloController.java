package com.example.lab09;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void downloadStockPrices(String ticker) throws IOException {
        String tickerURL = "https://query1.finance.yahoo.com/v7/finance/download/" + ticker + "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
        // InputStream inputStream = new URL("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true").openStream();
        // Reader reader = new InputStreamReader(input, "UTF-8");
        InputStream inputStream = new URL(tickerURL).openStream();
        // download and write in path
        Files.copy(inputStream, Paths.get("C:\\Users\\Destly\\Desktop\\University Materials\\Year2-2\\Software Development\\Lab09\\src\\main\\resources\\" + ticker + ".csv"), StandardCopyOption.REPLACE_EXISTING);
    }

    @FXML
    protected void downloadGOOG() throws IOException {
        downloadStockPrices("GOOG");
    }

    @FXML
    protected void downloadAAPL() throws IOException {
        downloadStockPrices("AAPL");
    }

    @FXML
    protected void drawLinePlot() {
        
    }

}