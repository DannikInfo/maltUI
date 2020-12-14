package dannikinfo.malt.uiconstructor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    public GridPane mainPane;
    public TextField hexText;
    public GridPane settingsPane;
    // str 0
    public CheckBox pixel00;
    public CheckBox pixel10;
    public CheckBox pixel20;
    public CheckBox pixel30;
    public CheckBox pixel40;
    public CheckBox pixel50;
    public CheckBox pixel60;
    public CheckBox pixel70;
    // str 1
    public CheckBox pixel01;
    public CheckBox pixel11;
    public CheckBox pixel21;
    public CheckBox pixel31;
    public CheckBox pixel41;
    public CheckBox pixel51;
    public CheckBox pixel61;
    public CheckBox pixel71;
    //str 2
    public CheckBox pixel02;
    public CheckBox pixel12;
    public CheckBox pixel22;
    public CheckBox pixel32;
    public CheckBox pixel42;
    public CheckBox pixel52;
    public CheckBox pixel62;
    public CheckBox pixel72;
    // str 3
    public CheckBox pixel03;
    public CheckBox pixel13;
    public CheckBox pixel23;
    public CheckBox pixel33;
    public CheckBox pixel43;
    public CheckBox pixel53;
    public CheckBox pixel63;
    public CheckBox pixel73;
    //str 4
    public CheckBox pixel04;
    public CheckBox pixel14;
    public CheckBox pixel24;
    public CheckBox pixel34;
    public CheckBox pixel44;
    public CheckBox pixel54;
    public CheckBox pixel64;
    public CheckBox pixel74;
    //str 5
    public CheckBox pixel05;
    public CheckBox pixel15;
    public CheckBox pixel25;
    public CheckBox pixel35;
    public CheckBox pixel45;
    public CheckBox pixel55;
    public CheckBox pixel65;
    public CheckBox pixel75;
    //str 6
    public CheckBox pixel06;
    public CheckBox pixel16;
    public CheckBox pixel26;
    public CheckBox pixel36;
    public CheckBox pixel46;
    public CheckBox pixel56;
    public CheckBox pixel66;
    public CheckBox pixel76;
    //str 7
    public CheckBox pixel07;
    public CheckBox pixel17;
    public CheckBox pixel27;
    public CheckBox pixel37;
    public CheckBox pixel47;
    public CheckBox pixel57;
    public CheckBox pixel67;
    public CheckBox pixel77;

    private Map<String, Boolean> displayBlock = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("main.fxml"))));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.setTitle("МЭЛТ UI Constructor");
        primaryStage.getIcons().add(new Image("/resources/icon.png" ));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void onTextFieldTextChanged() {
        String hex = hexText.getText();
        if(hex.isEmpty()) return;
        hexToMap(hex);
        int x = 0;
        int y = 0;
        int maxX = 8;
        int maxY = 8;
        for(; y < maxY; y++){
            for(; x < maxX; x++){
                screenSet(x, y, displayBlock.get(x+":"+y));
            }
            x = 0;
        }
    }

    private boolean screenGet(int x, int y){
        switch(y) {
            case 0:
                switch(x){
                    case 0:
                        return pixel00.isSelected();
                    case 1:
                        return pixel10.isSelected();
                    case 2:
                        return pixel20.isSelected();
                    case 3:
                        return pixel30.isSelected();
                    case 4:
                        return pixel40.isSelected();
                    case 5:
                        return pixel50.isSelected();
                    case 6:
                        return pixel60.isSelected();
                    case 7:
                        return pixel70.isSelected();
                }
                break;
            case 1:
                switch(x){
                    case 0:
                        return pixel01.isSelected();
                    case 1:
                        return pixel11.isSelected();
                    case 2:
                        return pixel21.isSelected();
                    case 3:
                        return pixel31.isSelected();
                    case 4:
                        return pixel41.isSelected();
                    case 5:
                        return pixel51.isSelected();
                    case 6:
                        return pixel61.isSelected();
                    case 7:
                        return pixel71.isSelected();
                }
                break;
            case 2:
                switch(x){
                    case 0:
                        return pixel02.isSelected();
                    case 1:
                        return pixel12.isSelected();
                    case 2:
                        return pixel22.isSelected();
                    case 3:
                        return pixel32.isSelected();
                    case 4:
                        return pixel42.isSelected();
                    case 5:
                        return pixel52.isSelected();
                    case 6:
                        return pixel62.isSelected();
                    case 7:
                        return pixel72.isSelected();
                }
                break;
            case 3:
                switch(x){
                    case 0:
                        return pixel03.isSelected();
                    case 1:
                        return pixel13.isSelected();
                    case 2:
                        return pixel23.isSelected();
                    case 3:
                        return pixel33.isSelected();
                    case 4:
                        return pixel43.isSelected();
                    case 5:
                        return pixel53.isSelected();
                    case 6:
                        return pixel63.isSelected();
                    case 7:
                        return pixel73.isSelected();
                }
                break;
            case 4:
                switch(x){
                    case 0:
                        return pixel04.isSelected();
                    case 1:
                        return pixel14.isSelected();
                    case 2:
                        return pixel24.isSelected();
                    case 3:
                        return pixel34.isSelected();
                    case 4:
                        return pixel44.isSelected();
                    case 5:
                        return pixel54.isSelected();
                    case 6:
                        return pixel64.isSelected();
                    case 7:
                        return pixel74.isSelected();
                }
                break;
            case 5:
                switch(x){
                    case 0:
                        return pixel05.isSelected();
                    case 1:
                        return pixel15.isSelected();
                    case 2:
                        return pixel25.isSelected();
                    case 3:
                        return pixel35.isSelected();
                    case 4:
                        return pixel45.isSelected();
                    case 5:
                        return pixel55.isSelected();
                    case 6:
                        return pixel65.isSelected();
                    case 7:
                        return pixel75.isSelected();
                }
                break;
            case 6:
                switch(x){
                    case 0:
                        return pixel06.isSelected();
                    case 1:
                        return pixel16.isSelected();
                    case 2:
                        return pixel26.isSelected();
                    case 3:
                        return pixel36.isSelected();
                    case 4:
                        return pixel46.isSelected();
                    case 5:
                        return pixel56.isSelected();
                    case 6:
                        return pixel66.isSelected();
                    case 7:
                        return pixel76.isSelected();
                }
                break;
            case 7:
                switch(x){
                    case 0:
                        return pixel07.isSelected();
                    case 1:
                        return pixel17.isSelected();
                    case 2:
                        return pixel27.isSelected();
                    case 3:
                        return pixel37.isSelected();
                    case 4:
                        return pixel47.isSelected();
                    case 5:
                        return pixel57.isSelected();
                    case 6:
                        return pixel67.isSelected();
                    case 7:
                        return pixel77.isSelected();
                }
                break;
        }
        return false;
    }

    private void screenSet(int x, int y, boolean bool){
        switch(y) {
            case 0:
                switch(x){
                    case 0:
                        pixel00.setSelected(bool);
                        break;
                    case 1:
                        pixel10.setSelected(bool);
                        break;
                    case 2:
                        pixel20.setSelected(bool);
                        break;
                    case 3:
                        pixel30.setSelected(bool);
                        break;
                    case 4:
                        pixel40.setSelected(bool);
                        break;
                    case 5:
                        pixel50.setSelected(bool);
                        break;
                    case 6:
                        pixel60.setSelected(bool);
                        break;
                    case 7:
                        pixel70.setSelected(bool);
                        break;
                }
                break;
            case 1:
                switch(x){
                    case 0:
                        pixel01.setSelected(bool);
                        break;
                    case 1:
                        pixel11.setSelected(bool);
                        break;
                    case 2:
                        pixel21.setSelected(bool);
                        break;
                    case 3:
                        pixel31.setSelected(bool);
                        break;
                    case 4:
                        pixel41.setSelected(bool);
                        break;
                    case 5:
                        pixel51.setSelected(bool);
                        break;
                    case 6:
                        pixel61.setSelected(bool);
                        break;
                    case 7:
                        pixel71.setSelected(bool);
                        break;
                }
                break;
            case 2:
                switch(x){
                    case 0:
                        pixel02.setSelected(bool);
                        break;
                    case 1:
                        pixel12.setSelected(bool);
                        break;
                    case 2:
                        pixel22.setSelected(bool);
                        break;
                    case 3:
                        pixel32.setSelected(bool);
                        break;
                    case 4:
                        pixel42.setSelected(bool);
                        break;
                    case 5:
                        pixel52.setSelected(bool);
                        break;
                    case 6:
                        pixel62.setSelected(bool);
                        break;
                    case 7:
                        pixel72.setSelected(bool);
                        break;
                }
                break;
            case 3:
                switch(x){
                    case 0:
                        pixel03.setSelected(bool);
                        break;
                    case 1:
                        pixel13.setSelected(bool);
                        break;
                    case 2:
                        pixel23.setSelected(bool);
                        break;
                    case 3:
                        pixel33.setSelected(bool);
                        break;
                    case 4:
                        pixel43.setSelected(bool);
                        break;
                    case 5:
                        pixel53.setSelected(bool);
                        break;
                    case 6:
                        pixel63.setSelected(bool);
                        break;
                    case 7:
                        pixel73.setSelected(bool);
                        break;
                }
                break;
            case 4:
                switch(x){
                    case 0:
                        pixel04.setSelected(bool);
                        break;
                    case 1:
                        pixel14.setSelected(bool);
                        break;
                    case 2:
                        pixel24.setSelected(bool);
                        break;
                    case 3:
                        pixel34.setSelected(bool);
                        break;
                    case 4:
                        pixel44.setSelected(bool);
                        break;
                    case 5:
                        pixel54.setSelected(bool);
                        break;
                    case 6:
                        pixel64.setSelected(bool);
                        break;
                    case 7:
                        pixel74.setSelected(bool);
                        break;
                }
                break;
            case 5:
                switch(x){
                    case 0:
                        pixel05.setSelected(bool);
                        break;
                    case 1:
                        pixel15.setSelected(bool);
                        break;
                    case 2:
                        pixel25.setSelected(bool);
                        break;
                    case 3:
                        pixel35.setSelected(bool);
                        break;
                    case 4:
                        pixel45.setSelected(bool);
                        break;
                    case 5:
                        pixel55.setSelected(bool);
                        break;
                    case 6:
                        pixel65.setSelected(bool);
                        break;
                    case 7:
                        pixel75.setSelected(bool);
                        break;
                }
                break;
            case 6:
                switch(x){
                    case 0:
                        pixel06.setSelected(bool);
                        break;
                    case 1:
                        pixel16.setSelected(bool);
                        break;
                    case 2:
                        pixel26.setSelected(bool);
                        break;
                    case 3:
                        pixel36.setSelected(bool);
                        break;
                    case 4:
                        pixel46.setSelected(bool);
                        break;
                    case 5:
                        pixel56.setSelected(bool);
                        break;
                    case 6:
                        pixel66.setSelected(bool);
                        break;
                    case 7:
                        pixel76.setSelected(bool);
                        break;
                }
                break;
            case 7:
                switch(x){
                    case 0:
                        pixel07.setSelected(bool);
                        break;
                    case 1:
                        pixel17.setSelected(bool);
                        break;
                    case 2:
                        pixel27.setSelected(bool);
                        break;
                    case 3:
                        pixel37.setSelected(bool);
                        break;
                    case 4:
                        pixel47.setSelected(bool);
                        break;
                    case 5:
                        pixel57.setSelected(bool);
                        break;
                    case 6:
                        pixel67.setSelected(bool);
                        break;
                    case 7:
                        pixel77.setSelected(bool);
                        break;
                }
                break;
        }
    }


    private void hexToMap(String hex){
        ArrayList<String> biCode = stringToBiList(hex);
        int x = 0;
        int y = 7;
        for(String b : biCode){
            b = zeroFixB(b);
            for(char c : b.toCharArray()){
                boolean bool = false;
                if(c == '0')
                    bool = false;
                if(c == '1')
                    bool = true;
                displayBlock.put(x+":"+y, bool);
                y--;
            }
            y = 7;
            x++;
        }
    }

    private String mapToHex(){
        String hex = "";
        ArrayList<String> biCode = new ArrayList<>();
        int x = 0;
        int y = 7;
        for(; x < 8; x++){
            String row = "";
            for(; y >= 0 ; y--){
                boolean b = displayBlock.get(x+":"+y);
                if(b)
                    row += 1;
                else
                    row += 0;
            }
            biCode.add(row);
            y = 7;
        }
        int j = 0;
        for(String bi : biCode){
            hex += "0x"+zeroFixH(Integer.toHexString(Integer.parseInt(bi, 2)));
            if(j != 7)
                hex +=",";
            j++;
        }
        return hex;
    }

    private String zeroFixB(String bi){
        String biNew = bi;
        if(bi.length() < 8){
            for(int i = 0; i < 8 - bi.length(); i++)
                biNew = 0+biNew;
        }
        return biNew;
    }

    private String zeroFixH(String hex){
        String hexNew = hex;
        if(hex.length() < 2){
            for(int i = 0; i < 2 - hex.length(); i++)
                hexNew = 0+hexNew;
        }
        return hexNew;
    }

    public static ArrayList<String> stringToBiList(String strA) {
        strA = strA.replaceAll("\\[", "");
        strA = strA.replaceAll("\\]", "");
        String[] strArray = strA.split(",");
        //remove trash symbols
        ArrayList<String> clear = new ArrayList<>();
        for (String str : strArray) {
            str = str.replaceAll("\\,", "");
            str = str.replaceAll(" ", "");
            str = str.replaceAll("0x", "");
            if(!str.equalsIgnoreCase(""))
                clear.add(Integer.toBinaryString(Integer.parseInt(str, 16)));
        }
        return clear;
    }

    public void onCBClick(MouseEvent mouseEvent) {
        int x = 0;
        int y = 0;
        int maxX = 8;
        int maxY = 8;
        for(; y < maxY; y++) {
            for (; x < maxX; x++) {
                displayBlock.put(x + ":" + y, screenGet(x, y));
            }
            x = 0;
        }
        String hex = mapToHex();

        hexText.setText(hex);
    }

    public void clear(MouseEvent mouseEvent) {
        hexText.setText("0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00");
        onTextFieldTextChanged();
    }
}
