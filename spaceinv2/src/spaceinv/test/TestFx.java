package spaceinv.test;

/*
    Visual testing with FX


public class TestFx extends Application {

    TestShip ship;
    List<TestProjectile> projs = new ArrayList<>();
    Ground ground;

    public void update() {

        ship.move();
        TestProjectile t = (TestProjectile) ship.fire();
        if( t != null){
            projs.add(t);
        }

        for (TestProjectile p : projs) {
            p.move();
        }
        render();
    }

    public void render() {
        gc.clearRect(0, 0, 400, 400);

        Image si = AssetManager.getImageForObject(ship);
        gc.drawImage(si, ship.getMinX(), ship.getMinY());


        for (TestProjectile p : projs) {
            Image pi = AssetManager.getImageForObject(p);
            gc.drawImage(pi, p.getMinX(), p.getMinY());
        }


        Image g = AssetManager.getImageForObject(ground);
        gc.drawImage(g, ground.getMinX(), ground.getMinY(), ground.getWidth(), ground.getHeight());

    }

    public void init() {
        ship = new TestShip();
        TestProjectile p = new TestProjectile();
        ship.setProjectile(p);
        projs.add(p);
        ground = new Ground(0, 400-20, 400, 20);
    }

    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(400, 400);
        root.setCenter(canvas);
        gc = canvas.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {
            // Param not used
            public void handle(long currentNanoTime) {
                update();

            }
        };
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();
}
    }*/

