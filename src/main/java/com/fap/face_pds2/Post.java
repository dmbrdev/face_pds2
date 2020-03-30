package com.fap.face_pds2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Post {

	private String autor = "Damião Souza";
	private TitledPane post = new TitledPane();
	private VBox postPaneVBox = new VBox();

	private int curtidas = 0;
	private int comentarios = 0;
	private int compartilhamentos = 0;

	private Label ttCurtidas = new Label(curtidas+" Curtida(s)");
	private Label ttComentarios = new Label(comentarios+" Comentario(s)");
	private Label ttCompartilhamentos = new Label(compartilhamentos+" Compartilhamentos(s)");


	private Button btnCurtir = new Button("Curtir");
	private Button btnComentar= new Button("Comentar");
	private Button btnCompartilhar = new Button("Compartilhar");
	private Button btnExcluir = new Button("Excluir");

	private HBox postPaneHBoxDetalhes = new HBox();
	private HBox postPaneHBoxButtons =  new HBox();

	public Post() {

	}

	public Post(String conteudo, VBox postVBox){

		post.setText(autor);

		postPaneVBox.setSpacing(15);
		
		postPaneVBox.getChildren().add(new Label(conteudo));
				
		postPaneHBoxDetalhes.setAlignment(Pos.CENTER);
		postPaneHBoxDetalhes.setSpacing(20);
		postPaneHBoxDetalhes.getChildren().addAll(ttCurtidas,ttComentarios,ttCompartilhamentos);

		postPaneVBox.getChildren().add(postPaneHBoxDetalhes);

		postPaneHBoxButtons.setPrefWidth(post.getWidth());
		postPaneHBoxButtons.setAlignment(Pos.BOTTOM_CENTER);
		postPaneHBoxButtons.setSpacing(10);
		postPaneHBoxButtons.getChildren().addAll(btnCurtir, btnComentar, btnCompartilhar, btnExcluir);

		postPaneVBox.getChildren().add(postPaneHBoxButtons);
		post.setContent(postPaneVBox);

		btnExcluir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				var alerta =  new Alert(AlertType.CONFIRMATION);
				alerta.setTitle("Excluir Post");
				alerta.setHeaderText(null);
				alerta.setGraphic(null);
				alerta.setContentText("Deseja realmente excluir este post?");
				alerta.showAndWait();

				if (alerta.getResult().getText().equals("OK")) {

					postVBox.getChildren().remove(post);

				}

			}
		});
		btnCurtir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				curtidas = curtidas + 1;

				ttCurtidas.setText(curtidas+" Curtida(s)");

			}
		});
		btnComentar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				comentarios = comentarios + 1;

				ttComentarios.setText(comentarios+" Comentarios(s)");

			}
		});

		btnCompartilhar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				compartilhamentos = compartilhamentos + 1;

				ttCompartilhamentos.setText(compartilhamentos+" Compartilhamentos(s)");

			}
		});

		// Adicionando ao painel
		postVBox.getChildren().add(post);
	}

}
