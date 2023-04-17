package com.mycompany.tipcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PrimaryController {
    
  private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
    
     // formatters for currency and percentages
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();

    @FXML
    private Label AmountLabel;

    @FXML
    private Button CalculateTip;

    @FXML
    private TextField EmptyLabel;

    @FXML
    private TextField FinalTotal;

    @FXML
    private Slider TipSlider;

    @FXML
    private TextField AmountTextField;

    @FXML
    private Label TipLabel;

    @FXML
    private GridPane TipProject;

    @FXML
    private Label TipWordLabel;

    @FXML
    private Label TotalLabel;

    @FXML
    void calculatepressed(ActionEvent event) {
       try {
         BigDecimal amount = new BigDecimal(AmountTextField.getText());
         BigDecimal tip = amount.multiply(tipPercentage);
         BigDecimal total = amount.add(tip);

        EmptyLabel.setText(currency.format(tip));
         FinalTotal.setText(currency.format(total));
      }
      catch (NumberFormatException ex) {
         AmountTextField.setText("Enter amount");
         AmountTextField.selectAll();
         AmountTextField.requestFocus();
      }
   }

   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // listener for changes to tipPercentageSlider's value
      TipSlider.valueProperty().addListener(
         new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
                 tipPercentage= 
               BigDecimal.valueOf(newValue.intValue() / 100.0);
               TipLabel.setText(percent.format(tipPercentage));
            }
         }
      );
   }
} 
 
    
    

    
