package spaceinv.view;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import spaceinv.model.Factory;
import spaceinv.model.IDrawable;
import spaceinv.model.SpaceInv;
import spaceinv.service.EventService;

import java.util.List;

import static spaceinv.model.SpaceInv.HEIGHT;
import static spaceinv.model.SpaceInv.WIDTH;
import static spaceinv.service.EventService.SIEvent;

/*
 * The GUI for the SpaceInv game.
 * No application logic here just GUI and event handling
 *
 * Run this to run the game
 *
 * See: https://www.youtube.com/watch?v=axlx3o0codc
 *
 *
 */
public class SpaceInvGUI extends Application {
    private SpaceInv spaceInv;          // The game
    private boolean running = false;    // Is game running?
    public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    // ------- Keyboard handling ----------------------------------

    private void keyPressed(KeyEvent event) {
        if (!running) {
            return;
        }
        KeyCode kc = event.getCode();
        switch (kc) {
            case LEFT:
                if(spaceInv.getGun().getMinX()>0)
                    spaceInv.getGun().setDx(-5);
                else
                    spaceInv.getGun().setDx(0);
                break;
            case RIGHT:
                if(spaceInv.getGun().getMinX() + spaceInv.getGun().getWidth() < WIDTH)
                    spaceInv.getGun().setDx(5);
                else
                    spaceInv.getGun().setDx(0);
                break;
            case SPACE:
                spaceInv.fireGun();
                break;
            default:  // Nothing
        }
        spaceInv.getGun().move();

    }

    private void keyReleased(KeyEvent event) {
        if (!running) {
            spaceInv.getGun().setDx(0);
            return;
        }
        KeyCode kc = event.getCode();
        switch (kc) {
            case LEFT:
                spaceInv.getGun().setDx(0);
            case RIGHT:
                spaceInv.getGun().setDx(0);
                break;
            default: // Nothing
                break;
        }
        spaceInv.getGun().move();
    }

    // --- Handling events coming form the model -----

    private void handleSIEvent(SIEvent evt) {
        if (evt.type == EventService.Type.ROCKET_HIT_SHIP) {
            IDrawable a = (IDrawable) evt.data;
            renderExplosion(a.getMinX(), a.getMinY());
            AssetManager.getSound("explosion1").play(0.5);
        } else if (evt.type == EventService.Type.ROCKET_LAUNCHED) {
            AssetManager.getSound("rocket").play(0.1);
        } else if (evt.type == EventService.Type.BOMB_HIT_GROUND) {
            AssetManager.getSound("explosion2").play(0.1);
        } else if (evt.type == EventService.Type.BOMB_HIT_GUN || evt.type == EventService.Type.SHIP_HIT_GROUND) {
            IDrawable a = (IDrawable) evt.data;
            renderExplosion(a.getMinX(), a.getMinY());
/* // TODO
            alert.setTitle("GAME OVER");
            if(evt.type == EventService.Type.BOMB_HIT_GUN)
                alert.setHeaderText("A BOMB HIT YOUR GUN");
            else
                alert.setHeaderText("A SHIP REACHED THE GROUND");
            alert.setContentText("Better luck next time!");
*/
            running = false;
        }
    }

    // ************* Nothing to do below (but see debug comment *************

    // ---- Menu handling -----------------

    private void handleMenu(ActionEvent e) {
        MenuItem mi = (MenuItem) e.getSource();
        switch (mi.getText()) {
            case "New":
                newGame();
                break;
            case "Exit":
                System.exit(0);
                break;
            case "Play":
                toggleMusic();
                break;
            default: // Nothing
        }
    }

    // ---------- Menu actions ---------------------

    private void newGame() {
        spaceInv = Factory.buildModel();
        timer.start();
        AssetManager.getSound("music").play(0.1);
        running = true;
    }

    private void toggleMusic() {
        AudioClip music = AssetManager.getSound("music");
        if (music.isPlaying()) {
            music.stop();
            setCheckedMenuItemSelected("Play", false);
        } else {
            music.play(0.1);
            setCheckedMenuItemSelected("Play", true);
        }
    }

    // See renderGame
    private boolean renderDebug = false;// TODO //true;  <----------------- Uncomment to debug graphics!!

    private void renderGame(GraphicsContext g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        if (renderDebug) {
            renderDebug(spaceInv.getGround());
            renderDebug(spaceInv.getMovables());
        } else {
            g.drawImage(AssetManager.getImage("background"), 0, 0);
            render(spaceInv.getGround());
            render(spaceInv.getMovables());
            renderPoints(spaceInv.getPoints(), renderDebug);
        }
    }

    private void render(List<IDrawable> movables) {
        for (int i = movables.size() - 1; i >= 0; i--) {
            IDrawable m = movables.get(i);
            render(m);
        }
    }

    private void render(IDrawable drawable) {
        Image img = AssetManager.getImageForObject(drawable);
        gc.drawImage(img, drawable.getMinX(), drawable.getMinY(),drawable.getWidth(), drawable.getHeight());
    }

    private void renderDebug(List<IDrawable> movables) {
        for (int i = movables.size() - 1; i >= 0; i--) {
            IDrawable m = movables.get(i);
            renderDebug(m);
        }
    }

    private void renderDebug(IDrawable drawable) {
        gc.strokeRect(drawable.getMinX(), drawable.getMinY(), drawable.getWidth(), drawable.getHeight());
    }

    private void renderPoints(int points, boolean debug) {
        Paint old = gc.getFill();
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(18));
        gc.fillText(String.valueOf(points), 50, 50);
        gc.setFill(old);
    }

    private void renderExplosion(double x, double y) {
        if (renderDebug) {
            return;
        }
        new Explosion(gc, x, y).start();
    }

    private MenuBar menuBar;

    private void setCheckedMenuItemSelected(String name, boolean b) {
        menuBar.getMenus().forEach(m -> {
            List<MenuItem> is = m.getItems().filtered(i -> i.getText().equals(name));
            if (is.size() > 0) {
                ((CheckMenuItem) is.get(0)).setSelected(b);
            }
        });
    }

    private AnimationTimer timer;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();

        // Menu
        menuBar = getMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        pane.setTop(menuBar);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        pane.setCenter(canvas);

        gc = canvas.getGraphicsContext2D();

        timer = new AnimationTimer() {
            // Param not used
            public void handle(long currentNanoTime) {
                // Run as fast as possible (change speed for even faster moves)
                spaceInv.update();
                SpaceInvGUI.this.handleSIEvent(EventService.remove());
                renderGame(gc);
            }
        };

        Group root = new Group();
        root.getChildren().add(pane);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::keyPressed);
        scene.setOnKeyReleased(this::keyReleased);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        primaryStage.show();
    }

    // ----------- Build Menu -------------------

    private MenuBar getMenu() {
        Menu menuFile = new Menu("File");
        MenuItem[] menuFileItems = {
                getMenuItem("New", false),
                getMenuItem("Exit", false),
        };
        menuFile.getItems().addAll(menuFileItems);

        Menu menuMusic = new Menu("Music");
        MenuItem[] menuMusicItems = new MenuItem[]{
                getCheckMenuItem("Play", true)
        };
        menuMusic.getItems().addAll(menuMusicItems);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuMusic);

        // Set same event handler for all
        menuBar.getMenus().forEach(m -> {
            m.getItems().forEach(mi -> {
                mi.setOnAction(this::handleMenu);
            });
        });

        return menuBar;
    }

    private MenuItem getMenuItem(String text, boolean b) {
        MenuItem mi = new MenuItem(text);
        mi.setDisable(b);
        return mi;
    }

    private MenuItem getCheckMenuItem(String text, boolean b) {
        CheckMenuItem mi = new CheckMenuItem(text);
        mi.setSelected(b);
        return mi;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
