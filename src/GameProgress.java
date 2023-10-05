import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGames(String address) {
        try {
            File files = new File("D://Games/savegames/players.txt");
            if (files.createNewFile())
                System.out.println("Игра сохранена");
        } catch (Exception e) {
            System.err.println(e);
        }

        FileInputStream fin = null;
        try {
            fin = new FileInputStream("D://Games/savegames/players.txt");
            int i;
            StringBuilder str = new StringBuilder();
            while ((i = fin.read()) != -1) {
                str.append((char) i);
            }
            System.out.println(str);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        try (FileWriter wr = new FileWriter("D://Games/savegames/players.txt")) {
            wr.write(fin.toString());
            wr.append('\n');
            wr.append('!');
            wr.flush();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void zipFiles(Object GameProgress,String address) throws FileNotFoundException {
        String filePath = "D://Games/savegames/players.txt";
        String zipPath = "D://Games/savegames/players_zip.zip";
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
                File fileToZip = new File(filePath);
                zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                Files.copy(fileToZip.toPath(), zipOut);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
