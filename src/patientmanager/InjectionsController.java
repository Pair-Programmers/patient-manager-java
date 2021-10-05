/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;

import Interface.Injection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author mianh
 */
public class InjectionsController implements Initializable {

     @FXML
    private Pane addEditorPane;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Label label;
    
    @FXML
    private Label label2;
    
     @FXML
    private Label oldPriceLable;

    @FXML
    private Pane listEditorPane;

    @FXML
    private ComboBox<String> injectionsComboBox;

    @FXML
    private TextField newPriceTextField;

    private Injection injection;
    private ArrayList<Injection> injectionArrayList;
    private ObservableList injectionComboBoxObservavleList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        injection = new Injection();
        injectionArrayList = injection.getAllInjection();
        injectionComboBoxObservavleList = FXCollections.observableArrayList();
        for (int i = 0; i < injectionArrayList.size(); i++) {
            injectionComboBoxObservavleList.add(injectionArrayList.get(i).getName());
        }
        
        injectionsComboBox.setItems(injectionComboBoxObservavleList);
    }  
    
      @FXML
    void panalAddButtonActionListner(ActionEvent event) {
        clearField();
        addEditorPane.setVisible(true);
        listEditorPane.setVisible(false);
    }

    @FXML
    void panalUpdateButtonActionListner(ActionEvent event) {
        clearField();
        addEditorPane.setVisible(false);
        listEditorPane.setVisible(true);
    }

    @FXML
    void saveButtonActionListner(ActionEvent event) {
        label.setText("");
        if(!nameTextField.getText().equals("")){
            if(!priceTextField.getText().equals("")){
                if(!injection.isInjectionNameExist(nameTextField.getText())){
                    try {
                    
                        float price = Float.parseFloat(priceTextField.getText());
                        injection.setName(nameTextField.getText());
                        injection.setPrice(price);
                        injection.addInjection(injection);
                        injectionComboBoxObservavleList.add(nameTextField.getText());

                        label.setText("Injection Saved Successfully");
                    } catch (Exception e) {
                        label.setText("Invalid Price");
                    }
                }else{
                    label.setText("Injection Already exist with this name");
                }
                
            }
        }
    }

    @FXML
    void updateInjectionActionListner(ActionEvent event) {
         label2.setText("");
        if(!injectionsComboBox.getSelectionModel().isEmpty()){
            try {

                float price = Float.parseFloat(newPriceTextField.getText());
                injection.setName(injectionsComboBox.getSelectionModel().getSelectedItem().toString());
                injection.setPrice(price);
                injection.updateInjection(injection);

                label2.setText("Injection Updated Successfully");
            } catch (Exception e) {
                label2.setText("Invalid Price");
            }
        }else{
            label2.setText("Injection not selected");
        }
    }
    
     @FXML
    void injectionComboBoxActionListner(ActionEvent event) {
        String injectionName = injectionsComboBox.getSelectionModel().getSelectedItem().toString();
        for (int i = 0; i < injectionArrayList.size(); i++) {
            if(injectionArrayList.get(i).getName().equals(injectionName)){
                oldPriceLable.setText(String.valueOf(injectionArrayList.get(i).getPrice()));
                //System.out.println("price : " + injectionArrayList.get(i).getPrice());
                break;
            }
        }
    }
    
    void clearField(){
        label.setText("");
        label2.setText("");
        nameTextField.setText("");
        oldPriceLable.setText("-----");
        priceTextField.setText("");
        newPriceTextField.setText("");
        injectionsComboBox.getSelectionModel().clearSelection();
    }

    
}
