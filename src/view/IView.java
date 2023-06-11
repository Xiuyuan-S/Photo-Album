package view;

import model.IAlbumModel;
import model.Snapshot;

public interface IView {
    void setCurrentSnapshot(Snapshot currentSnapshot);

    void render(IAlbumModel model);
}
