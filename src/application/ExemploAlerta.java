package application;

import java.util.Arrays;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExemploAlerta extends Application{
	
	private Button button01 = new Button("Exemplo 01");
	private Button button02 = new Button("Exemplo 02");
	private Button button03 = new Button("Exemplo 03");
	private Button button04 = new Button("Exemplo 04");
	private Button button05 = new Button("Exemplo 05");
	private Button button06 = new Button("Exemplo 06");
	private Button button07 = new Button("Exemplo 07");
	
	@Override
	public void init() throws Exception {
		super.init();
		
		button01.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informa��o");
				alert.setHeaderText(null);
				alert.setContentText("Voc� clicou no evento01");
				alert.show();
			}
		});
		
		button02.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Cuidado");
				alert.setContentText("Voc� clicou no evento02");
				alert.show();
			}
		});
		
		button03.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confima��o");
				alert.setHeaderText("Essa opera��o � um pouco cr�tica");
				alert.setContentText("Voc� deseja realmente excluir?");
				Optional<ButtonType> resposta = alert.showAndWait();
				if(resposta.get().equals(ButtonType.OK))
				{
					System.out.println("Ok");
				}
				else if(resposta.get().equals(ButtonType.CANCEL))
				{
					System.out.println("Cancel");
				}
			}
		});
		
		button04.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informa��o");
				alert.setHeaderText("Detalhes");
				alert.setContentText("Voc� clicou no bot�o 4 .. mais info");
				
				Label label = new Label("Outros detalhes");
				alert.getDialogPane().setExpandableContent(label);
				
				alert.show();
			}
		});
		//adicionando outros botoes
		button05.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.NONE);
				alert.setTitle("Informa��o");
				alert.setHeaderText("Outros bot�es");
				alert.setContentText("Selecione uma das op��es:");
				
				ButtonType buttonSim = new ButtonType("Sim");
				ButtonType buttonNao = new ButtonType("N�o");
				ButtonType buttonmaybe = new ButtonType("Maybe");
				ButtonType buttoncerteza = new ButtonType("I'm sure!", ButtonData.CANCEL_CLOSE);
				
				alert.getButtonTypes().addAll(buttonSim, buttonNao, buttonmaybe, buttoncerteza);
				
				Optional<ButtonType> resposta = alert.showAndWait();
				System.out.println(resposta.get().getText());
				
				alert.show();
			}
		});
		
		button06.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				TextInputDialog dialog = new TextInputDialog("Palmas");
				dialog.setTitle("Munic�pio");
				dialog.setHeaderText("Cabe�alho");
				dialog.setContentText("Informe o nome da sua cidade");
				
				Optional<String> resultado = dialog.showAndWait();
				if(resultado.isPresent())//verifica se digitou
				{
					System.out.println("A cidade digitada foi " + resultado.get());
				}
			}
		});

		button07.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ChoiceDialog<String> dialog = new ChoiceDialog<String>("Palmas", 
											Arrays.asList("Aragua�na", "Para�so", "Palmas"));
				
				Optional<String> resultado = dialog.showAndWait();
				System.out.println(resultado.get());
;
				}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox root = new VBox();
		root.getChildren().addAll(button01, button02, button03, button04, button05, button06, button07);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		
		Scene scene = new Scene(root, 300, 500);// cira cena para o stage como parametro no root
		// largura e altura
		
		primaryStage.setScene(scene);// adiciona a cena ao stage e mostra a aplicacao
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
