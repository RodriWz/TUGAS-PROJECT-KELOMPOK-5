package javafxapplication1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


public class TournamentApp extends Application {
    private Tournament tournament = new Tournament();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab tab1 = createRegistrationTab();
        Tab tab2 = createMatchTab();
        Tab tab3 = createStandingsTab(primaryStage);

        tabPane.getTabs().addAll(tab1, tab2, tab3);

        Scene scene = new Scene(tabPane, 700, 500);
        primaryStage.setTitle("Aplikasi Turnamen Sepak Bola");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createRegistrationTab() {
    Tab tab1 = new Tab("Menu Pendaftaran");
    tab1.setClosable(false);

    VBox tab1Content = new VBox(10);
    
    tab1Content.setStyle("-fx-padding: 20; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/BOLA1.jpg'); -fx-background-size: cover;");
    Text tab1Title = new Text("Pendaftaran Tim");
    tab1Title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    tab1Title.setFill(Color.WHITE);  

    Button btnRegisterTeam = new Button("Daftarkan Tim");
    btnRegisterTeam.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnRegisterTeam.setOnAction(e -> registerTeam());

    Button btnAddPlayer = new Button("Tambahkan Pemain ke Tim");
    btnAddPlayer.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnAddPlayer.setOnAction(e -> addPlayer());

    Button btnUpdateCoach = new Button("Tambahkan Nama Pelatih");
    btnUpdateCoach.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnUpdateCoach.setOnAction(e -> updateCoach());

    tab1Content.getChildren().addAll(tab1Title, btnRegisterTeam, btnAddPlayer, btnUpdateCoach);
    tab1Content.setAlignment(Pos.CENTER);
    tab1.setContent(tab1Content);
    return tab1;
}




    private Tab createMatchTab() {
    Tab tab2 = new Tab("Menu Pertandingan");
    tab2.setClosable(false);

    VBox tab2Content = new VBox(10);
    tab2Content.setStyle("-fx-padding: 20; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/BOLA1.jpg'); -fx-background-size: cover;");
    
    Text tab2Title = new Text("Pertandingan");
    tab2Title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    tab2Title.setFill(Color.WHITE);  

    Button btnScheduleMatch = new Button("Jadwalkan Pertandingan");
    btnScheduleMatch.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnScheduleMatch.setOnAction(e -> scheduleMatch()); 

    Button btnRecordScore = new Button("Catat Skor Pertandingan");
    btnRecordScore.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnRecordScore.setOnAction(e -> recordMatchResult()); 

    tab2Content.getChildren().addAll(tab2Title, btnScheduleMatch, btnRecordScore);
    tab2Content.setAlignment(Pos.CENTER); 
    tab2.setContent(tab2Content); 

    return tab2; 
}



    private Tab createStandingsTab(Stage primaryStage) {
    Tab tab3 = new Tab("Klasmen Pertandingan");
    tab3.setClosable(false);

    VBox tab3Content = new VBox(10);
    tab3Content.setStyle("-fx-padding: 20; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/BOLA1.jpg'); -fx-background-size: cover;");

    Text tab3Title = new Text("Klasemen");
    tab3Title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    tab3Title.setFill(Color.WHITE);  

    Button btnShowStandings = new Button("Tampilkan Klasemen");
    btnShowStandings.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnShowStandings.setOnAction(e -> showStandings());

    Button btnShowMatches = new Button("Tampilkan Semua Pertandingan");
    btnShowMatches.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnShowMatches.setOnAction(e -> showMatches());

    Button btnExit = new Button("Keluar");
    btnExit.setStyle("-fx-font-size: 18; -fx-background-image: url('file:/C:/Users/Rodri/Pictures/bola.jpg'); -fx-text-fill: white; -fx-padding: 15; -fx-cursor: hand;");
    btnExit.setOnAction(e -> primaryStage.close());

    tab3Content.getChildren().addAll(tab3Title, btnShowStandings, btnShowMatches, btnExit);
    tab3Content.setAlignment(Pos.CENTER);
    tab3.setContent(tab3Content);
    return tab3;
}


    private void registerTeam() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Daftarkan Tim");
        dialog.setHeaderText("Masukkan nama tim:");
        dialog.setContentText("Nama Tim:");

        dialog.showAndWait().ifPresent(name -> {
            Team newTeam = new Team("T" + (tournament.getTeams().size() + 1), name, "Masukan nama Pelatih");
            tournament.registerTeam(newTeam);
            System.out.println("Tim '" + name + "' berhasil didaftarkan.");
        });
    }
    
private void addPlayer() {
        TextInputDialog teamDialog = new TextInputDialog();
teamDialog.setTitle("Tambahkan Pemain");
teamDialog.setHeaderText("Masukkan ID Tim:");
teamDialog.setContentText("ID Tim:");

teamDialog.showAndWait().ifPresent(teamId -> {
    Team team = tournament.searchTeamById(teamId);
    if (team != null) {
        Dialog<Void> playerDialog = new Dialog<>();
        playerDialog.setTitle("Tambahkan Pemain");
        playerDialog.setHeaderText("Masukkan Nama 11 Pemain:");

        ButtonType saveButtonType = new ButtonType("Simpan", ButtonBar.ButtonData.OK_DONE);
        playerDialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField[] playerFields = new TextField[11];
        for (int i = 0; i < 11; i++) {
            Label label = new Label("Pemain " + (i + 1) + ":");
            TextField textField = new TextField();
            textField.setPromptText("Nama Pemain");
            playerFields[i] = textField;

            grid.add(label, 0, i);
            grid.add(textField, 1, i);
            GridPane.setHgrow(textField, Priority.ALWAYS);
        }

        playerDialog.getDialogPane().setContent(grid);

        playerDialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                boolean allFieldsFilled = true;
                for (TextField field : playerFields) {
                    if (field.getText().trim().isEmpty()) {
                        allFieldsFilled = false;
                        break;
                    }
                }

                if (!allFieldsFilled) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Kesalahan");
                    alert.setHeaderText("Semua Nama Pemain Harus Diisi");
                    alert.setContentText("Harap isi semua nama pemain sebelum melanjutkan.");
                    alert.showAndWait();
                    return null;
                }

                for (TextField field : playerFields) {
                    team.addPlayer(field.getText().trim());
                }

                System.out.println("11 pemain berhasil ditambahkan ke tim " + team.getName());
            }
            return null;
        });

        playerDialog.showAndWait();
    } else {
        System.out.println("Tim dengan ID " + teamId + " tidak ditemukan.");
    }
});
    }

private void updateCoach() {
    TextInputDialog teamDialog = new TextInputDialog();
    teamDialog.setTitle("Ubah Nama Pelatih");
    teamDialog.setHeaderText("Masukkan ID Tim:");
    teamDialog.setContentText("ID Tim:");

    teamDialog.showAndWait().ifPresent(teamId -> {
        Team team = tournament.searchTeamById(teamId.trim());
        if (team != null) {
            TextInputDialog coachDialog = new TextInputDialog(team.getCoach());
            coachDialog.setTitle("Ubah Nama Pelatih");
            coachDialog.setHeaderText("Nama Pelatih saat ini: " + team.getCoach());
            coachDialog.setContentText("Masukkan Nama Pelatih :");

            coachDialog.showAndWait().ifPresent(newCoachName -> {
                team.setCoach(newCoachName);
                System.out.println("Nama pelatih untuk tim '" + team.getName() + "' berhasil diubah menjadi '" + newCoachName + "'.");
            });
        } else {
            System.out.println("Tim dengan ID " + teamId + " tidak ditemukan.");
        }
    });
}

private void scheduleMatch() {
        ChoiceDialog<String> team1Dialog = new ChoiceDialog<>();
team1Dialog.setTitle("Jadwalkan Pertandingan");
team1Dialog.setHeaderText("Pilih tim pertama yang akan bertanding:");

List<String> teamNames = new ArrayList<>();
for (Team team : tournament.getTeams()) {
    teamNames.add(team.getTeamId() + ": " + team.getName());
}

team1Dialog.getItems().setAll(teamNames);

team1Dialog.showAndWait().ifPresent(team1Name -> {
    // Membuat dialog baru untuk tim kedua
    ChoiceDialog<String> team2Dialog = new ChoiceDialog<>();
    team2Dialog.setTitle("Jadwalkan Pertandingan");
    team2Dialog.setHeaderText("Pilih tim kedua yang akan bertanding:");

    List<String> filteredTeamNames = teamNames.stream()
            .filter(name -> !name.equals(team1Name))
            .collect(Collectors.toList());
    team2Dialog.getItems().setAll(filteredTeamNames);

    team2Dialog.showAndWait().ifPresent(team2Name -> {
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        Alert dateAlert = new Alert(Alert.AlertType.INFORMATION);
        dateAlert.setTitle("Pilih Tanggal Pertandingan");
        dateAlert.setHeaderText("Pilih tanggal untuk pertandingan:");
        dateAlert.getDialogPane().setContent(datePicker);

        dateAlert.showAndWait().ifPresent(response -> {
            LocalDate matchDate = datePicker.getValue();
            Team team1 = tournament.searchTeamById(team1Name.split(":")[0].trim());
            Team team2 = tournament.searchTeamById(team2Name.split(":")[0].trim());

            if (team1 != null && team2 != null) {
                String matchId = "M" + (tournament.getMatches().size() + 1);
                Match match = new Match(matchId, team1, team2, matchDate);
                tournament.addMatch(match);
                System.out.println("Pertandingan berhasil dijadwalkan: " +
                        team1.getName() + " vs " + team2.getName() +
                        " pada " + matchDate);
            }
        });
    });
});
    }
private void recordMatchResult() {
    TextInputDialog matchDialog = new TextInputDialog();
    matchDialog.setTitle("Catat Skor Pertandingan");
    matchDialog.setHeaderText("Masukkan ID Pertandingan:");
    matchDialog.setContentText("ID Pertandingan:");

    matchDialog.showAndWait().ifPresent(matchId -> {
        if (matchId.trim().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Input Tidak Valid");
            errorAlert.setHeaderText("ID Pertandingan Kosong");
            errorAlert.setContentText("Masukkan ID pertandingan yang valid.");
            errorAlert.showAndWait();
            return;
        }

        Match match = tournament.getMatchById(matchId.trim());

        if (match != null && !match.isCompleted()) {
            TextInputDialog scoreDialog1 = new TextInputDialog();
            scoreDialog1.setTitle("Catat Skor");
            scoreDialog1.setHeaderText("Masukkan skor untuk tim " + match.getTeam1().getName() + ":");
            scoreDialog1.setContentText("Skor Tim 1:");

            scoreDialog1.showAndWait().ifPresent(score1 -> {
                TextInputDialog scoreDialog2 = new TextInputDialog();
                scoreDialog2.setTitle("Catat Skor");
                scoreDialog2.setHeaderText("Masukkan skor untuk tim " + match.getTeam2().getName() + ":");
                scoreDialog2.setContentText("Skor Tim 2:");

                scoreDialog2.showAndWait().ifPresent(score2 -> {
                    try {
                        int scoreTeam1 = Integer.parseInt(score1.trim());
                        int scoreTeam2 = Integer.parseInt(score2.trim());

                        match.setScores(scoreTeam1, scoreTeam2);

                        if (scoreTeam1 > scoreTeam2) {
                            match.getTeam1().updatePoints(3);
                        } else if (scoreTeam1 < scoreTeam2) {
                            match.getTeam2().updatePoints(3);
                        } else {
                            match.getTeam1().updatePoints(1);
                            match.getTeam2().updatePoints(1);
                        }

                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Sukses");
                        successAlert.setHeaderText("Skor Berhasil Dicatat");
                        successAlert.setContentText(
                            "Hasil pertandingan: " + match.getTeam1().getName() + " " + scoreTeam1 + " - " +
                            scoreTeam2 + " " + match.getTeam2().getName()
                        );
                        successAlert.showAndWait();
                    } catch (NumberFormatException e) {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setTitle("Input Tidak Valid");
                        errorAlert.setHeaderText("Skor harus berupa angka");
                        errorAlert.setContentText("Pastikan Anda hanya memasukkan angka tanpa karakter lain.");
                        errorAlert.showAndWait();
                    }
                });
            });
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.WARNING);
            infoAlert.setTitle("Peringatan");
            infoAlert.setHeaderText("Tidak Dapat Mencatat Skor");
            infoAlert.setContentText("Pertandingan tidak ditemukan atau sudah selesai.");
            infoAlert.showAndWait();
        }
    });
}


private void showStandings() {
        StringBuilder standings = new StringBuilder("=== Klasemen ===\n\n");
        tournament.getStandings().forEach(team ->
                standings.append(team.getName()).append(" - ").append(team.getPoints()).append(" poin\n")
        );

        TextArea standingsText = new TextArea(standings.toString());
        standingsText.setEditable(false);
        standingsText.setWrapText(true);

        Alert standingsAlert = new Alert(Alert.AlertType.INFORMATION);
        standingsAlert.setTitle("Klasemen Turnamen");
        standingsAlert.setHeaderText("Daftar Klasemen");
        standingsAlert.getDialogPane().setContent(standingsText);
        standingsAlert.showAndWait();

    }

private void showMatches() {
        StringBuilder completedMatches = new StringBuilder("=== Pertandingan Selesai ===\n\n");
        StringBuilder upcomingMatches = new StringBuilder("=== Pertandingan Belum Selesai ===\n\n");

        tournament.getMatches().forEach(match -> {
            if (match.isCompleted()) {
                completedMatches.append(match.toString()).append("\n");
            } else {
                upcomingMatches.append(match.toString()).append("\n");
            }
        });

        Alert matchesAlert = new Alert(Alert.AlertType.INFORMATION);
        matchesAlert.setTitle("Semua Pertandingan");
        matchesAlert.setHeaderText("Daftar Semua Pertandingan");
        matchesAlert.setContentText(completedMatches.toString() + "\n" + upcomingMatches.toString());
        matchesAlert.showAndWait();
    }

public static void main(String[] args) {
        launch(args);
    }
}



