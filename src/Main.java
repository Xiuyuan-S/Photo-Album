import controller.Controller;
import controller.IController;
import model.AlbumModel;
import model.IAlbumModel;
import view.GraphicalView;
import view.SVGView;

import java.io.FileNotFoundException;


/**
 * program entry.
 */
public class Main {
    static String nameOfInputfile;
    static String nameOfOutputfile;
    static String typeOfView;
    static int maxX;
    static int maxY;

    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0; i < args.length - 1; i++) {
            try {
                maxX = Integer.parseInt(args[i]);
                maxY = Integer.parseInt(args[i + 1]);
            } catch (NumberFormatException e) {
                maxX = 1000;
                maxY = 1000;
            }
            switch (args[i].toLowerCase()) {
                case "-in":
                    nameOfInputfile = args[i+1];
                    break;
                case "-out":
                    nameOfOutputfile = args[i+1];
                    break;
                case "-v":
                case "-view":
                    typeOfView = args[i+1];
                    break;
                default:
            }

        }
        // exceptions
        if (nameOfInputfile == null || typeOfView == null) {
            System.err.println("Please enter the name of your file");
            System.exit(1);
        }
        if (typeOfView.equalsIgnoreCase("web") && (nameOfOutputfile == null)) {
            System.err.println("Need a name to your output file");
            System.exit(1);
        }

        IAlbumModel albumModel = new AlbumModel();

        //choose graphical view
        if (typeOfView.equalsIgnoreCase("graphical")) {
            IController controller = new Controller(albumModel, nameOfInputfile,
                    new GraphicalView("CS 5004 Shapes Photo Album Viewer", maxX, maxY));
            controller.functionControll();
        }

        // choose web view
        if (typeOfView.equalsIgnoreCase("web")) {
            if (null == nameOfOutputfile) {
                nameOfOutputfile = "webView.html";
            }
            IController controller = new Controller(albumModel, nameOfInputfile,
                    new SVGView(nameOfOutputfile, maxX, maxY));
            controller.functionControll();
        }


    }
}