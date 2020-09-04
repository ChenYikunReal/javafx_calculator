package sample;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Text text = new Text("");

    public void start(Stage pr) {
        text.setFill(Color.BLACK);
        text.setFont(Font.font("黑体", 30));
        String[] numArr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        Button[] b = new Button[10];
        String[] m = { "Mc", "Mr", "M+", "M-", "Ms" };
        Button[] m1 = new Button[5];
        String[] operate= {"÷","×","-","+","="};
        Button[] o=new Button[5];
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 5; i++) {
            m1[i] = new Button(m[i]);
            m1[i].setPrefSize(64, 40);
            m1[i].setStyle("-fx-base: lightblue");
        }
        for(int i=0;i<5;i++) {
            o[i]=new Button(operate[i]);
            o[i].setPrefSize(80, 40);
            String s=operate[i].toString();
            o[i].setOnAction(e->add(s));
        }
        Button zc = new Button("%");
        // zc.setOnAction(e->add("%")); 处理有问题
        Button ce = new Button("CE");
        ce.setOnAction(e->add("CE"));
        Button yes = new Button("?");
        Button x2 = new Button("x²");
        Button x1 = new Button("1/x");
        Button c = new Button("C");
        c.setOnAction(e->add("CE"));
        Button del = new Button("←");
        del.setOnAction(e->add("←"));
        Button reverse = new Button("±");
        reverse.setOnAction(e->add("±"));
        Button point = new Button(".");
        for (int i = 0; i < 10; i++) {
            b[i] = new Button(numArr[i]);
            b[i].setPrefSize(80, 40);
            b[i].setStyle("-fx-base:white");
        }
        ce.setPrefSize(80, 40);
        zc.setPrefSize(80, 40);
        yes.setPrefSize(80, 40);
        x2.setPrefSize(80, 40);
        x1.setPrefSize(80, 40);
        c.setPrefSize(80, 40);
        del.setPrefSize(80, 40);
        reverse.setPrefSize(80, 40);
        point.setPrefSize(80, 40);
        ce.setStyle("-fx-base: pink");
        zc.setStyle("-fx-base: red");
        yes.setStyle("-fx-base:Orange");
        x2.setStyle("-fx-base: yellow");
        x1.setStyle("-fx-base: green");
        c.setStyle("-fx-base: BLUEVIOLET");
        del.setStyle("-fx-base: blue");
        o[0].setStyle("-fx-base: Lightgreen");
        o[1].setStyle("-fx-base: CADETBLUE");
        o[2].setStyle("-fx-base: DARKKHAKI");
        o[3].setStyle("-fx-base: CHARTREUSE");
        o[4].setStyle("-fx-base: DARKGRAY");
        reverse.setStyle("-fx-base: DEEPPINK");
        point.setStyle("-fx-base: AQUA");
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(8, 8, 8, 8));
        HBox hbox = new HBox();
        hbox.getChildren().addAll(m1[0], m1[1], m1[2], m1[3], m1[4]);
        BorderPane pane1 = new BorderPane();
        pane1.setRight(text);
        pane1.setBottom(hbox);
        pane.setTop(pane1);
        gridPane.add(zc, 0, 0);
        gridPane.add(yes, 1, 0);
        gridPane.add(x2, 2, 0);
        gridPane.add(x1, 3, 0);
        gridPane.add(ce, 0, 1);
        gridPane.add(c, 1, 1);
        gridPane.add(del, 2, 1);
        for(int i=0;i<5;i++) {
            gridPane.add(o[i], 3, i+1);
        }
        for (int i = 2, count = 7; i < 5; i++, count = count - 3) {
            for (int j = 0; j < 3; j++) {
                gridPane.add(b[count + j], j, i);
            }
        }
        gridPane.add(b[0], 1, 5);
        gridPane.add(reverse, 0, 5);
        gridPane.add(point, 2, 5);
        pane.setCenter(gridPane);
        for (int i = 0; i < 10; i++) {
            String carriage = String.valueOf(i);
            b[i].setOnAction(e -> add(carriage));
        }
        Scene scene = new Scene(pane);
        pr.setTitle("计算器");
        pr.setScene(scene);
        pr.show();
    }

    private void add(String s) {
        String out = "";
        String originText = text.getText();
        if (originText.equals("0") || originText.equals("表达式错误")) {
            text.setText("");
        }
        switch (s) {
            case "CE":
            case "C":
                out = "0";
                break;
            case "±":
                try {
                    out = String.valueOf(Integer.parseInt(originText) * (-1));
                } catch (NumberFormatException e) {
                    out = "表达式错误";
                }
                break;
            case "+":
            case "-":
            case "×":
            case "÷":
                out = originText + " " + s + " ";
                break;
            case "%":
                try {
                    float getNum = Float.parseFloat(originText);
                    double setNum = Math.pow(getNum, 2d);
                    if (setNum % 1 == 0) {
                        out = String.valueOf((int) setNum);
                    } else {
                        out = String.valueOf(setNum);
                    }
                } catch (NumberFormatException e) {
                    out = "表达式错误";
                }
                break;
            case "=":
                out = getResult();
                break;
            case "←":
                if (!"".equals(originText)) {
                    out = originText.substring(0, originText.length()-1);
                }
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if ("0".equals(originText)) {
                    out = s;
                } else {
                    out = originText + s;
                }
                break;
            default:
                out = originText + s;
                break;
        }
        text.setText(out);
    }

    private String getResult() {
        try {
            String[] textBox = text.getText().split(" ");
            float result = Float.parseFloat(textBox[0]);
            for (int i = 2; i < textBox.length; i += 2) {
                float num = Float.parseFloat(textBox[i]);
                switch (textBox[i-1]) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "÷":
                        result = Float.parseFloat(textBox[i-2]) / num;
                        break;
                    case "×":
                        result *= num;
                        break;
                }
            }
            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        } catch (NumberFormatException e) {
            return "表达式错误";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
