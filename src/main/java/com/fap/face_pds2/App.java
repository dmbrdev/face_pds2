package com.fap.face_pds2;

import com.fap.face_pds2.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

	private AnchorPane anchorpane;
	private VBox principalVBox;
	private HBox principalHBox;

	private MenuBar menu;

	private VBox lateralBar;
	private VBox lateralAmigos;


	private VBox postVBox; 
	private Label novoPostLabel;

	private TextArea novoPostArea;
	private HBox postHBox;

	private Button btnFotoVideo;
	private Button btnMarcarAmigo;
	private Button btnSentimentoAtividade;
	private Button btnPostar;


	public void iniciarComponentes() {

		// Pane Tela
		anchorpane = new AnchorPane();
		anchorpane.setPrefSize(800, 400);

		// VBox principal
		principalVBox = new VBox();

		// HBox principal
		principalHBox = new HBox();
		//anchorpane.getChildren().add(principalHBox);

		// Menu
		Menu facebook  = new Menu("Facebook");
		Menu paginaPrincipal = new Menu("Página Principal");
		Menu usuario = new Menu("Damiao Souza");
		Menu amigos = new Menu("Encontrar Amigos");
		Menu mais = new Menu("Mais");
		MenuItem sair = new MenuItem("Sair");
		
		sair.setOnAction(e -> {
		    
			var alerta =  new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sair do Face");
			alerta.setHeaderText(null);
			alerta.setGraphic(null);
			alerta.setContentText("Deseja realmente sair do Face?");
			alerta.showAndWait();

			if (alerta.getResult().getText().equals("OK")) {
				System.exit(0);
			}
			
		});
		mais.getItems().add(sair);
		
		
		
		// Menu Bar 
		MenuBar menuBar = new MenuBar(); 
		// Add menus a menuBar
		menuBar.getMenus().addAll(facebook, paginaPrincipal, usuario, amigos, mais);

		principalVBox.getChildren().add(menuBar);
		anchorpane.getChildren().add(principalVBox);

		principalVBox.getChildren().add(principalHBox);	


		// Barra Lateral
		lateralBar  = new VBox();
		var btnFeed = new Button("Feed de Notícias");
		var btnMsg  = new Button("Mensagens");
		var btnGrupos = new Button("Grupos");
		var btnPaginas = new Button("Páginas");
		var btnEvento = new Button("Eventos");
		var btnJogos = new Button("Jogos");
		var btnSalvos = new Button("Salvos");

		btnFeed.setPrefWidth(150);
		btnMsg.setPrefWidth(150);
		btnGrupos.setPrefWidth(150);
		btnPaginas.setPrefWidth(150);
		btnEvento.setPrefWidth(150);
		btnJogos.setPrefWidth(150);
		btnSalvos.setPrefWidth(150);

		lateralBar.getChildren().addAll(btnFeed,btnMsg, btnGrupos, btnPaginas, btnEvento, btnJogos, btnSalvos);
		lateralBar.setAlignment(Pos.TOP_LEFT);
		lateralBar.setSpacing(10);
		//lateralBar.setPrefWidth(100);
		principalHBox.getChildren().add(lateralBar);

		// VBox Post
		postVBox = new VBox();
		principalHBox.getChildren().add(postVBox);

		// Label post
		novoPostLabel = new Label("Criar nova publicação");
		postVBox.getChildren().add(novoPostLabel);

		// Area de Texto do post
		novoPostArea = new TextArea();
		postVBox.getChildren().add(novoPostArea);

		//HBox botões post
		postHBox = new HBox();
		postVBox.getChildren().add(postHBox);

		// Botões do post
		btnFotoVideo = new Button("Foto/Video");
		btnMarcarAmigo = new Button("Marcar Amigo");
		btnSentimentoAtividade = new Button("Sentimento/Atividade");
		btnPostar = new Button("Postar");

		postHBox.getChildren().addAll(btnFotoVideo, btnMarcarAmigo, btnSentimentoAtividade, btnPostar);


		lateralAmigos  = new VBox();
		var textAmigos =  new Label("Amigos");
		var btnRodrigues = new Button("Rodrigues");
		var btnSouza  = new Button("Souza");
		var btnMaria = new Button("Maria");
		var btnPedro = new Button("Pedro");
		var btnSilva = new Button("Silva");
		var btnAna = new Button("Ana");
		var btnSofia = new Button("Sofia");

		textAmigos.setPrefWidth(150);
		textAmigos.setAlignment(Pos.CENTER);
		btnRodrigues.setPrefWidth(150);
		btnSouza.setPrefWidth(150);
		btnMaria.setPrefWidth(150);
		btnPedro.setPrefWidth(150);
		btnSilva.setPrefWidth(150);
		btnAna.setPrefWidth(150);
		btnSofia.setPrefWidth(150);

		lateralAmigos.getChildren().addAll(textAmigos,btnRodrigues,btnSouza, btnMaria, btnPedro, btnSilva, btnAna, btnSofia);
		lateralAmigos.setAlignment(Pos.TOP_RIGHT);
		lateralAmigos.setSpacing(10);
		//lateralBar.setPrefWidth(100);
		principalHBox.getChildren().add(lateralAmigos);


	}

	public void iniciarLayout() {



		principalVBox.setSpacing(10);


		principalHBox.setSpacing(20);
		principalHBox.setAlignment(Pos.TOP_LEFT);


		principalHBox.setPrefSize(anchorpane.getWidth(), anchorpane.getHeight());
		novoPostArea.setPrefHeight(80);

		postVBox.setPrefWidth( anchorpane.getWidth() / 1.70);
		postVBox.setAlignment(Pos.TOP_CENTER);
		postVBox.setSpacing(20);
		postVBox.setMaxWidth(principalHBox.getWidth());

		// Lateral bar
		lateralBar.setPrefWidth((anchorpane.getWidth() - postVBox.getWidth()) / 2);
		lateralBar.setMinWidth(140);
		lateralBar.setAlignment(Pos.CENTER);

		// Lateral Amigos
		lateralAmigos.setPrefWidth((anchorpane.getWidth() - postVBox.getWidth()) / 2);
		lateralAmigos.setMinWidth(140);
		lateralAmigos.setAlignment(Pos.CENTER);




		postHBox.setAlignment(Pos.TOP_CENTER);
		postHBox.setSpacing(10);

		//		principalHBox.setStyle("-fx-border-color: red");
		//		postVBox.setStyle("-fx-border-color: red");
		//		lateralBar.setStyle("-fx-border-color: green");
	}


	public void iniciarBtnEvents() {

		// Botão Postar
		btnPostar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (novoPostArea.getText().equals("")){

				}
				else {
					//novoPost();
					var conteudo = novoPostArea.getText();
					var post = new Post(conteudo, postVBox);
					novoPostArea.clear();
				}
			}
		});
		
		
	}

	
	@Override
	public void start(Stage stage) {
		iniciarComponentes();
		iniciarBtnEvents();

		// Criar nova Scene
		var scene = new Scene(anchorpane);

		stage.setScene(scene);
		stage.show();
		iniciarLayout();

	}

	public static void main(String[] args) {
		launch();
	}
}