/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;

import Interface.Editor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author mianh
 */
public class EditorsController implements Initializable {

     @FXML
    private Pane addEditorPane;
     
     
    @FXML
    private Label label;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Pane listEditorPane;

    @FXML
    private TableView<Editor> editorsTableView;

    @FXML
    private TableColumn<Editor, Integer> idTableColumn;

    @FXML
    private TableColumn<Editor, String> userNameTableColumn;

    @FXML
    private TableColumn<Editor, String> passwordTableColumn;

    private ObservableList<Editor> editorTableObservavleList;
    
    Editor editor;
    String user;
    
    ArrayList<Editor> editorArrayList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editor = new Editor();
        editorArrayList = new ArrayList<>();
        
        editorTableObservavleList = FXCollections.observableArrayList();
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordTableColumn.setCellValueFactory(new PropertyValueFactory<>("paassword"));
        
        editorArrayList = editor.getAllEditor();
        for (int i = 0; i < editorArrayList.size(); i++) {
            editorTableObservavleList.add(editorArrayList.get(i));
        }
        editorsTableView.setItems(editorTableObservavleList);
    }    
    
    
    
    @FXML
    void addEditorActionListner(ActionEvent event) {
        if(!userNameTextField.getText().equals("")){
            if(!passwordTextField.getText().equals("")){
                if(!editor.isUserNameExist(userNameTextField.getText())){
                    editor.addEditor(new Editor(0, userNameTextField.getText(), passwordTextField.getText()));
                    label.setText("Added !");
                    editorTableObservavleList.add(new Editor(0, userNameTextField.getText(), passwordTextField.getText()));
                    editorsTableView.refresh();
                    userNameTextField.setText("");
                    passwordTextField.setText("");
                }
            }
        }
    }
    
    @FXML
    void addEditorPanalActionListner(ActionEvent event) {
        addEditorPane.setVisible(true);
        listEditorPane.setVisible(false);
    }

    @FXML
    void listEditorPanalActionListner(ActionEvent event) {
        addEditorPane.setVisible(false);
        listEditorPane.setVisible(true);
    }
}
