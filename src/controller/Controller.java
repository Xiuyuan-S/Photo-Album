package controller;

import model.IAlbumModel;
import view.IView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Instantiates controller to decide which data to load and how to process and selection of views
 */
public class Controller implements IController{
    private final IAlbumModel model;
    private final String fileName;
    private final IView view;
    public Controller(IAlbumModel model, String fileName, IView view) {
        this.model = model;
        this.fileName = fileName;
        this.view = view;
    }

    @Override
    public void functionControll() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(this.fileName));
        // implements program by set up commands
        while (scanner.hasNext()) {
            switch (scanner.next().toLowerCase()) {
                case "#" -> scanner.nextLine();
                case "shape" ->
                        this.model.createShape(scanner.next(), scanner.next(),
                        scanner.nextDouble(), scanner.nextDouble(),
                        scanner.nextDouble(), scanner.nextDouble(),
                        scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                case "color"
                        -> this.model.changeColor(scanner.next(), scanner.nextDouble(), scanner.nextDouble(),
                                scanner.nextDouble());
                case "resize"
                        -> this.model.resize(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                case "move"
                        -> this.model.move(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                case "remove"
                        -> this.model.remove(scanner.next());
                case "snapshot"
                        -> this.model.takeSnapshot(scanner.nextLine());
                case "quit"
                        -> this.model.reboot();
            }
        }
        this.view.render(this.model);
    }
}
