import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GameProgress player1 = new GameProgress(100, 4, 2, 34.6);
        GameProgress player2 = new GameProgress(65, 34, 65, 23.12);
        GameProgress player3 = new GameProgress(23, 59, 78, 123.45);
        player1.saveGames("D://Games/savegames/players.txt");
        player2.saveGames("D://Games/savegames/players.txt");
        player3.saveGames("D://Games/savegames/players.txt");
        player1.zipFiles(player1, "D://Games/savegames/players.txt");
        player2.zipFiles(player2, "D://Games/savegames/players.txt");
        player3.zipFiles(player3, "D://Games/savegames/players.txt");









    }
}